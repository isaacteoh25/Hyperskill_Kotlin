fun main() {
    val letters = mutableMapOf<Int ,String>()
    var a = ""
    var count= 0
    while (a!= "z") {
        a = readLine().toString()
        count ++
        letters[count] = a
    }
    if (count < 4){
        print("null")
    }
    else {
        print(letters[4])
    }
}
fun main() {
    val letters = mutableMapOf<Int, Char>()
    var i = 0
    do letters[++i] = readLine()!![0] while (letters[i] != 'z')
    print(letters[4])
}

import java.util.*
val scan = Scanner(System.`in`)
fun main() {
    val letters = mutableListOf<String>()
    do {
        val input = scan.next()
        letters.add(input)
    } while (input != "z")
    if (letters.size < 4) {
        println("null")
    } else {
        println(letters[3])
    }
}