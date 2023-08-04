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

// automatically generated by the FlatBuffers compiler, do not modify

package elide.meta

@Suppress("unused")
class GuestLanguage private constructor() {
    companion object {
        const val NOGUESTENABLED: Int = 0
        const val JAVASCRIPT: Int = 1
        val names : Array<String> = arrayOf("NO_GUEST_ENABLED", "JAVASCRIPT")
        fun name(e: Int) : String = names[e]
    }
}
