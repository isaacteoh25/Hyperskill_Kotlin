import java.util.*
import java.util.Arrays
import java.lang.Math.pow
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    // put your code here
//    val list: ArrayList<Int> = ArrayList()
//    for (i in 0 until 4) {
//        val n = scanner.nextInt()
//        if (n > 0 && n < 1000 ){
//            if (!list.contains(n)) {
////                println(n)
//                list.add(n)
//            }
//        }
//}
//    list.sort()
//    for (element in list) {
//        println(element)
//    }
    val list: ArrayList<Int> = ArrayList()
//    for (i in 0 until 4) {
        val a = scanner.nextInt()
        val b = scanner.nextInt()
        val c = scanner.nextInt()
        val d = scanner.nextInt()
//    }
        for (x in 1 until 1000){
             val eq = a * calPower(x,3) + b * calPower(x, 2) + c * x + d

        if (eq == 0) {
            list.add(x)

        }
        }
    for (element in list) {
        println(element)
    }
    val numbers = IntArray(4) { scanner.nextInt() }

    for (i in 0..1000) {
        if (numbers[0] * pow(i.toDouble(), 3.0) + numbers[1] * pow(i.toDouble(), 2.0) + numbers[2] * i + numbers[3] == 0.0) {
            println(i)
        }
    }
    }

fun calPower(baseValue: Int, powerValue: Int): Int {
    return if (powerValue != 0)  baseValue * calPower(baseValue, powerValue - 1) else 1
}