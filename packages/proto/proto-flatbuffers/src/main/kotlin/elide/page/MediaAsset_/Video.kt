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

package elide.page.MediaAsset_

import com.google.flatbuffers.Constants
import com.google.flatbuffers.FlatBufferBuilder
import com.google.flatbuffers.Table
import java.nio.ByteBuffer
import java.nio.ByteOrder

@Suppress("unused")
class Video : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : Video {
        __init(_i, _bb)
        return this
    }
    val provider : Int
        get() {
            val o = __offset(4)
            return if(o != 0) bb.getInt(o + bb_pos) else 0
        }
    val title : String?
        get() {
            val o = __offset(6)
            return if (o != 0) __string(o + bb_pos) else null
        }
    val titleAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(6, 1)
    fun titleInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 6, 1)
    val description : String?
        get() {
            val o = __offset(8)
            return if (o != 0) __string(o + bb_pos) else null
        }
    val descriptionAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(8, 1)
    fun descriptionInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 8, 1)
    val runTime : ULong
        get() {
            val o = __offset(10)
            return if(o != 0) bb.getLong(o + bb_pos).toULong() else 0UL
        }
    fun asset(j: Int) : elide.page.MediaAsset_.Video_.VideoAsset? = asset(elide.page.MediaAsset_.Video_.VideoAsset(), j)
    fun asset(obj: elide.page.MediaAsset_.Video_.VideoAsset, j: Int) : elide.page.MediaAsset_.Video_.VideoAsset? {
        val o = __offset(12)
        return if (o != 0) {
            obj.__assign(__indirect(__vector(o) + j * 4), bb)
        } else {
            null
        }
    }
    val assetLength : Int
        get() {
            val o = __offset(12); return if (o != 0) __vector_len(o) else 0
        }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_22_12_06()
        fun getRootAsVideo(_bb: ByteBuffer): Video = getRootAsVideo(_bb, Video())
        fun getRootAsVideo(_bb: ByteBuffer, obj: Video): Video {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createVideo(builder: FlatBufferBuilder, provider: Int, titleOffset: Int, descriptionOffset: Int, runTime: ULong, assetOffset: Int) : Int {
            builder.startTable(5)
            addRunTime(builder, runTime)
            addAsset(builder, assetOffset)
            addDescription(builder, descriptionOffset)
            addTitle(builder, titleOffset)
            addProvider(builder, provider)
            return endVideo(builder)
        }
        fun startVideo(builder: FlatBufferBuilder) = builder.startTable(5)
        fun addProvider(builder: FlatBufferBuilder, provider: Int) = builder.addInt(0, provider, 0)
        fun addTitle(builder: FlatBufferBuilder, title: Int) = builder.addOffset(1, title, 0)
        fun addDescription(builder: FlatBufferBuilder, description: Int) = builder.addOffset(2, description, 0)
        fun addRunTime(builder: FlatBufferBuilder, runTime: ULong) = builder.addLong(3, runTime.toLong(), 0)
        fun addAsset(builder: FlatBufferBuilder, asset: Int) = builder.addOffset(4, asset, 0)
        fun createAssetVector(builder: FlatBufferBuilder, data: IntArray) : Int {
            builder.startVector(4, data.size, 4)
            for (i in data.size - 1 downTo 0) {
                builder.addOffset(data[i])
            }
            return builder.endVector()
        }
        fun startAssetVector(builder: FlatBufferBuilder, numElems: Int) = builder.startVector(4, numElems, 4)
        fun endVideo(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
