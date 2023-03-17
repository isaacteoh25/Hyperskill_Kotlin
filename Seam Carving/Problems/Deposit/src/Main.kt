import java.util.*
import kotlin.math.pow

fun finalAmount(startingAmount: Int = 1000, yearlyPercent: Int = 5, years: Int = 10): Int {
    return (startingAmount * (1 + yearlyPercent / 100.0).pow(years)).toInt()
}

fun main() {
    val scanner = Scanner(System.`in`)
    val a = scanner.next()
    val b = scanner.nextInt()
    when (a) {
        "amount" -> println(finalAmount(b))
        "percent" -> println(finalAmount(yearlyPercent = b))
        "years" -> println(finalAmount(years = b))
    }
}