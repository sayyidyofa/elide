package elide.runtime.gvm.internals.intrinsics.js.crypto

import elide.runtime.gvm.internals.intrinsics.GuestIntrinsic
import elide.runtime.gvm.internals.intrinsics.Intrinsic
import elide.runtime.gvm.internals.intrinsics.js.AbstractJsIntrinsic
import elide.runtime.gvm.internals.intrinsics.js.JsSymbol.JsSymbols.asJsSymbol
import elide.runtime.intrinsics.js.CryptoKey

/** Intrinsic implementation of the [CryptoKey] class, part of the Web Crypto API. */
@Intrinsic(global = WebCryptoIntrinsic.GLOBAL_CRYPTO)
internal class WebCryptoKey : AbstractJsIntrinsic() {
  internal companion object {
    // JS global name where `CryptoKey` is installed as a class.
    private const val GLOBAL_CRYPTO_KEY_NAME = "CryptoKey"

    // JS symbol for the `CryptoKey` global.
    internal val GLOBAL_CRYPTO_KEY = GLOBAL_CRYPTO_KEY_NAME.asJsSymbol()
  }

  /** Internal container structure for a crypto key. */
  internal class CryptoKeyContainer internal constructor (private val wrapped: CryptoKeyImpl): CryptoKey by wrapped

  /** [CryptoKey] factory facade. */
  internal class CryptoKeyFactory : CryptoKey.Constructors

  override fun install(bindings: GuestIntrinsic.MutableIntrinsicBindings) {
    bindings[GLOBAL_CRYPTO_KEY] = CryptoKeyFactory()
  }

  /**
   * ## `CryptoKey` Implementation
   *
   * Describes implementations of crypto keys, as part of the Web Crypto API. These are accessed through a proxied
   * [CryptoKeyContainer] object, and via the [CryptoKey] interface within a guest VM.
   */
  internal sealed class CryptoKeyImpl: CryptoKey
}