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

package elide.vfs

import com.google.flatbuffers.Constants
import com.google.flatbuffers.FlatBufferBuilder
import com.google.flatbuffers.Table
import java.nio.ByteBuffer
import java.nio.ByteOrder

@Suppress("unused")
class Filesystem : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : Filesystem {
        __init(_i, _bb)
        return this
    }
    val metadata : elide.vfs.Filesystem_.Metadata? get() = metadata(elide.vfs.Filesystem_.Metadata())
    fun metadata(obj: elide.vfs.Filesystem_.Metadata) : elide.vfs.Filesystem_.Metadata? {
        val o = __offset(4)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    val root : elide.vfs.TreeEntry? get() = root(elide.vfs.TreeEntry())
    fun root(obj: elide.vfs.TreeEntry) : elide.vfs.TreeEntry? {
        val o = __offset(6)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_22_12_06()
        fun getRootAsFilesystem(_bb: ByteBuffer): Filesystem = getRootAsFilesystem(_bb, Filesystem())
        fun getRootAsFilesystem(_bb: ByteBuffer, obj: Filesystem): Filesystem {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createFilesystem(builder: FlatBufferBuilder, metadataOffset: Int, rootOffset: Int) : Int {
            builder.startTable(2)
            addRoot(builder, rootOffset)
            addMetadata(builder, metadataOffset)
            return endFilesystem(builder)
        }
        fun startFilesystem(builder: FlatBufferBuilder) = builder.startTable(2)
        fun addMetadata(builder: FlatBufferBuilder, metadata: Int) = builder.addOffset(0, metadata, 0)
        fun addRoot(builder: FlatBufferBuilder, root: Int) = builder.addOffset(1, root, 0)
        fun endFilesystem(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
