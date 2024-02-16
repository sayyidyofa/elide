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

package elide.assets.AssetBundle_

import com.google.flatbuffers.Constants
import com.google.flatbuffers.FlatBufferBuilder
import com.google.flatbuffers.Table
import java.nio.ByteBuffer
import java.nio.ByteOrder

@Suppress("unused")
class ScriptsEntry : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : ScriptsEntry {
        __init(_i, _bb)
        return this
    }
    val key : String?
        get() {
            val o = __offset(4)
            return if (o != 0) __string(o + bb_pos) else null
        }
    val keyAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(4, 1)
    fun keyInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 4, 1)
    val value : elide.assets.AssetBundle_.ScriptBundle? get() = value(elide.assets.AssetBundle_.ScriptBundle())
    fun value(obj: elide.assets.AssetBundle_.ScriptBundle) : elide.assets.AssetBundle_.ScriptBundle? {
        val o = __offset(6)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    override fun keysCompare(o1: Int, o2: Int, _bb: ByteBuffer) : Int {
         return compareStrings(__offset(4, o1, _bb), __offset(4, o2, _bb), _bb)
    }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_22_12_06()
        fun getRootAsScriptsEntry(_bb: ByteBuffer): ScriptsEntry = getRootAsScriptsEntry(_bb, ScriptsEntry())
        fun getRootAsScriptsEntry(_bb: ByteBuffer, obj: ScriptsEntry): ScriptsEntry {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createScriptsEntry(builder: FlatBufferBuilder, keyOffset: Int, valueOffset: Int) : Int {
            builder.startTable(2)
            addValue(builder, valueOffset)
            addKey(builder, keyOffset)
            return endScriptsEntry(builder)
        }
        fun startScriptsEntry(builder: FlatBufferBuilder) = builder.startTable(2)
        fun addKey(builder: FlatBufferBuilder, key: Int)  {
            builder.addOffset(key)
            builder.slot(0)
        }
        fun addValue(builder: FlatBufferBuilder, value: Int) = builder.addOffset(1, value, 0)
        fun endScriptsEntry(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
                builder.required(o, 4)
            return o
        }
        fun __lookup_by_key(obj: ScriptsEntry?, vectorLocation: Int, key: String, bb: ByteBuffer) : ScriptsEntry? {
            val byteKey = key.toByteArray(java.nio.charset.StandardCharsets.UTF_8)
            var span = bb.getInt(vectorLocation - 4)
            var start = 0
            while (span != 0) {
                var middle = span / 2
                val tableOffset = __indirect(vectorLocation + 4 * (start + middle), bb)
                val comp = compareStrings(__offset(4, bb.capacity() - tableOffset, bb), byteKey, bb)
                when {
                    comp > 0 -> span = middle
                    comp < 0 -> {
                        middle++
                        start += middle
                        span -= middle
                    }
                    else -> {
                        return (obj ?: ScriptsEntry()).__assign(tableOffset, bb)
                    }
                }
            }
            return null
        }
    }
}
