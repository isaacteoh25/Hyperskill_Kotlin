import java.util.Scanner

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    // put your code here
    val word = input.next()
//    val word = "kotlin"

    loop@ for (i in 'a'..'z') {
        for (j in word.indices) {
            if (word[j] == i) continue@loop
        }
        print(i)
    }
    loop@ for(i in 'a'..'z'){
if (word.contains(i)) continue
        print(i)
        }

    println(('a'..'z').filterNot { word.contains(it) }.joinToString(separator = ""))

    var sl = input.next().toCharArray()
    for (i in 'a' .. 'z'){
        if (i in sl) continue
        print(i)
    }

    for (c in 'a'..'z') {
        if (c !in word) print(c)
    }
    }

fun main() = readLine()!!.run { ('a'..'z').filter { it !in this }.joinToString("").let(::println) }

