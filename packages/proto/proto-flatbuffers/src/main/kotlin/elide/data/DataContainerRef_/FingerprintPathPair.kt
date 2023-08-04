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

package elide.data.DataContainerRef_

import com.google.flatbuffers.Constants
import com.google.flatbuffers.FlatBufferBuilder
import com.google.flatbuffers.Table
import java.nio.ByteBuffer
import java.nio.ByteOrder

@Suppress("unused")
class FingerprintPathPair : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : FingerprintPathPair {
        __init(_i, _bb)
        return this
    }
    val fingerprint : elide.data.DataFingerprint? get() = fingerprint(elide.data.DataFingerprint())
    fun fingerprint(obj: elide.data.DataFingerprint) : elide.data.DataFingerprint? {
        val o = __offset(4)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    val path : String?
        get() {
            val o = __offset(6)
            return if (o != 0) __string(o + bb_pos) else null
        }
    val pathAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(6, 1)
    fun pathInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 6, 1)
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_22_12_06()
        fun getRootAsFingerprintPathPair(_bb: ByteBuffer): FingerprintPathPair = getRootAsFingerprintPathPair(_bb, FingerprintPathPair())
        fun getRootAsFingerprintPathPair(_bb: ByteBuffer, obj: FingerprintPathPair): FingerprintPathPair {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createFingerprintPathPair(builder: FlatBufferBuilder, fingerprintOffset: Int, pathOffset: Int) : Int {
            builder.startTable(2)
            addPath(builder, pathOffset)
            addFingerprint(builder, fingerprintOffset)
            return endFingerprintPathPair(builder)
        }
        fun startFingerprintPathPair(builder: FlatBufferBuilder) = builder.startTable(2)
        fun addFingerprint(builder: FlatBufferBuilder, fingerprint: Int) = builder.addOffset(0, fingerprint, 0)
        fun addPath(builder: FlatBufferBuilder, path: Int) = builder.addOffset(1, path, 0)
        fun endFingerprintPathPair(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
