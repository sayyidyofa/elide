// automatically generated by the FlatBuffers compiler, do not modify

package elide.page.Context_.Styles_

import com.google.flatbuffers.Constants
import com.google.flatbuffers.FlatBufferBuilder
import com.google.flatbuffers.Table
import java.nio.ByteBuffer
import java.nio.ByteOrder

@Suppress("unused")
class Stylesheet : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : Stylesheet {
        __init(_i, _bb)
        return this
    }
    val uri : webutil.html.types.TrustedResourceUrlProto? get() = uri(webutil.html.types.TrustedResourceUrlProto())
    fun uri(obj: webutil.html.types.TrustedResourceUrlProto) : webutil.html.types.TrustedResourceUrlProto? {
        val o = __offset(4)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    val id : String?
        get() {
            val o = __offset(6)
            return if (o != 0) __string(o + bb_pos) else null
        }
    val idAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(6, 1)
    fun idInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 6, 1)
    val media : String?
        get() {
            val o = __offset(8)
            return if (o != 0) __string(o + bb_pos) else null
        }
    val mediaAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(8, 1)
    fun mediaInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 8, 1)
    val prefetch : Boolean
        get() {
            val o = __offset(10)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else false
        }
    val preload : Boolean
        get() {
            val o = __offset(12)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else false
        }
    val push : Boolean
        get() {
            val o = __offset(14)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else false
        }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_22_12_06()
        fun getRootAsStylesheet(_bb: ByteBuffer): Stylesheet = getRootAsStylesheet(_bb, Stylesheet())
        fun getRootAsStylesheet(_bb: ByteBuffer, obj: Stylesheet): Stylesheet {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createStylesheet(builder: FlatBufferBuilder, uriOffset: Int, idOffset: Int, mediaOffset: Int, prefetch: Boolean, preload: Boolean, push: Boolean) : Int {
            builder.startTable(6)
            addMedia(builder, mediaOffset)
            addId(builder, idOffset)
            addUri(builder, uriOffset)
            addPush(builder, push)
            addPreload(builder, preload)
            addPrefetch(builder, prefetch)
            return endStylesheet(builder)
        }
        fun startStylesheet(builder: FlatBufferBuilder) = builder.startTable(6)
        fun addUri(builder: FlatBufferBuilder, uri: Int) = builder.addOffset(0, uri, 0)
        fun addId(builder: FlatBufferBuilder, id: Int) = builder.addOffset(1, id, 0)
        fun addMedia(builder: FlatBufferBuilder, media: Int) = builder.addOffset(2, media, 0)
        fun addPrefetch(builder: FlatBufferBuilder, prefetch: Boolean) = builder.addBoolean(3, prefetch, false)
        fun addPreload(builder: FlatBufferBuilder, preload: Boolean) = builder.addBoolean(4, preload, false)
        fun addPush(builder: FlatBufferBuilder, push: Boolean) = builder.addBoolean(5, push, false)
        fun endStylesheet(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
