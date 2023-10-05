/*
 * Copyright (c) 2023 Elide Ventures, LLC.
 *
 * Licensed under the MIT license (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *   https://opensource.org/license/mit/
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under the License.
 */

package elide.runtime.core.internals.graalvm

import org.graalvm.polyglot.Context
import org.graalvm.polyglot.Source
import elide.runtime.core.DelicateElideApi
import elide.runtime.core.GuestLanguage
import elide.runtime.core.PolyglotContext
import elide.runtime.core.PolyglotValue

/**
 * An implementation of the [PolyglotContext] interface wrapping a GraalVM context.
 */
@DelicateElideApi internal class GraalVMContext(val context: Context) : PolyglotContext {
  override fun bindings(language: GuestLanguage?): PolyglotValue {
    return language?.let { context.getBindings(it.languageId) } ?: context.polyglotBindings
  }

  override fun parse(source: Source): PolyglotValue {
    return context.parse(source)
  }

  override fun evaluate(source: Source): PolyglotValue {
    return context.eval(source)
  }

  override fun enter() {
    context.enter()
  }

  override fun leave() {
    context.leave()
  }
}
