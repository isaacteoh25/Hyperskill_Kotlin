fun solution(strings: MutableList<String>, str: String): MutableList<String> {
    // put your code here
    strings.forEachIndexed { index, _product -> if (_product == str) strings.set(index, "Water") }
//    strings.set(strings.indexOf("Cola"), "Water")
    println(strings)
//    return strings
    return strings.map { if (it == str) "Banana" else it }.toMutableList()
    return strings.toMutableList().apply {
        replaceAll { if (str == it) "Banana" else it }
    }
    val newStrings = mutableListOf<String>()
    for (s in strings) {
        if (s == str) newStrings.add("Banana")
        else newStrings.add(s)
    }
    return newStrings
}
fun solution(strings: MutableList<String>, str: String): MutableList<String> =
        strings.apply { forEachIndexed { index, s -> if (s == str) strings[index] = "Banana" } }

fun main(args: Array<String>) {
    solution(listOf<String>("Mustard", "Cheese", "Eggs", "Cola", "Eggs" ) as MutableList<String>,"Eggs")
}