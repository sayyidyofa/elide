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

package elide.page.Context_

@Suppress("unused")
class ClientHint private constructor() {
    companion object {
        const val UNKNOWNCLIENTHINT: Int = 0
        const val DPR: Int = 1
        const val ECT: Int = 2
        const val RTT: Int = 3
        const val DOWNLINK: Int = 4
        const val DEVICEMEMORY: Int = 5
        const val SAVEDATA: Int = 6
        const val WIDTH: Int = 7
        const val VIEWPORTWIDTH: Int = 8
        val names : Array<String> = arrayOf("UNKNOWN_CLIENT_HINT", "DPR", "ECT", "RTT", "DOWNLINK", "DEVICE_MEMORY", "SAVE_DATA", "WIDTH", "VIEWPORT_WIDTH")
        fun name(e: Int) : String = names[e]
    }
}
