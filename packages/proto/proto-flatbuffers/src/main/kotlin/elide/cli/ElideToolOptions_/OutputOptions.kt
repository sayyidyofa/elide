// automatically generated by the FlatBuffers compiler, do not modify

package elide.cli.ElideToolOptions_

import com.google.flatbuffers.Constants
import com.google.flatbuffers.FlatBufferBuilder
import com.google.flatbuffers.Table
import java.nio.ByteBuffer
import java.nio.ByteOrder

@Suppress("unused")
class OutputOptions : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : OutputOptions {
        __init(_i, _bb)
        return this
    }
    val verbose : Boolean
        get() {
            val o = __offset(4)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else false
        }
    val quiet : Boolean
        get() {
            val o = __offset(6)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else false
        }
    val pretty : Boolean
        get() {
            val o = __offset(8)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else false
        }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_22_12_06()
        fun getRootAsOutputOptions(_bb: ByteBuffer): OutputOptions = getRootAsOutputOptions(_bb, OutputOptions())
        fun getRootAsOutputOptions(_bb: ByteBuffer, obj: OutputOptions): OutputOptions {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createOutputOptions(builder: FlatBufferBuilder, verbose: Boolean, quiet: Boolean, pretty: Boolean) : Int {
            builder.startTable(3)
            addPretty(builder, pretty)
            addQuiet(builder, quiet)
            addVerbose(builder, verbose)
            return endOutputOptions(builder)
        }
        fun startOutputOptions(builder: FlatBufferBuilder) = builder.startTable(3)
        fun addVerbose(builder: FlatBufferBuilder, verbose: Boolean) = builder.addBoolean(0, verbose, false)
        fun addQuiet(builder: FlatBufferBuilder, quiet: Boolean) = builder.addBoolean(1, quiet, false)
        fun addPretty(builder: FlatBufferBuilder, pretty: Boolean) = builder.addBoolean(2, pretty, false)
        fun endOutputOptions(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
