import java.io.File
import java.util.*

// TODO: provide three functions here

//fun generate(functionName: String): (Int) -> Int {
//    // TODO: provide implementation here
////    val scanner = Scanner(System.`in`)
////    var name = scanner.next()
//    if (functionName == "identity") {
//        return ::identity
//    }
//    else if (functionName == "half") {
//        return ::half
//    }
//    else if (functionName == "zero") {
//        return ::zero
//    }
//    else{
//        return ::zero
//    }
//}
//fun identity(x: Int) = x
//fun half(x: Int) = x/2
//fun zero(x: Int) = 0
//
//fun generate(functionName: String): (Int) -> Int {
//    val identity: (Int) -> Int = { it }
//    val half: (Int) -> Int = { it / 2 }
//    val zero: (Int) -> Int = { 0 }
//
//    return when (functionName) {
//        "identity" -> identity
//        "half" -> half
//        else -> zero
//    }
//}
//fun generate(functionName: String): (Int) -> Int {
//    return when (functionName) {
//        "identity" -> { n: Int -> n }
//        "half" -> { n: Int -> n / 2 }
//        else -> { _: Int -> 0 }
//    }
//
//}
//val lambda: (Int, Int) -> Int = { a, b -> a.coerceAtLeast(b) }
//val lambda: (Int, Int) -> Int = { i: Int, i2: Int -> maxOf(i, i2) }
//val lambda: (Int, Int) -> Int = { a: Int, b: Int -> if (a > b) a else b }
//val lambda: (Int, Int) -> Int = lambda@{ a, b ->
//    return@lambda if (a > b) {
//        a
//    } else {
//        b
//    }
//}
//val lambda: (Int, Int) -> Int = { n1, n2 -> kotlin.math.max(n1, n2) }
val list = ArrayList<Long>(2)
//val lambda: (Long, Long) -> List<Long> = { a: Long, b: Long -> (a..b).toList()}
//val lambda: (Long, Long) -> Long = { a: Long, b: Long -> (a..b).toList().reduce{acc, i ->  acc * i}}
//val lambda: (Long, Long) -> Long = { a: Long, z: Long -> var x = 1L; for (y in a..z) x *= y; x }
//val lambda: (Long, Long) -> Long = { x, y -> x.rangeTo(y).reduce { acc, l -> acc * l } }
//val lambda: (Long, Long) -> Long = { a, b -> (a..b).reduce(Long::times) }
//var originalPredicate=  (Char) -> Boolean
//val originalPedicate (Char) -> Boolean = {it=='x'}
fun originalPedicate(c: Char): Boolean = c != '.'
val originalText = 'x'//"I don't know... what to say..."

fun placeArgumen(f: (Char) -> Boolean): (Char) -> Boolean {
    return { i -> !f(i) }
}

//val textWithoutDots = originalText.filter({ c: Char -> c != '.' })
//fun main(args: Array<String>) {
////    println(lambda(1, 4))
////    println(notPredicate('x'))
////    println(textWithoutDots)
////    val list = ArrayList<Int>(2)
////    val list = lambda(1,4)
////    list.stream()
////            .forEach({ i -> println(i) })
//
//    val increment = placeArgument(1, ::sum)
//    val triple = placeArgument(3, mul2)
//    val notPredicate= placeArgumen (::originalPedicate)
//    println(notPredicate)
//    println(increment(4))   // 5
//    println(increment(40))  // 41
//    println(triple(4))      // 12
//    println(triple(40))     // 120
//}
//fun placeArgument(value: Int, f: (Int, Int) -> Int): (Int) -> Int {
//    return { i -> f(value, i) }
//}
//fun sum(a: Int, b: Int): Int = a + b
//val mul2 = { a: Int, b: Int -> a * b }

fun main() {
    val fileName = "src/new.txt"
    val linesLength = File(fileName).length()
    val lines = File(fileName).readLines().size
    print("$linesLength $lines")
}