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

package elide.assets

import com.google.flatbuffers.Constants
import com.google.flatbuffers.FlatBufferBuilder
import com.google.flatbuffers.Table
import java.nio.ByteBuffer
import java.nio.ByteOrder

@Suppress("unused")
class EmbeddedScriptMetadata : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : EmbeddedScriptMetadata {
        __init(_i, _bb)
        return this
    }
    val metadata : elide.assets.EmbeddedScriptMetadata_.LanguageSpecificMetadata? get() = metadata(elide.assets.EmbeddedScriptMetadata_.LanguageSpecificMetadata())
    fun metadata(obj: elide.assets.EmbeddedScriptMetadata_.LanguageSpecificMetadata) : elide.assets.EmbeddedScriptMetadata_.LanguageSpecificMetadata? {
        val o = __offset(4)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_22_12_06()
        fun getRootAsEmbeddedScriptMetadata(_bb: ByteBuffer): EmbeddedScriptMetadata = getRootAsEmbeddedScriptMetadata(_bb, EmbeddedScriptMetadata())
        fun getRootAsEmbeddedScriptMetadata(_bb: ByteBuffer, obj: EmbeddedScriptMetadata): EmbeddedScriptMetadata {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createEmbeddedScriptMetadata(builder: FlatBufferBuilder, metadataOffset: Int) : Int {
            builder.startTable(1)
            addMetadata(builder, metadataOffset)
            return endEmbeddedScriptMetadata(builder)
        }
        fun startEmbeddedScriptMetadata(builder: FlatBufferBuilder) = builder.startTable(1)
        fun addMetadata(builder: FlatBufferBuilder, metadata: Int) = builder.addOffset(0, metadata, 0)
        fun endEmbeddedScriptMetadata(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
