//import java.util.*
//
//fun main() {
//    // put your code here
//    val input = Scanner(System.`in`)
//    // put your code here
//    val word = input.next()
////    val word = "abracadabra"
//    var count = 0
//    loop@ for (i in word.indices) {
//        for (j in word.indices) {
//            if (word[i] == word[j] && i != j) continue@loop
//        }
//        count = count + 1
//
//    }
//    print(count)
//    println(word.groupBy { it }.values.filter { it.size == 1 }.size)
//    for (ch in word) {
//        val newStr = word.substringAfter(ch)
//        when (newStr.contains(ch)) {
//            false -> count++
//        }
//    }
//
//    println(count)
//
//    val arr = readLine()!!.split("")
//    val arrLonely = arr.groupingBy { it }.eachCount().filter { it.value == 1 }
//    println(arrLonely.size)
//}
//fun main() = println(readLine()!!.groupingBy { it }.eachCount().filterValues { i -> i == 1 }.count())
//
