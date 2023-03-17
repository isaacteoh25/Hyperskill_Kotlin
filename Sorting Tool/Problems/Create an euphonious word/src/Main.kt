fun main() {
    val input = readLine()!!
    var count = 0
    var output = 0
    for (i in input.indices) {
        if (i + 1 < input.length) {
            when {
                input[i].isVowel() && input[i + 1].isVowel() -> count++
                !input[i].isVowel() && !input[i + 1].isVowel() -> count++
                else -> {
                    output += count / 2
                    count = 0
                }
            }
        } else output += count / 2
    }
    println(output)
}

fun Char.isVowel(): Boolean {
    val vowels = "aeiouy"
    return vowels.contains(this.toLowerCase())
}


fun main() {
    // write your code here
    val vowels = arrayOf('a', 'e', 'i', 'o', 'u', 'y')
    val word = readLine()!!.toCharArray()
    var count = 0
    var lastGroupIndex = -1

    for (i in 1 until word.lastIndex) {
        if (lastGroupIndex == i - 1) continue

        val currentSeq = arrayOf(word[i - 1], word[i], word[i + 1])

        if (currentSeq.map { it in vowels }.distinct().size == 1) {
            count++
            lastGroupIndex = i
        }
    }
    println(count)
}

fun main() {
    val input = readLine()!!
    var a1 = 1
    var b1 = 0
    var a2 = 1
    var b2 = 0
    for (i in 0 until input.length - 2) {
        if (input[i] in "aeiouy" && input[i + 1] in "aeiouy" && input[i + 2] in "aeiouy") {
            a1++
            if (a1 % 2 == 0) b1++
            continue
        } else {
            a1 = 1
        }
        if (input[i] !in "aeiouy" && input[i + 1] !in "aeiouy" && input[i + 2] !in "aeiouy") {
            a2++
            if (a2 % 2 == 0) b2++
            continue
        } else {
            a2 = 1
        }
    }
    println(b1 + b2) // write your code here
}
