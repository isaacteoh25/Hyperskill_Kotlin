import java.lang.Exception
import java.util.*

//fun main() {
////    var number: Int = readLine()!!.toInt()
////    println(++number)
//    val sum = readLine()!!.split(" ")
//            .map { it.toInt() }
//            .sum()
//    val sum = readLine()?.split(" ")?.sumBy { it.toInt() } ?: 0
//    val (a, b, c) = List<Int>(3) { scanner.nextInt() }
//
//    val sum = a + b + c
//    println(sum)
//
//}
//fun main() = print(readLine()!!.split(" ").map { it.toInt() }.sum())
//fun main() = print(readLine()!!.toInt() + 1)

fun main(args: Array<String>){
    // put your code here
//    val a =  readLine()!!.split(" ")
////    val b = readLine()!!.toInt()
//    if (a[1].toInt() == 0) {
//        throw Exception("Division by zero, please fix the second argument!")
//    }
//    print(a[0].toInt()/ a[1].toInt())
    test()
}

fun test(): String {
    try {
        val scanner = Scanner(System.`in`)
        // put your code here
        // val a =  readLine()!!.split(" ")
//    val b = readLine()!!.toInt()
        val s1 = scanner.nextDouble()
        val s2 = scanner.nextInt()
//    if (s1 == 0 || s2 == 0) {
//        throw Exception("Division by zero, please fix the second argument!")
//    }
        return (s1 / s2).toString()
    }
    catch(e: Exception){
        return "Division by zero, please fix the second argument!"
    }
}
fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(" ").map { it.toInt() }
    try {
        println(a / b)
    } catch (e: java.lang.Exception) {
        e.message
        println("Division by zero, please fix the second argument!")
    }
    val (a, b) = readLine()!!.split(" ").map(String::toInt)
    println(if (b == 0) "Division by zero, please fix the second argument!" else a / b)
}