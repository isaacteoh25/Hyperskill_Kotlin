fun main() {

    val rules = readLine().orEmpty().split(" ").map { s -> s.toInt() }.toTypedArray()

    val p = CharArray(rules.last())

    var i = 0
    while (rules[0] > 0 || rules[1] > 0 || rules[2] > 0) {
        if (rules[0]-- > 0) {
            p[i++] = (i % 26 + 65).toChar()
        }
        if (rules[1]-- > 0) {
            p[i++] = (i % 26 + 97).toChar()
        }
        if (rules[2]-- > 0) {
            p[i++] = (i % 10).toString().first()
        }
    }
    while (i < rules[3]) {
        p[i++] = (i % 26 + 97).toChar()
    }

    println(String(p))
}

val lowercase = "abcdefghijklmnopqrstuvwxyz".toCharArray()
val uppercase = lowercase.map { it.toUpperCase() }.toCharArray()
val digits = "0123456789".toCharArray()
val allSymbols = lowercase + uppercase + digits

fun main() {
    val scanner = Scanner(System.`in`)

    val uppercaseCount = scanner.nextInt()
    val lowercaseCount = scanner.nextInt()
    val digitCount = scanner.nextInt()
    val totalSymbols = scanner.nextInt()
    val remainingPart = totalSymbols - digitCount - uppercaseCount - lowercaseCount

    val parts = generatePart(uppercase, uppercaseCount) +
            generatePart(lowercase, lowercaseCount) +
            generatePart(digits, digitCount) +
            generatePart(allSymbols, remainingPart)

    val password = parts.shuffled().fold("", { a, b -> chooseFromPair(a, b) })

    println(password)
}

fun generatePart(alphabet: CharArray, charCount: Int): List<Pair<Char, Char>> {
    return List(charCount) { (0..alphabet.lastIndex).random() }.map {
        Pair(alphabet[it], alphabet[(it + 1) % alphabet.size])
    }
}

fun chooseFromPair(password: String, nextPair: Pair<Char, Char>): String {
    val (first, second) = nextPair
    val lastSymbol = password.lastOrNull()

    return password + if (lastSymbol == first) second else first
}
