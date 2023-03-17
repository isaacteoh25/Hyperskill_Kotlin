import java.util.*

fun main(args: Array<String>) {
    var largest = Int.MIN_VALUE
    val scanner = Scanner(System.`in`)
    do {
        val n = scanner.nextInt()
        if (n > largest) largest = n
    } while (n != 0)
    print(largest)

    var arr = mutableListOf<Int>()
    do {
        val number = scanner.nextInt()
        arr.add(number)
    } while (number != 0)
    print(arr.max())

    var ma = 0

    while (scanner.hasNextInt()) {
        val s = scanner.nextInt()
        if (s >= ma) {
            ma = s
        }
    }

    print(ma)
    val numbers = mutableListOf<Int>()
    while (scanner.hasNextInt()) {
        val next = scanner.nextInt()
        if (next == 0) break
        numbers.add(next)
    }
    println(numbers.max())
}
