package seamcarving

import java.io.File
import javax.imageio.ImageIO

fun main(args: Array<String>) {
    val inputImageFile = File(args[1])
    val outputImageFile = File(args[3])
    val image = ImageIO.read(inputImageFile)
    for (x in 0 until image.width) {
        for (y in 0 until image.height) {
            image.setRGB(x, y, 0xFFFFFF - image.getRGB(x, y))
        }
    }
    ImageIO.write(image, outputImageFile.extension, outputImageFile)
}