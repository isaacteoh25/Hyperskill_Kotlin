import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // write your code here
    val n = scanner.nextInt()
    var result = 0 // starting value of the factorial
    for (i in 1..n) { // the product from 2 to n
        result += scanner.nextInt()
    }

    println(result)
    val numbers = scanner.nextInt()
    val array = IntArray(numbers) { scanner.nextInt() }
    print(array.sum())
}
