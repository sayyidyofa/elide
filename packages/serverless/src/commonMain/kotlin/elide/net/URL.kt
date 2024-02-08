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

package elide.net

import kotlin.jvm.JvmInline
import elide.net.api.URLInfo
import elide.net.api.URL as URLAPI

/**
 *
 */
@JvmInline public value class URL(public val urlInfo: ParsedURL) : URLAPI {
  public sealed class ParsedURL: URLInfo {

  }
}
