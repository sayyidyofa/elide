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

package elide.data.DataContainerRef_

import com.google.flatbuffers.Constants
import com.google.flatbuffers.FlatBufferBuilder
import com.google.flatbuffers.Table
import java.nio.ByteBuffer
import java.nio.ByteOrder

@Suppress("unused")
class ContainerReference : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : ContainerReference {
        __init(_i, _bb)
        return this
    }
    val data : elide.data.CompressedData? get() = data(elide.data.CompressedData())
    fun data(obj: elide.data.CompressedData) : elide.data.CompressedData? {
        val o = __offset(4)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    val resource : elide.data.DataContainerRef_.FingerprintPathPair? get() = resource(elide.data.DataContainerRef_.FingerprintPathPair())
    fun resource(obj: elide.data.DataContainerRef_.FingerprintPathPair) : elide.data.DataContainerRef_.FingerprintPathPair? {
        val o = __offset(6)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    val filesystem : elide.data.DataContainerRef_.FingerprintPathPair? get() = filesystem(elide.data.DataContainerRef_.FingerprintPathPair())
    fun filesystem(obj: elide.data.DataContainerRef_.FingerprintPathPair) : elide.data.DataContainerRef_.FingerprintPathPair? {
        val o = __offset(8)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_22_12_06()
        fun getRootAsContainerReference(_bb: ByteBuffer): ContainerReference = getRootAsContainerReference(_bb, ContainerReference())
        fun getRootAsContainerReference(_bb: ByteBuffer, obj: ContainerReference): ContainerReference {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createContainerReference(builder: FlatBufferBuilder, dataOffset: Int, resourceOffset: Int, filesystemOffset: Int) : Int {
            builder.startTable(3)
            addFilesystem(builder, filesystemOffset)
            addResource(builder, resourceOffset)
            addData(builder, dataOffset)
            return endContainerReference(builder)
        }
        fun startContainerReference(builder: FlatBufferBuilder) = builder.startTable(3)
        fun addData(builder: FlatBufferBuilder, data: Int) = builder.addOffset(0, data, 0)
        fun addResource(builder: FlatBufferBuilder, resource: Int) = builder.addOffset(1, resource, 0)
        fun addFilesystem(builder: FlatBufferBuilder, filesystem: Int) = builder.addOffset(2, filesystem, 0)
        fun endContainerReference(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
