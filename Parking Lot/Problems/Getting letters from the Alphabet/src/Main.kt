import java.util.Scanner

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)

    val word = input.next()
//    val word = "o"

    loop@ for (i in 'a'..'z') {
       if (word[0] == i) break
        print(i)
    }
    println((('a'..'z').joinToString("")).substringBefore(readLine()!!))

    val r = 'a' until word[0]
    r.forEach(::print)
}