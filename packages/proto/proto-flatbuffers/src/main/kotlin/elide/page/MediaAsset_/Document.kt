// automatically generated by the FlatBuffers compiler, do not modify

package elide.page.MediaAsset_

import com.google.flatbuffers.Constants
import com.google.flatbuffers.FlatBufferBuilder
import com.google.flatbuffers.Table
import java.nio.ByteBuffer
import java.nio.ByteOrder

@Suppress("unused")
class Document : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : Document {
        __init(_i, _bb)
        return this
    }
    val type : Int
        get() {
            val o = __offset(4)
            return if(o != 0) bb.getInt(o + bb_pos) else 0
        }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_22_12_06()
        fun getRootAsDocument(_bb: ByteBuffer): Document = getRootAsDocument(_bb, Document())
        fun getRootAsDocument(_bb: ByteBuffer, obj: Document): Document {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createDocument(builder: FlatBufferBuilder, type: Int) : Int {
            builder.startTable(1)
            addType(builder, type)
            return endDocument(builder)
        }
        fun startDocument(builder: FlatBufferBuilder) = builder.startTable(1)
        fun addType(builder: FlatBufferBuilder, type: Int) = builder.addInt(0, type, 0)
        fun endDocument(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
