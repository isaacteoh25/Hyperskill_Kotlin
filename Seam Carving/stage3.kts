package seamcarving
import java.awt.Color
import java.io.File
import javax.imageio.ImageIO
import kotlin.math.*

fun getG2(a: Color, b: Color) =
        ((a.red - b.red) * (a.red - b.red) + (a.green - b.green) * (a.green - b.green) + (a.blue - b.blue) * (a.blue - b.blue)).toDouble()

fun getVal(k: Int, limit: Int): Int = when (k) {
    0 -> 1
    limit - 1 -> limit - 2
    else -> k
}

fun main(args: Array<String>) {
    val fInName = File(args[args.indexOf("-in") + 1])
    val fOutName = File(args[args.indexOf("-out") + 1])

    ImageIO.read(fInName).apply {
        val e: Array<Array<Double>> = Array(width) { Array(height) { 0.0 } }
        var maxE = 0.0
        for (x in 0 until width)
            for (y in 0 until height) {
                e[x][y] = sqrt(getG2(Color(getRGB(getVal(x, width) - 1, y)), Color(getRGB(getVal(x, width) + 1, y))) +
                        getG2(Color(getRGB(x, getVal(y, height) - 1)), Color(getRGB(x, getVal(y, height) + 1))))
                if (e[x][y] > maxE) maxE = e[x][y]
            }
        for (x in 0 until width)
            for (y in 0 until height)
                (255.0 * e[x][y] / maxE).toInt().also { setRGB(x, y, Color(it, it, it).rgb) }
        ImageIO.write(this, "png", fOutName)
    }
}