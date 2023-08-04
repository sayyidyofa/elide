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

package elide.vfs

import com.google.flatbuffers.Constants
import com.google.flatbuffers.FlatBufferBuilder
import com.google.flatbuffers.Table
import java.nio.ByteBuffer
import java.nio.ByteOrder

@Suppress("unused")
class Directory : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : Directory {
        __init(_i, _bb)
        return this
    }
    val name : String?
        get() {
            val o = __offset(4)
            return if (o != 0) __string(o + bb_pos) else null
        }
    val nameAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(4, 1)
    fun nameInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 4, 1)
    fun children(j: Int) : elide.vfs.TreeEntry? = children(elide.vfs.TreeEntry(), j)
    fun children(obj: elide.vfs.TreeEntry, j: Int) : elide.vfs.TreeEntry? {
        val o = __offset(6)
        return if (o != 0) {
            obj.__assign(__indirect(__vector(o) + j * 4), bb)
        } else {
            null
        }
    }
    val childrenLength : Int
        get() {
            val o = __offset(6); return if (o != 0) __vector_len(o) else 0
        }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_22_12_06()
        fun getRootAsDirectory(_bb: ByteBuffer): Directory = getRootAsDirectory(_bb, Directory())
        fun getRootAsDirectory(_bb: ByteBuffer, obj: Directory): Directory {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createDirectory(builder: FlatBufferBuilder, nameOffset: Int, childrenOffset: Int) : Int {
            builder.startTable(2)
            addChildren(builder, childrenOffset)
            addName(builder, nameOffset)
            return endDirectory(builder)
        }
        fun startDirectory(builder: FlatBufferBuilder) = builder.startTable(2)
        fun addName(builder: FlatBufferBuilder, name: Int) = builder.addOffset(0, name, 0)
        fun addChildren(builder: FlatBufferBuilder, children: Int) = builder.addOffset(1, children, 0)
        fun createChildrenVector(builder: FlatBufferBuilder, data: IntArray) : Int {
            builder.startVector(4, data.size, 4)
            for (i in data.size - 1 downTo 0) {
                builder.addOffset(data[i])
            }
            return builder.endVector()
        }
        fun startChildrenVector(builder: FlatBufferBuilder, numElems: Int) = builder.startVector(4, numElems, 4)
        fun endDirectory(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
