import java.util.*

fun car(old: Int = 5, passed: Int = 100_000, speed: Int = 120, auto: Int = 0, startPrice: Int = 20_000): Int {
    return startPrice - old * 2000 - passed / 10_000 * 200 - (120 - speed) * 100 + auto * 1500
}

fun main() {
    val scanner = Scanner(System.`in`)
    val a = scanner.next()
    val b = scanner.nextInt()
    when (a) {
        "old" -> println(car(b))
        "passed" -> println(car(passed = b))
        "speed" -> println(car(speed = b))
        "auto" -> println(car(auto = b))
    }
}
