import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val numbers = scanner.nextLine().split(" ").map { it.toInt() }
    print(numbers[0]* numbers[1] + numbers[2]*2 + numbers[3]*(numbers[0]-1))
}

class SumCosts(private var days: Int, private var dailyFood: Int, private var oneWay: Int, private var oneNight: Int) {

    fun get(): Int {
        val foodCosts = this.days * this.dailyFood
        val flightCosts = this.oneWay * 2
        val hotelCosts = this.oneNight * (this.days - 1)
        return foodCosts + flightCosts + hotelCosts
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val total = SumCosts(
            scanner.next().toInt(),
            scanner.next().toInt(),
            scanner.next().toInt(),
            scanner.next().toInt())
    println(total.get())
}

import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    // put your code here
    val list = ArrayList<Int>()
    for (i in 0..3) {
        list.add(scanner.nextInt())
    }
    val res = list.get(0) * list.get(1) + list.get(2) * 2 + list.get(3) * (list.get(0) - 1)
    println(res)
}