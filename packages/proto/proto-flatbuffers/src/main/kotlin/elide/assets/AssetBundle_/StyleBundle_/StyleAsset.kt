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

package elide.assets.AssetBundle_.StyleBundle_

import com.google.flatbuffers.Constants
import com.google.flatbuffers.FlatBufferBuilder
import com.google.flatbuffers.Table
import java.nio.ByteBuffer
import java.nio.ByteOrder

@Suppress("unused")
class StyleAsset : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : StyleAsset {
        __init(_i, _bb)
        return this
    }
    val token : String?
        get() {
            val o = __offset(4)
            return if (o != 0) __string(o + bb_pos) else null
        }
    val tokenAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(4, 1)
    fun tokenInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 4, 1)
    val filename : String?
        get() {
            val o = __offset(6)
            return if (o != 0) __string(o + bb_pos) else null
        }
    val filenameAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(6, 1)
    fun filenameInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 6, 1)
    val stylesheet : elide.page.Context_.Styles_.Stylesheet? get() = stylesheet(elide.page.Context_.Styles_.Stylesheet())
    fun stylesheet(obj: elide.page.Context_.Styles_.Stylesheet) : elide.page.Context_.Styles_.Stylesheet? {
        val o = __offset(8)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    val renaming : Boolean
        get() {
            val o = __offset(10)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else false
        }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_22_12_06()
        fun getRootAsStyleAsset(_bb: ByteBuffer): StyleAsset = getRootAsStyleAsset(_bb, StyleAsset())
        fun getRootAsStyleAsset(_bb: ByteBuffer, obj: StyleAsset): StyleAsset {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createStyleAsset(builder: FlatBufferBuilder, tokenOffset: Int, filenameOffset: Int, stylesheetOffset: Int, renaming: Boolean) : Int {
            builder.startTable(4)
            addStylesheet(builder, stylesheetOffset)
            addFilename(builder, filenameOffset)
            addToken(builder, tokenOffset)
            addRenaming(builder, renaming)
            return endStyleAsset(builder)
        }
        fun startStyleAsset(builder: FlatBufferBuilder) = builder.startTable(4)
        fun addToken(builder: FlatBufferBuilder, token: Int) = builder.addOffset(0, token, 0)
        fun addFilename(builder: FlatBufferBuilder, filename: Int) = builder.addOffset(1, filename, 0)
        fun addStylesheet(builder: FlatBufferBuilder, stylesheet: Int) = builder.addOffset(2, stylesheet, 0)
        fun addRenaming(builder: FlatBufferBuilder, renaming: Boolean) = builder.addBoolean(3, renaming, false)
        fun endStyleAsset(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
