// automatically generated by the FlatBuffers compiler, do not modify

package elide.cli.LocalAuthToken_

import com.google.flatbuffers.Constants
import com.google.flatbuffers.FlatBufferBuilder
import com.google.flatbuffers.Table
import java.nio.ByteBuffer
import java.nio.ByteOrder

@Suppress("unused")
class Anonymous1 : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : Anonymous1 {
        __init(_i, _bb)
        return this
    }
    val userToken : elide.data.secrets.Token? get() = userToken(elide.data.secrets.Token())
    fun userToken(obj: elide.data.secrets.Token) : elide.data.secrets.Token? {
        val o = __offset(4)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_22_12_06()
        fun getRootAsAnonymous1(_bb: ByteBuffer): Anonymous1 = getRootAsAnonymous1(_bb, Anonymous1())
        fun getRootAsAnonymous1(_bb: ByteBuffer, obj: Anonymous1): Anonymous1 {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createAnonymous1(builder: FlatBufferBuilder, userTokenOffset: Int) : Int {
            builder.startTable(1)
            addUserToken(builder, userTokenOffset)
            return endAnonymous1(builder)
        }
        fun startAnonymous1(builder: FlatBufferBuilder) = builder.startTable(1)
        fun addUserToken(builder: FlatBufferBuilder, userToken: Int) = builder.addOffset(0, userToken, 0)
        fun endAnonymous1(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
