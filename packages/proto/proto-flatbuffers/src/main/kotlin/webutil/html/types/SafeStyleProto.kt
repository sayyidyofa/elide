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

package webutil.html.types

import com.google.flatbuffers.Constants
import com.google.flatbuffers.FlatBufferBuilder
import com.google.flatbuffers.Table
import java.nio.ByteBuffer
import java.nio.ByteOrder

@Suppress("unused")
class SafeStyleProto : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : SafeStyleProto {
        __init(_i, _bb)
        return this
    }
    val privateDoNotAccessOrElseSafeStyleWrappedValue : String?
        get() {
            val o = __offset(4)
            return if (o != 0) __string(o + bb_pos) else null
        }
    val privateDoNotAccessOrElseSafeStyleWrappedValueAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(4, 1)
    fun privateDoNotAccessOrElseSafeStyleWrappedValueInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 4, 1)
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_22_12_06()
        fun getRootAsSafeStyleProto(_bb: ByteBuffer): SafeStyleProto = getRootAsSafeStyleProto(_bb, SafeStyleProto())
        fun getRootAsSafeStyleProto(_bb: ByteBuffer, obj: SafeStyleProto): SafeStyleProto {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createSafeStyleProto(builder: FlatBufferBuilder, privateDoNotAccessOrElseSafeStyleWrappedValueOffset: Int) : Int {
            builder.startTable(1)
            addPrivateDoNotAccessOrElseSafeStyleWrappedValue(builder, privateDoNotAccessOrElseSafeStyleWrappedValueOffset)
            return endSafeStyleProto(builder)
        }
        fun startSafeStyleProto(builder: FlatBufferBuilder) = builder.startTable(1)
        fun addPrivateDoNotAccessOrElseSafeStyleWrappedValue(builder: FlatBufferBuilder, privateDoNotAccessOrElseSafeStyleWrappedValue: Int) = builder.addOffset(0, privateDoNotAccessOrElseSafeStyleWrappedValue, 0)
        fun endSafeStyleProto(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
