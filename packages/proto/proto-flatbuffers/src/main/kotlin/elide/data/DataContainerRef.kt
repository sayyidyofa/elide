// automatically generated by the FlatBuffers compiler, do not modify

package elide.data

import com.google.flatbuffers.*
import java.nio.*

@Suppress("unused")
class DataContainerRef : Table() {

    fun __init(_i: Int, _bb: ByteBuffer) {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer): DataContainerRef {
        __init(_i, _bb)
        return this
    }
    val reference: elide.data.DataContainerRef_.ContainerReference? get() = reference(elide.data.DataContainerRef_.ContainerReference())
    fun reference(
      obj: elide.data.DataContainerRef_.ContainerReference,
    ): elide.data.DataContainerRef_.ContainerReference? {
        val o = __offset(4)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_22_12_06()
        fun getRootAsDataContainerRef(
          _bb: ByteBuffer,
        ): DataContainerRef = getRootAsDataContainerRef(_bb, DataContainerRef())
        fun getRootAsDataContainerRef(_bb: ByteBuffer, obj: DataContainerRef): DataContainerRef {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createDataContainerRef(builder: FlatBufferBuilder, referenceOffset: Int): Int {
            builder.startTable(1)
            addReference(builder, referenceOffset)
            return endDataContainerRef(builder)
        }
        fun startDataContainerRef(builder: FlatBufferBuilder) = builder.startTable(1)
        fun addReference(builder: FlatBufferBuilder, reference: Int) = builder.addOffset(0, reference, 0)
        fun endDataContainerRef(builder: FlatBufferBuilder): Int {
            val o = builder.endTable()
            return o
        }
    }
}
