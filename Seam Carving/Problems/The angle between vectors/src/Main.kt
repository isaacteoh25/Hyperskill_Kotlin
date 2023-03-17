import kotlin.math.PI
import kotlin.math.acos
import kotlin.math.hypot
fun foo(a: Int = a, b: Int = c, c: Int){

}

fun main() {
    val (u, v) = Array(2) { readLine()!!.split(" ").map { it.toDouble() } }

    println((acos((u[0] * v[0] + u[1] * v[1]) / (hypot(u[0], u[1]) * hypot(v[0], v[1]))) * 180 / PI).toInt())
}

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val (u1, u2) = scanner.nextLine().split(" ").map { it.toInt() }
    val (v1, v2) = scanner.nextLine().split(" ").map { it.toInt() }

    val scalarProduct = u1 * v1 + u2 * v2
    val uLength = Math.sqrt(Math.pow(u1.toDouble(), 2.00) + Math.pow(u2.toDouble(), 2.00))
    val vLength = Math.sqrt(Math.pow(v1.toDouble(), 2.00) + Math.pow(v2.toDouble(), 2.00))

    val cosAngle = scalarProduct / (uLength * vLength)

    println(Math.toDegrees(Math.acos(cosAngle)))
}

import java.util.Scanner
import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.atan

fun main() {
    val scanner = Scanner(System.`in`)
    // put your code here
    val (x1, y1, x2, y2) = List(4) { scanner.nextDouble() }
    val radianDistance = abs(atan(y2 / x2) - atan(y1 / x1))
    println(radianDistance * 180 / PI)
}