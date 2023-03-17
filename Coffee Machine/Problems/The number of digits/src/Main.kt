import java.lang.Math.abs
import java.lang.Math.log10
import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    // put your code here
    val op = scanner.nextInt()
    print(op.length())
    println(when (scanner.nextInt()) {
        in 0..9 -> 1
        in 10..99 -> 2
        in 100..999 -> 3
        else -> 4
    })
    print(Scanner(System.`in`).nextLine().toList().size)
}

fun Int.length() = when(this) {
    0 -> 1
    else -> log10(abs(toDouble())).toInt() + 1
}
