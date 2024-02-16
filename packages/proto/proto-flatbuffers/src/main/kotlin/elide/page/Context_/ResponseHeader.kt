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

import com.google.flatbuffers.Constants
import com.google.flatbuffers.FlatBufferBuilder
import com.google.flatbuffers.Table
import java.nio.ByteBuffer
import java.nio.ByteOrder

@Suppress("unused")
class ResponseHeader : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : ResponseHeader {
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
    val value : String?
        get() {
            val o = __offset(6)
            return if (o != 0) __string(o + bb_pos) else null
        }
    val valueAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(6, 1)
    fun valueInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 6, 1)
    val force : Boolean
        get() {
            val o = __offset(8)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else false
        }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_22_12_06()
        fun getRootAsResponseHeader(_bb: ByteBuffer): ResponseHeader = getRootAsResponseHeader(_bb, ResponseHeader())
        fun getRootAsResponseHeader(_bb: ByteBuffer, obj: ResponseHeader): ResponseHeader {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createResponseHeader(builder: FlatBufferBuilder, nameOffset: Int, valueOffset: Int, force: Boolean) : Int {
            builder.startTable(3)
            addValue(builder, valueOffset)
            addName(builder, nameOffset)
            addForce(builder, force)
            return endResponseHeader(builder)
        }
        fun startResponseHeader(builder: FlatBufferBuilder) = builder.startTable(3)
        fun addName(builder: FlatBufferBuilder, name: Int) = builder.addOffset(0, name, 0)
        fun addValue(builder: FlatBufferBuilder, value: Int) = builder.addOffset(1, value, 0)
        fun addForce(builder: FlatBufferBuilder, force: Boolean) = builder.addBoolean(2, force, false)
        fun endResponseHeader(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
