package elide.embedded.internal

import org.graalvm.polyglot.Source
import java.util.concurrent.ConcurrentHashMap
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Deferred
import kotlin.concurrent.getOrSet
import elide.annotations.Singleton
import elide.embedded.*
import elide.embedded.EmbeddedAppConfiguration.EmbeddedDispatchMode.FETCH
import elide.embedded.EmbeddedGuestLanguage.JAVA_SCRIPT
import elide.embedded.EmbeddedGuestLanguage.PYTHON
import elide.embedded.http.EmbeddedRequest
import elide.embedded.http.EmbeddedResponse
import elide.runtime.core.PolyglotContext
import elide.runtime.core.PolyglotEngine
import elide.runtime.core.PolyglotEngineConfiguration.HostAccess.ALLOW_IO
import elide.runtime.core.PolyglotValue
import elide.runtime.plugins.js.JavaScript

/**
 * A dispatcher backed by a [PolyglotEngine] instance, using thread-local contexts for evaluation. Entry points are
 * resolved and cached for every application and used during dispatch within the coroutine scope of the guest app.
 */
@Singleton internal class EmbeddedDispatcherImpl(
  private val config: EmbeddedConfiguration,
) : EmbeddedCallDispatcher {
  /**
   * Represents an abstract guest entrypoint resolved from an evaluated source, usually an executable [PolyglotValue].
   * Implementations of this interface provide the specific methods to interact with the entrypoint.
   */
  private sealed interface AppEntrypoint

  /**
   * A [fetch-style][FETCH] entrypoint, using an executable [PolyglotValue] (the 'fetch' function) exported from the
   * entrypoint module. The function must accept a request object as an argument and return a response.
   *
   * Basic validation is performed on the wrapped [value] to ensure it is executable, no further validation is
   * possible since the signature of the function is not available to the host.
   */
  @JvmInline private value class FetchEntrypoint(val value: PolyglotValue) : AppEntrypoint {
    init {
      // basic validation, the signature is opaque
      require(value.canExecute()) { "Entrypoint must be executable" }
    }

    operator fun invoke(request: EmbeddedRequest): EmbeddedResponse {
      val result = value.execute(request)

      return runCatching { result.asHostObject<EmbeddedResponse>() }.getOrElse {
        if (it !is UnsupportedOperationException) throw it
        error("Unexpected response type returned by guest entrypoint, expected <EmbeddedResponse>, found $result")
      }
    }
  }

  /** Engine used to acquire the [local context][localContext] instances for dispatch. */
  private val engine: PolyglotEngine by lazy(::prepareEngine)

  /**
   * A thread-local context used for dispatch to overcome the limitation regarding multi-threaded use of contexts with
   * single-thread languages (such as JavaScript).
   */
  private val localContext: ThreadLocal<PolyglotContext> = ThreadLocal()

  /**
   * A thread-local map of application entrypoints. Similar to the [localContext], this map is required to ensure each
   * entrypoint value is always executed while the context of origin is available.
   */
  private val entrypoints: ThreadLocal<MutableMap<EmbeddedAppId, AppEntrypoint>> =
    ThreadLocal.withInitial(::ConcurrentHashMap)

  /**
   * Prepare a [PolyglotEngine] using the active runtime [configuration][config]. Enabled languages will be installed
   * into the engine and other general settings will be adjusted.
   *
   * The lazy [engine] instance should be used instead of this function for repeated access to a stable instance,
   * otherwise the creation overhead will cause noticeable performance issues.
   */
  private fun prepareEngine(): PolyglotEngine = PolyglotEngine {
    // host IO required for accessing guest source code
    hostAccess = ALLOW_IO

    // language plugins
    for (language in config.guestLanguages) when (language) {
      JAVA_SCRIPT -> install(JavaScript) {
        wasm = false

        bindings {
          // register interop bindings for request and response types
          put("Response", ImmediateResponse::class.java)
        }
      }

      PYTHON -> error("Support for Python in guest apps is not yet available")
    }
  }

  /** Retrieve the thread-local [PolyglotContext], or acquire and cache a new one if none is available yet. */
  private fun useContext(): PolyglotContext {
    return localContext.getOrSet(engine::acquire)
  }

  /** Map between the [embedded] guest language enum and the language code string expected by a [Source] builder. */
  private fun languageCode(embedded: EmbeddedGuestLanguage): String = when (embedded) {
    JAVA_SCRIPT -> "js"
    PYTHON -> "python"
  }

  /**
   * Resolve the thread-local entrypoint for the given [app], or evaluate and cache it using the local [context]. In
   * the case of evaluation, this method evaluates the entrypoint code provided by the app and resolves an
   * [AppEntrypoint] matching the app's dispatch mode.
   */
  private fun useEntrypoint(app: EmbeddedApp, context: PolyglotContext): AppEntrypoint {
    return entrypoints.get().getOrPut(app.id) {
      // need to resolve the full path to the entrypoint script and use it to construct
      // the source for the context to evaluate, the source also depends on the app language
      val entry = config.guestRoot.resolve(app.id.value).resolve(app.config.entrypoint)
      val source = Source.newBuilder(languageCode(app.config.language), entry.toFile()).build()

      val module = context.evaluate(source)
      when (app.config.dispatchMode) {
        FETCH -> {
          check(module.hasMember("fetch")) { "No 'fetch' function exported from entrypoint module" }
          FetchEntrypoint(module.getMember("fetch"))
        }
      }
    }
  }

  override fun dispatch(call: EmbeddedCall, app: EmbeddedApp): Deferred<EmbeddedResponse> {
    val result = CompletableDeferred<EmbeddedResponse>()

    app.dispatch {
      // use the thread-local context
      val context = useContext()

      // retrieve or evaluate the entrypoint and dispatch the call, map the inputs and outputs
      // TODO(@darvld): map request and response objects to language bindings
      when (val entrypoint = useEntrypoint(app, context)) {
        is FetchEntrypoint -> result.complete(entrypoint(call.request))
      }
    }.invokeOnCompletion { failure -> failure?.let { result.completeExceptionally(it) } }

    return result
  }
}