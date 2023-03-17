import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // write your code here
    val a = scanner.nextLong()
    val op = scanner.next()
    val b = scanner.nextLong()

    when (op) {
        "+" -> println(a + b)
        "-" -> println(a - b)
        "*" -> println(a * b)
        "/" -> if (b == 0L) println("Division by 0!") else{println(a / b )}
        else -> println("Unknown operator")
    }

}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val arr = scanner.nextLine().split(" ")
    println(when {
        arr[1].contentEquals("+") -> arr[0].toLong() + arr[2].toLong()
        arr[1].contentEquals("-") -> arr[0].toLong() - arr[2].toLong()
        arr[1].contentEquals("*") -> arr[0].toLong() * arr[2].toLong()
        arr[1].contentEquals("/") && arr[2].toInt() != 0 -> arr[0].toLong() / arr[2].toLong()
        arr[1].contentEquals("/") && arr[2].toInt() == 0 -> "Division by 0!"
        else -> "Unknown operator"
    })
}