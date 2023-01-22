package elide.util.uuid

import kotlin.native.FreezingIsDeprecated
import kotlin.native.concurrent.freeze

@OptIn(FreezingIsDeprecated::class)
internal actual fun <T> T.freeze() = this.freeze()
