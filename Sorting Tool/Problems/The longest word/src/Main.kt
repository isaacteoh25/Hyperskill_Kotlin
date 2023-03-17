//val str1 = "aaabbcccdaa"
//var str2 = " "
//
//for (ch in str1) {
//    if (ch != str2.last()) {
//        str2 += ch
//    }
//}
//print(str2)
//}

fun main() {
    // write your code here
    val sentence = readLine()!!
//    val sentence = "a long text"
//    val wordsArray: Array<String> = sentence.split(" ").toTypedArray()
    val wordsList: List<String> = sentence.split(" ")

    val split = sentence.split(" ").maxBy { it.length }.let { println(it) }

}
fun main() = readLine()!!.split(" ").maxByOrNull { it.length }.let(::println)