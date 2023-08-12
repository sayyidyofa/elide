package elide.runtime.core.internals.graalvm

import org.graalvm.polyglot.Context
import elide.runtime.core.DelicateElideApi
import elide.runtime.core.GuestLanguage
import elide.runtime.core.PolyglotValue
import elide.runtime.core.PolyglotContext

/**
 * An implementation of the [PolyglotContext] interface wrapping a GraalVM context.
 */
@DelicateElideApi internal class GraalVMContext(val context: Context) : PolyglotContext {
  override fun execute(language: GuestLanguage, source: String): PolyglotValue {
    return context.eval(language.languageId, source)
  }
}