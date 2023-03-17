package seamcarving

////object ByteArrayToImage {
////    @Throws(Exception::class)
////    @JvmStatic
//    fun main(args: Array<String>) {
//        val bImage = ImageIO.read(File("sample.png"))
//        val bos = ByteArrayOutputStream()
//        ImageIO.write(bImage, "png", bos)
//        val data = bos.toByteArray()
//        val bis = ByteArrayInputStream(data)
//        val bImage2 = ImageIO.read(bis)
//        ImageIO.write(bImage2, "png", File("out.png"))
//        println("image created")
//    }
////}