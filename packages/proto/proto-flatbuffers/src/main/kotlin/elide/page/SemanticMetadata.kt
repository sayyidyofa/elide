// automatically generated by the FlatBuffers compiler, do not modify

package elide.page

import com.google.flatbuffers.*
import java.nio.*

@Suppress("unused")
class SemanticMetadata : Table() {

    fun __init(_i: Int, _bb: ByteBuffer) {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer): SemanticMetadata {
        __init(_i, _bb)
        return this
    }
    val kind: Int
        get() {
            val o = __offset(4)
            return if (o != 0) bb.getInt(o + bb_pos) else 0
        }
    fun format(j: Int): Int {
        val o = __offset(6)
        return if (o != 0) {
            bb.getInt(__vector(o) + j * 4)
        } else {
            0
        }
    }
    val formatLength: Int
        get() {
            val o = __offset(6)
            return if (o != 0) __vector_len(o) else 0
        }
    val formatAsByteBuffer: ByteBuffer get() = __vector_as_bytebuffer(6, 4)
    fun formatInByteBuffer(_bb: ByteBuffer): ByteBuffer = __vector_in_bytebuffer(_bb, 6, 4)
    fun media(j: Int): elide.page.MediaAsset? = media(elide.page.MediaAsset(), j)
    fun media(obj: elide.page.MediaAsset, j: Int): elide.page.MediaAsset? {
        val o = __offset(8)
        return if (o != 0) {
            obj.__assign(__indirect(__vector(o) + j * 4), bb)
        } else {
            null
        }
    }
    val mediaLength: Int
        get() {
            val o = __offset(8)
            return if (o != 0) __vector_len(o) else 0
        }
    val payload: elide.page.SemanticMetadata_.Anonymous2? get() = payload(elide.page.SemanticMetadata_.Anonymous2())
    fun payload(obj: elide.page.SemanticMetadata_.Anonymous2): elide.page.SemanticMetadata_.Anonymous2? {
        val o = __offset(10)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_22_12_06()
        fun getRootAsSemanticMetadata(
          _bb: ByteBuffer,
        ): SemanticMetadata = getRootAsSemanticMetadata(_bb, SemanticMetadata())
        fun getRootAsSemanticMetadata(_bb: ByteBuffer, obj: SemanticMetadata): SemanticMetadata {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createSemanticMetadata(
          builder: FlatBufferBuilder,
          kind: Int,
          formatOffset: Int,
          mediaOffset: Int,
          payloadOffset: Int,
        ): Int {
            builder.startTable(4)
            addPayload(builder, payloadOffset)
            addMedia(builder, mediaOffset)
            addFormat(builder, formatOffset)
            addKind(builder, kind)
            return endSemanticMetadata(builder)
        }
        fun startSemanticMetadata(builder: FlatBufferBuilder) = builder.startTable(4)
        fun addKind(builder: FlatBufferBuilder, kind: Int) = builder.addInt(0, kind, 0)
        fun addFormat(builder: FlatBufferBuilder, format: Int) = builder.addOffset(1, format, 0)
        fun createFormatVector(builder: FlatBufferBuilder, data: IntArray): Int {
            builder.startVector(4, data.size, 4)
            for (i in data.size - 1 downTo 0) {
                builder.addInt(data[i])
            }
            return builder.endVector()
        }
        fun startFormatVector(builder: FlatBufferBuilder, numElems: Int) = builder.startVector(4, numElems, 4)
        fun addMedia(builder: FlatBufferBuilder, media: Int) = builder.addOffset(2, media, 0)
        fun createMediaVector(builder: FlatBufferBuilder, data: IntArray): Int {
            builder.startVector(4, data.size, 4)
            for (i in data.size - 1 downTo 0) {
                builder.addOffset(data[i])
            }
            return builder.endVector()
        }
        fun startMediaVector(builder: FlatBufferBuilder, numElems: Int) = builder.startVector(4, numElems, 4)
        fun addPayload(builder: FlatBufferBuilder, payload: Int) = builder.addOffset(3, payload, 0)
        fun endSemanticMetadata(builder: FlatBufferBuilder): Int {
            val o = builder.endTable()
            return o
        }
    }
}
