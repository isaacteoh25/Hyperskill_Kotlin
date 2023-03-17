import java.util.*
import kotlin.math.pow
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()

    var counter = 0.0
    while(counter < n) {
        counter++
        val sq = Math.sqrt(counter)
        val isNatural = sq - sq.toInt() == 0.0
        //println("$sq , ${sq.toInt()}, $isNatural")
        if(isNatural) println(counter.toInt())
    }

    val square = scanner.nextInt()
    var i = 1
    do {
        println(i * i)
        i++
    } while (i * i <= square)

    val number = scanner.nextInt()
    var result = 1.0
    while (result.pow(2) <= number) {
        println(result.pow(2).toInt())
        result++
    }
}