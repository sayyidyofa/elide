@file:Suppress("DEPRECATION")

package elide.runtime.feature.js

import com.oracle.svm.core.annotate.AutomaticFeature
import elide.annotations.internal.VMFeature
import elide.runtime.feature.FrameworkFeature
import org.graalvm.nativeimage.hosted.Feature
import org.graalvm.polyglot.Engine


/** GraalVM feature which enables reflection required for the [elide.runtime.graalvm.JsRuntime]. */
@VMFeature
@AutomaticFeature
internal class JsRuntimeFeature : FrameworkFeature {
  private companion object {
    private const val registerV1 = true
    private const val registerV3 = true
    private val registeredIntrinsics: List<String> = listOf(
      // Core Intrinsics
      "base64.Base64Intrinsic",
      "console.ConsoleIntrinsic",

      // Fetch API
      "fetch.FetchIntrinsic",
      "fetch.FetchHeadersIntrinsic",
      "fetch.FetchRequestIntrinsic",
      "fetch.FetchResponseIntrinsic",

      // URL API
      "url.URLIntrinsic",
      "url.URLIntrinsic${'$'}URLValue",
    )
  }

  // -- Interface: VM Feature -- //
  /**
   * Register types which must be callable via reflection or the Polyglot API within the Elide JS Runtime.
   *
   * @param access Before-analysis info for a given GraalVM image.
   */
  private fun registerJsRuntimeTypes(access: Feature.BeforeAnalysisAccess) {
    // legacy: register old JS runtime classes
    if (registerV1) {
      registerClassForReflection(access, "elide.runtime.graalvm.JsRuntime")
      registerClassForReflection(access, "elide.runtime.graalvm.JsRuntime${'$'}ExecutionInputs")
    }
    if (registerV3) {
      registerClassForReflection(access, "elide.runtime.gvm.internals.js.JsRuntime")
      registeredIntrinsics.forEach {
        registerClassForReflection(access, "elide.runtime.gvm.internals.intrinsics.js.${it}")
      }
    }
  }

  /** @inheritDoc */
  override fun getRequiredFeatures(): MutableList<Class<out Feature>> {
    return arrayListOf(
      elide.runtime.feature.ProtocolBuffers::class.java,
    )
  }

  /** @inheritDoc */
  override fun isInConfiguration(access: Feature.IsInConfigurationAccess): Boolean {
    println("supported languages at build time: " + Engine.create().languages)
    return true
  }

  /** @inheritDoc */
  override fun beforeAnalysis(access: Feature.BeforeAnalysisAccess) {
    registerJsRuntimeTypes(access)
  }

  /** @inheritDoc */
  override fun getDescription(): String = "Enables the Elide JS runtime"
}
