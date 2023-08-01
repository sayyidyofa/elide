// automatically generated by the FlatBuffers compiler, do not modify

package webutil.html.types

import com.google.flatbuffers.Constants
import com.google.flatbuffers.FlatBufferBuilder
import com.google.flatbuffers.Table
import java.nio.ByteBuffer
import java.nio.ByteOrder

@Suppress("unused")
class SafeHtmlProto : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : SafeHtmlProto {
        __init(_i, _bb)
        return this
    }
    val privateDoNotAccessOrElseSafeHtmlWrappedValue : String?
        get() {
            val o = __offset(4)
            return if (o != 0) __string(o + bb_pos) else null
        }
    val privateDoNotAccessOrElseSafeHtmlWrappedValueAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(4, 1)
    fun privateDoNotAccessOrElseSafeHtmlWrappedValueInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 4, 1)
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_22_12_06()
        fun getRootAsSafeHtmlProto(_bb: ByteBuffer): SafeHtmlProto = getRootAsSafeHtmlProto(_bb, SafeHtmlProto())
        fun getRootAsSafeHtmlProto(_bb: ByteBuffer, obj: SafeHtmlProto): SafeHtmlProto {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createSafeHtmlProto(builder: FlatBufferBuilder, privateDoNotAccessOrElseSafeHtmlWrappedValueOffset: Int) : Int {
            builder.startTable(1)
            addPrivateDoNotAccessOrElseSafeHtmlWrappedValue(builder, privateDoNotAccessOrElseSafeHtmlWrappedValueOffset)
            return endSafeHtmlProto(builder)
        }
        fun startSafeHtmlProto(builder: FlatBufferBuilder) = builder.startTable(1)
        fun addPrivateDoNotAccessOrElseSafeHtmlWrappedValue(builder: FlatBufferBuilder, privateDoNotAccessOrElseSafeHtmlWrappedValue: Int) = builder.addOffset(0, privateDoNotAccessOrElseSafeHtmlWrappedValue, 0)
        fun endSafeHtmlProto(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
