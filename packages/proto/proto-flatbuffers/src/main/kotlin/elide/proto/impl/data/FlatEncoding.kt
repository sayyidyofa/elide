/*
 * Copyright (c) 2024 Elide Technologies, Inc.
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

@file:Suppress("RedundantVisibilityModifier")

package elide.proto.impl.data

import elide.core.api.Symbolic
import elide.core.api.Symbolic.SealedResolver
import elide.core.api.Symbolic.Unresolved
import elide.core.encoding.Encoding

/** Maps a native enumeration to each symbolic encoding integer generated by Flatbuffers. */
public enum class FlatEncoding (override val symbol: EncodingSymbol) : Symbolic<EncodingSymbol> {
  /** Encoding: UTF-8 (global default). */
  UTF8(symbol = Encoding.UTF_8.ordinal),

  /** Encoding: UTF-16. */
  UTF16(symbol = Encoding.UTF_16.ordinal),

  /** Encoding: UTF-32. */
  UTF32(symbol = Encoding.UTF_32.ordinal);

  public companion object : SealedResolver<EncodingSymbol, FlatEncoding> {
    /** @return [FlatEncoding] corresponding to the provided constant, or throw. */
    @Throws(Unresolved::class)
    override fun resolve(symbol: EncodingSymbol): FlatEncoding = when (symbol) {
      Encoding.UTF_8.ordinal -> UTF8
      Encoding.UTF_16.ordinal -> UTF16
      Encoding.UTF_32.ordinal -> UTF32
      else -> throw unresolved(symbol)
    }
  }
}
