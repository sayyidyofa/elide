// automatically generated by the FlatBuffers compiler, do not modify

package elide.data

@Suppress("unused")
class CompressionMode private constructor() {
    companion object {
        const val IDENTITY: Int = 0
        const val GZIP: Int = 1
        const val BROTLI: Int = 2
        const val SNAPPY: Int = 3
        const val DEFLATE: Int = 4
        val names: Array<String> = arrayOf("IDENTITY", "GZIP", "BROTLI", "SNAPPY", "DEFLATE")
        fun name(e: Int): String = names[e]
    }
}
