// automatically generated by the FlatBuffers compiler, do not modify

package elide.page.MediaAsset_

import com.google.flatbuffers.*
import java.nio.*

@Suppress("unused")
class Link : Table() {

    fun __init(_i: Int, _bb: ByteBuffer) {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer): Link {
        __init(_i, _bb)
        return this
    }
    val uri: String?
        get() {
            val o = __offset(4)
            return if (o != 0) __string(o + bb_pos) else null
        }
    val uriAsByteBuffer: ByteBuffer get() = __vector_as_bytebuffer(4, 1)
    fun uriInByteBuffer(_bb: ByteBuffer): ByteBuffer = __vector_in_bytebuffer(_bb, 4, 1)
    val alt: String?
        get() {
            val o = __offset(6)
            return if (o != 0) __string(o + bb_pos) else null
        }
    val altAsByteBuffer: ByteBuffer get() = __vector_as_bytebuffer(6, 1)
    fun altInByteBuffer(_bb: ByteBuffer): ByteBuffer = __vector_in_bytebuffer(_bb, 6, 1)
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_22_12_06()
        fun getRootAsLink(_bb: ByteBuffer): Link = getRootAsLink(_bb, Link())
        fun getRootAsLink(_bb: ByteBuffer, obj: Link): Link {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createLink(builder: FlatBufferBuilder, uriOffset: Int, altOffset: Int): Int {
            builder.startTable(2)
            addAlt(builder, altOffset)
            addUri(builder, uriOffset)
            return endLink(builder)
        }
        fun startLink(builder: FlatBufferBuilder) = builder.startTable(2)
        fun addUri(builder: FlatBufferBuilder, uri: Int) = builder.addOffset(0, uri, 0)
        fun addAlt(builder: FlatBufferBuilder, alt: Int) = builder.addOffset(1, alt, 0)
        fun endLink(builder: FlatBufferBuilder): Int {
            val o = builder.endTable()
            return o
        }
    }
}
