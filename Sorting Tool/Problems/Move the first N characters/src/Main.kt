fun main() {
    // write your code here
    val wordsList = readLine()!!.split(" ")
    if (wordsList[1].toInt() > wordsList[0].length){
        println(wordsList[0])
    } else    print( wordsList[0].substring(wordsList[1].toInt()) +wordsList[0].substring(0, wordsList[1].toInt()) )
}

fun main() = readLine()!!.split(" ").let { it[0] to it[1].toInt() }.let { println(it.first.drop(it.second) + it.first.take(it.second)) }

fun main() {
    val (s, n) = readLine()!!.split(" ").let { it[0] to it[1].toInt() }
    println(s.drop(n) + s.take(n))
}
