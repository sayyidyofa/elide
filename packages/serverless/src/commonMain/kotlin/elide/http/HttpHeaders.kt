/*
 * Copyright (c) 2024 Elide Ventures, LLC.
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

package elide.http

import elide.http.api.HttpHeaders as HttpHeadersAPI
import kotlin.jvm.JvmStatic
import elide.http.api.HttpHeaders.HeaderName
import elide.http.api.HttpString
import elide.struct.api.SortedMap
import elide.struct.sortedMapOf

/**
 * # HTTP Headers
 *
 * Keeps track of HTTP headers in a given HTTP message payload.
 */
public class HttpHeaders private constructor (
  private val headers: SortedMap<HeaderName, HttpString> = sortedMapOf(),
) : HttpHeadersAPI, Map<HeaderName, HttpString> by headers {
  public companion object {
    /**
     *
     */
    @JvmStatic public fun empty(): HttpHeaders = HttpHeaders()

    /**
     *
     */
    @JvmStatic public fun of(vararg pairs: Pair<String, String>): HttpHeaders = HttpHeaders(
      sortedMapOf(pairs.map { HeaderName.of(it.first) to it.second })
    )

    /**
     *
     */
    @JvmStatic public fun copyFrom(map: Map<String, String>): HttpHeaders = HttpHeaders(
      sortedMapOf(map.entries.map { HeaderName.of(it.key) to it.value })
    )
  }

  override operator fun get(key: String): HttpString? = headers[HeaderName.of(key)]
  override operator fun get(key: HeaderName): HttpString? = headers[key]
}
