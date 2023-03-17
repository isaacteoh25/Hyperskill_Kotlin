import java.util.Scanner
import kotlin.math.sqrt

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val a = scanner.nextDouble()
    val b = scanner.nextDouble()
    val c = scanner.nextDouble()

    val d = sqrt(b * b - 4 * a * c)
    listOf((-b + d).div(2 * a), (-b - d).div(2 * a)).sorted().joinToString(" ").also { println(it) }
}
fun main() {
    val (a, b, c) = Array(3) { readLine()!!.toDouble() }
    val operators = arrayOf(-1, 1)
    val roots = DoubleArray(2)

    for (i in operators.indices) roots[i] = (-b + operators[i] * sqrt(b.pow(2) - 4 * a * c)) / (2 * a)

    println(roots.sortedArray().joinToString(" "))
}
fun main(args: Array<String>) {
    val (a, b, c) = Array(3) { readLine()!!.toDouble() }
    val x = arrayOf(
            (-b - sqrt(b.pow(2) - 4 * a * c)) / (2.0 * a),
            (-b + sqrt(b.pow(2) - 4 * a * c)) / (2.0 * a)
    ).sorted()
    println(x.joinToString(" "))
}

//fun main(args: Array<String>) {
//    val scanner = Scanner(System.`in`)
//    // put your code here
//    val x = scanner.nextDouble()
//    println(x.pow(1.0 / 4))
//}