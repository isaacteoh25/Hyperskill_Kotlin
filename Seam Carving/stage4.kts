package seamcarving

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO
import kotlin.math.sqrt

fun main(args: Array<String>) {
    try {
        val (o1, v1, o2, v2) = args
        when (o1 to o2) {
            "-in" to "-out" -> EnergySpotter(v1, v2)
            "-out" to "-in" -> EnergySpotter(v2, v1)
            else -> throw IllegalArgumentException("Illegal options: `$o1` or `$o2`\nUse `-in <file> -out <file>`")
        }.process()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

class EnergySpotter(private val `in`: String, private val out: String) {
    //    fun process() = read().getEnergy().drawEnergySpots().let(::write)
    fun process() = read().drawSeam().let(::write)
    private fun read() = ImageIO.read(File(`in`))
    private fun write(image: BufferedImage) = File(out).let { ImageIO.write(image, it.extension, it) }
}

fun BufferedImage.drawSeam(): BufferedImage {
    val red = 0xFF_00_00
    var seamPath: Path? = getEnergy().getSeam()
    while (seamPath != null) {
        setRGB(seamPath.x, seamPath.y, red)
        seamPath = seamPath.prev
    }
    return this
}

fun BufferedImage.getEnergy(): Array<DoubleArray> {
    val energySpots = Array(width) { DoubleArray(height) }
    var maxEnergyValue = .0
    for (x in 0 until width) {
        for (y in 0 until height) {
            val xx = x.coerceIn(1, width - 2)
            val yy = y.coerceIn(1, height - 2)
            val (h, l) = getRGB(xx - 1, y) to getRGB(xx + 1, y)
            val (j, k) = getRGB(x, yy + 1) to getRGB(x, yy - 1)
            val energy = sqrt(h.gradient(l) + j.gradient(k))
            energySpots[x][y] = energy
            if (energy > maxEnergyValue) maxEnergyValue = energy
        }
    }
    energySpots.forEach {
        it.forEachIndexed { i, e -> it[i] = 255.0 * e / maxEnergyValue }
    }
    return energySpots
}

data class Path(val prev: Path?, val value: Double, val x: Int, val y: Int)

fun Array<DoubleArray>.getSeam(): Path {
    val (w, h) = size to first().size
    var fringe = Array(w) { x -> Path(null, this[x][0], x, 0) }
    for (y in 1 until h) {
        fringe = Array(w) { x ->
            val min = listOf(x - 1, x, x + 1).map { fringe[it.coerceIn(0, w - 1)] }.minBy(Path::value)!!
            Path(min, min.value + this[x][y], x, y)
        }
    }
    return fringe.minBy(Path::value)!!
}

fun Array<DoubleArray>.drawEnergySpots(): BufferedImage {
    val energySpots = BufferedImage(size, first().size, BufferedImage.TYPE_INT_RGB)
    forEachIndexed { x, col ->
        col.forEachIndexed { y, e -> energySpots.setRGB(x, y, e.toGrayRGB()) }
    }
    return energySpots
}

fun Int.gradient(other: Int): Double {
    var (a, b) = this to other
    var sumSq = 0
    repeat(3) {
        sumSq += ((a and 0xFF) - (b and 0xFF)).let { it * it }
        a = a shr 8
        b = b shr 8
    }
    return sumSq.toDouble()
}

fun Double.toGrayRGB() = toInt().let { (it shl 16) or (it shl 8) or it }