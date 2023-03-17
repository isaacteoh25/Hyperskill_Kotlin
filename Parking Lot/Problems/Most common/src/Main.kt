import java.util.*

fun main() {
    val words = mutableMapOf<String, Int>()
    val scanner = Scanner(System.`in`)
    while (scanner.hasNext()) {
        val word = scanner.next()
        if (word == "stop") break
        words[word] = words.getOrDefault(word, 0) + 1
    }
    val maxValue = words.values.max()
    print(if (maxValue == null) maxValue else words.entries.filter { it.value == maxValue }[0].key)
}


fun main() {
    val words = mutableMapOf<String, Int>()
    var input = readLine()!!
    while (input != "stop") {
        words[input] = (words[input] ?: 0) + 1
        input = readLine()!!
    }
    println(words.maxBy { it.value }?.key)
}

fun main() {
    val words = mutableListOf<String>()
    while (!words.contains("stop")) {
        words.add(readLine()!!)
    }

    println(if (words.size == 1) "null" else {
        words.groupingBy { it }
            .eachCount()
            .maxBy { it.value }
            ?.key
    })
}