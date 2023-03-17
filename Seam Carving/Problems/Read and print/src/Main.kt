//fun main(args: Array<String>) {
//    // put your code here
//    val scanner = Scanner(System.`in`)
//    // put your code here
//    val s1 = scanner.next()
//    val s2 = scanner.next()
//    val s3 = scanner.nextInt()
//    val s4 = scanner.nextInt()
//    println(s1)
//    println(s2)
//    println(s3)
//    println(s4)
//}
//fun main(args: Array<String>) {
//    val scanner = Scanner(System.`in`)
//    println(scanner.nextLine())
//    println(scanner.nextLine())
//    scanner.nextLine().split("\\s+".toRegex()).forEach { number -> println(number) }
//}
//fun main(args: Array<String>) {
//    val(word1, word2) = Array(2) { readLine()!! }
//    val number = readLine()!!.split(" ")
//    println(word1)
//    println(word2)
//    number.forEach(::println)
//}
//fun main(args: Array<String>) {
//    val scanner = Scanner(System.`in`)
//    for (x in 0 until 4) println(scanner.next())
//}
//fun main(args: Array<String>) {
//    val scanner = Scanner(System.`in`)
//
//    repeat(4) {
//        println(scanner.next())
//    }
//}
import java.util.*
import kotlin.math.roundToInt

//import java.util.function.Consumer
//
//fun main(args: Array<String>) {
//    Scanner(System.`in`).tokens().forEach(Consumer(::println))
//}
//fun main() {
//    val scanner = Scanner(System.`in`)

//    val firstString = scanner.nextLine()
//    val secondString = scanner.nextLine()
//    val numbers = scanner.nextLine().split(" ").map { it.toInt() }

//    println(firstString)
//    println(secondString)
//    numbers.forEach(::println)
//}
//fun main(args: Array<String>) {
//    val magic = 2_000_000_000
//    val giant = 3_000_000_000
//    val w = magic + magic + 1
//    val x = (magic + giant) % 10
//    val y = 100L - magic
//    val z = giant - magic
//
//    println(w.toLong())
//    println(x.toLong())
//    println(y.toLong())
//    print(z.toLong())
//}

//import java.util.Scanner

//fun main(args: Array<String>) {
//    val scanner = Scanner(System.`in`)
//    // put your code here
//    val a = scanner.nextInt()
//    print((a/10) % 10)
//    val number = scanner.nextInt()
//    if (number in 0..9) {
//        println(0)
//    } else {
//        println(number.toString().takeLast(2).first())
//    }
//    try {
//        readLine()?.let { it[it.length - 2] }.let(::println)
//    } catch (e: StringIndexOutOfBoundsException) {
//        println(0)
//    }
//}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
//    // put your code here
//    val a = scanner.nextDouble()
//    val b = scanner.nextDouble()
//    val c = scanner.nextDouble()
//    val d = (a/2).roundToInt()+ (b/2).roundToInt()+(c/2).roundToInt()
        val s1 = scanner.next()
    val s2 = scanner.next()
    println(s1 + s2)
    println(s1 + 5)
//    println(s1 - s2)
//    println(s1 == s2)
//    println(d)
//    print(Math.ceil(((a+b+c)).toDouble()/2))

}
//fun main(args: Array<String>) {
//    val d = 100.675
//    val f = -90f
//    println(Math.ceil(d))
//    println(Math.ceil(f.toDouble()))
//    println(Math.floor(d))
//    println(Math.floor(f.toDouble()))
//}