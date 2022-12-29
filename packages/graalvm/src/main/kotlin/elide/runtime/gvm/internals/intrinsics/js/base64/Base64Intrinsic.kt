package elide.runtime.gvm.internals.intrinsics.js.base64

import elide.annotations.core.Polyglot
import elide.core.encoding.Base64
import elide.runtime.gvm.internals.intrinsics.GuestIntrinsic
import elide.runtime.gvm.internals.intrinsics.Intrinsic
import elide.runtime.gvm.internals.intrinsics.js.AbstractJsIntrinsic
import elide.runtime.gvm.internals.intrinsics.js.JsSymbol
import elide.runtime.gvm.internals.intrinsics.js.JsSymbol.JsSymbols.asJsSymbol
import elide.runtime.intrinsics.js.JavaScriptBase64
import org.graalvm.nativeimage.CurrentIsolate

/** Implements [JavaScriptBase64] via [elide.core.encoding.Base64], by way of [NativeBase64Intrinsic]. */
@Intrinsic(global = Base64Intrinsic.GLOBAL_BASE64)
internal class Base64Intrinsic : JavaScriptBase64, AbstractJsIntrinsic() {
  internal companion object {
    /** Injected name of the Base64 global. */
    const val GLOBAL_BASE64 = "Base64"

    /** Injected name of the `btoa` intrinsic. */
    private const val GLOBAL_BTOA = "btoa"

    /** Injected name of the `atob` intrinsic. */
    private const val GLOBAL_ATOB = "atob"

    /** Base64 symbol. */
    private val BASE64_SYMBOL = GLOBAL_BASE64.asJsSymbol()
  }

  /** @inheritDoc */
  @Polyglot @Intrinsic(global = GLOBAL_BTOA) override fun encode(input: String, websafe: Boolean): String =
    if (websafe) Base64.encodeWebSafe(input) else Base64.encodeToString(input)

  /** @inheritDoc */
  @Polyglot @Intrinsic(global = GLOBAL_ATOB) override fun decode(input: String): String =
    Base64.decodeToString(input)

  /** @inheritDoc */
  override fun install(bindings: GuestIntrinsic.MutableIntrinsicBindings) {
    // mount `Base64`
    bindings[BASE64_SYMBOL] = this
  }
}
