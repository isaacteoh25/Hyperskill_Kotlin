package sorting

fun main() {
    val numbers = mutableListOf<Int>()

    while (true) {
        val line = readLine() ?: break

        line.split(Regex("\\s+")).map { it.toInt() }.also { numbers.addAll(it) }
    }

    println("Total numbers: ${numbers.size}.\n" +
            "The greatest number: ${numbers.maxOrNull()} (${numbers.count { it == numbers.maxOrNull() }} time(s)).")
}


fun main() {
    val scanner = Scanner(System.`in`)
    val ll = mutableListOf<Int>()

    while (scanner.hasNextLine()) {
        val w = scanner.nextLine()
        if (w.isEmpty()) break
        val l = w.split("""\s+""".toRegex())
        l.forEach {
            ll.add(it.toInt())
        }
    }
    val maxElem =ll.maxOrNull()
    val cou: List<Int> = ll.filter{it==maxElem}
    println("Total numbers: ${ll.size}.")
    println("The greatest number: $maxElem (${cou.size} time(s))")
}


fun main() {
    // write your code here
    val scanner = Scanner(System.`in`)
    val list = mutableListOf<Int>()
    while (scanner.hasNext()) {
        val a = scanner.nextInt()
        list.add(a)
    }
    val max = list.maxByOrNull { it }
    val count = list.count { it == max }
    println("Total numbers: ${list.count()}.")
    println("The greatest number: $max ($count time(s)).")
}