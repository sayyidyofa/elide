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

package elide.page.Context_

@Suppress("unused")
class ReferrerPolicy private constructor() {
    companion object {
        const val DEFAULTREFERRERPOLICY: Int = 0
        const val NOREFERRER: Int = 1
        const val NOREFERRERWHENDOWNGRADE: Int = 2
        const val ORIGIN: Int = 3
        const val ORIGINWHENCROSSORIGIN: Int = 4
        const val SAME: Int = 5
        const val STRICTORIGIN: Int = 7
        const val STRICTORIGINWHENCROSSORIGIN: Int = 8
        const val UNSAFEURL: Int = 9
        val names : Array<String> = arrayOf("DEFAULT_REFERRER_POLICY", "NO_REFERRER", "NO_REFERRER_WHEN_DOWNGRADE", "ORIGIN", "ORIGIN_WHEN_CROSS_ORIGIN", "SAME", "", "STRICT_ORIGIN", "STRICT_ORIGIN_WHEN_CROSS_ORIGIN", "UNSAFE_URL")
        fun name(e: Int) : String = names[e]
    }
}
