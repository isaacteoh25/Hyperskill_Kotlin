package seamcarving

import java.awt.Color
import java.awt.Graphics2D
import java.awt.image.BufferedImage
import java.io.File
import java.util.*
import javax.imageio.ImageIO

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    println("Enter rectangle width:")
    val width = scanner.nextInt()
    println("Enter rectangle height:")
    val height = scanner.nextInt()
    println("Enter output image name:")
    val filnam = scanner.next()
    val g = BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)
    val picture = "porno.jpg"
    val q: Graphics2D = g.createGraphics()
    q.color = Color.RED
    q.drawLine(0,0,width - 1,height - 1)
    q.drawLine(width - 1,0,0,height - 1)
    ImageIO.write(g, "png", File("${filnam}"))

}