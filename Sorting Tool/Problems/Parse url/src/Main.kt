fun main() {
    val inp = readLine()!!.split("?")[1]
    val process = inp.split("&")

    var password = ""
    for (value in process) {
        val (x, y) = value.split("=")

        if (x == "pass") password += "password : $y"
        if (y != "") println("$x : $y") else println("$x : not found")
    }
    println(password)
}

fun main() {
    val sp = readLine()!!
        .substringAfter("?")
        .split("&")
        .map { it.split("=").let { it[0] to it[1] } }
        .toMutableList()
    sp.indexOf(Pair("cookie", "")).let { if (it >= 0) sp[it] = Pair("cookie", "not found") }
    sp.forEach { println(it.first + " : " + it.second) }
    sp.find { it.first == "pass" }.let { if (it != null) println("password : " + it.second) } }


fun main() {
    parseUrl(readLine()!!)
}

fun parseUrl(website: String) {
    val map = website.split("?")
    val subMap = map[1].split("&")
        .map { it.split("=") }
        .map { it.first() to it.last() }
        .toMap()
    subMap.forEach { (key, value) ->
        if (value == "") {
            println("$key : not found")
        } else {
            println("$key : ${subMap[key]}")
        }
    }
    if (subMap.containsKey("pass")) println("password : ${subMap["pass"]}")
}