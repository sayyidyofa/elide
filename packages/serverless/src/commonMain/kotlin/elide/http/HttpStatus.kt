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

import kotlin.jvm.JvmInline
import kotlin.jvm.JvmRecord
import elide.http.api.HttpStatusCode
import elide.http.api.HttpString
import elide.http.api.HttpStatus as HttpStatusAPI

/**
 *
 */
@JvmInline public value class HttpStatus(public val statusInfo: HttpStatusInfo) : HttpStatusAPI {
  /**
   *
   */
  public data class HttpStatusInfo(
    public val code: HttpStatusCode,
    public val reason: HttpString? = null,
  )

  override val code: HttpStatusCode get() = statusInfo.code
  override val text: HttpString? get() = statusInfo.reason
}
