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

// automatically generated by the FlatBuffers compiler, do not modify

package elide.page

@Suppress("unused")
class Format private constructor() {
    companion object {
        const val GENERIC: Int = 0
        const val OPENGRAPH: Int = 1
        const val JSONLD: Int = 2
        val names : Array<String> = arrayOf("GENERIC", "OPENGRAPH", "JSON_LD")
        fun name(e: Int) : String = names[e]
    }
}
