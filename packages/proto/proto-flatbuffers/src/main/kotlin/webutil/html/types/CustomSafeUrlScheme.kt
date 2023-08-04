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

package webutil.html.types

@Suppress("unused")
class CustomSafeUrlScheme private constructor() {
    companion object {
        const val TEL: Int = 0
        const val SMS: Int = 1
        const val CALLTO: Int = 2
        const val WTAI: Int = 3
        const val RTSP: Int = 4
        const val MARKET: Int = 5
        const val GEO: Int = 6
        const val SKYPE: Int = 7
        const val WHATSAPP: Int = 8
        const val ITMSBOOKS: Int = 9
        val names : Array<String> = arrayOf("TEL", "SMS", "CALLTO", "WTAI", "RTSP", "MARKET", "GEO", "SKYPE", "WHATSAPP", "ITMS_BOOKS")
        fun name(e: Int) : String = names[e]
    }
}
