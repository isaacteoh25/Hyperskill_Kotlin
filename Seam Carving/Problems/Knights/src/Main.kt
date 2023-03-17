import java.util.*
import kotlin.math.abs

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val (x1, y1, x2, y2) = IntArray(4) { scanner.nextInt() }

    val yes = abs(x1 - x2) == 1 && abs(y1 - y2) == 2 || abs(x1 - x2) == 2 && abs(y1 - y2) == 1

    println(if (yes) "YES" else "NO")
}