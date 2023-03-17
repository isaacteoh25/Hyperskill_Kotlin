class Block(val color: String)
{
    /* creates a new instance of Player */
    object DimProperties  {
        var width: Int = 0
        var length : Int = 0
        fun blocksInBox(length :Int, width :Int): Int {
//            width = width
//            length  = height
            return length / this.length * (width / this.width)
        }
    }
}
//fun main(args: Array<String>){
//    println(Block.DimProperties)
//}

data class Block(val color: String) {
    object DimProperties {
        var length: Int = 0
        var width: Int = 0
        fun blocksInBox(lengthIn: Int, widthIn: Int): Int =
                if (length == 0 || width == 0) 0 else lengthIn / length * (widthIn / width)
    }
}