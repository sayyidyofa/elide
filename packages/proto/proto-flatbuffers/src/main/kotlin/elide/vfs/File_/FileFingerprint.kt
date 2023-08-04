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

package elide.vfs.File_

import com.google.flatbuffers.Constants
import com.google.flatbuffers.FlatBufferBuilder
import com.google.flatbuffers.Table
import java.nio.ByteBuffer
import java.nio.ByteOrder

@Suppress("unused")
class FileFingerprint : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : FileFingerprint {
        __init(_i, _bb)
        return this
    }
    val compressed : elide.vfs.File_.Fingerprint? get() = compressed(elide.vfs.File_.Fingerprint())
    fun compressed(obj: elide.vfs.File_.Fingerprint) : elide.vfs.File_.Fingerprint? {
        val o = __offset(4)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    val uncompressed : elide.vfs.File_.Fingerprint? get() = uncompressed(elide.vfs.File_.Fingerprint())
    fun uncompressed(obj: elide.vfs.File_.Fingerprint) : elide.vfs.File_.Fingerprint? {
        val o = __offset(6)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_22_12_06()
        fun getRootAsFileFingerprint(_bb: ByteBuffer): FileFingerprint = getRootAsFileFingerprint(_bb, FileFingerprint())
        fun getRootAsFileFingerprint(_bb: ByteBuffer, obj: FileFingerprint): FileFingerprint {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createFileFingerprint(builder: FlatBufferBuilder, compressedOffset: Int, uncompressedOffset: Int) : Int {
            builder.startTable(2)
            addUncompressed(builder, uncompressedOffset)
            addCompressed(builder, compressedOffset)
            return endFileFingerprint(builder)
        }
        fun startFileFingerprint(builder: FlatBufferBuilder) = builder.startTable(2)
        fun addCompressed(builder: FlatBufferBuilder, compressed: Int) = builder.addOffset(0, compressed, 0)
        fun addUncompressed(builder: FlatBufferBuilder, uncompressed: Int) = builder.addOffset(1, uncompressed, 0)
        fun endFileFingerprint(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
