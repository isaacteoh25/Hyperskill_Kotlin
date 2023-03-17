//
//fun main() {
//    val library = mutableMapOf<String, Int>()
//    library["The Art of Computer Programming"] = 2
//    library["Design Patterns"] = 4
//    library["Cracking the Coding Interview"] = 3
//    library["Design Patterns"] = 5
//    library["Clean code"] = 1
//    library.remove("Clean code")
//    var total = 0
//    for (entry in library) {
//        total += entry.value
//    }
//    print(total)
//}
fun main() {
    val vowels = "AEIOU"
    val letters = mutableMapOf<Char, Int>()
    for (k in 'A'..'Z') letters[k] = if (k in vowels) k - 'A' + 1 else 0
    val ch = readLine()!![0].toUpperCase()
    println(letters[ch])
}


fun main() {
    val letter = readLine()!!.toLowerCase()
    val alfa = mutableMapOf<String, Int>()
    val vovels = "aeiou".toCharArray()

    var i = 1

    for (a in 'a'..'z') {
        alfa[a.toString()] = i++
    }

    if (!vovels.contains(letter.single())) {
        println(0)
    } else {
        println(alfa.get(letter))
    }
}