// TODO: provide isEven function here
import java.util.*

fun isEven(n1:Int) :Boolean = n1 % 2 == 0

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val number1 = scanner.nextInt()
    println(isEven(number1).toString())
}
