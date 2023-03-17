import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    // put your code here
    var sum = 0

    do {
        val i = scanner.nextInt()
        sum += i
    }while (i != 0)

    println("$sum")
}