import java.util.*

fun main(args: Array<String>) {
    var count = 0
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    // put your code here
    repeat(n) {
    val next = scanner.nextInt()
    if (next > 0){
        count += 1
    }
    }
    print(count)
}
