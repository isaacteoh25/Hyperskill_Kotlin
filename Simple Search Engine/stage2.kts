package search

fun main() {
    val dataset = Array<String>(readLine()!!.toInt()) { readLine()!! }

    for (n in 1..readLine()!!.toInt()) {
        val query = readLine()!!
        val result = dataset.searchValue(query)
        if (result.isEmpty()) println("No matching people found")
        else {
            for (value in result) println(value)
        }
    }

}

fun Array<String>.searchValue(query: String): Array<String> {
    val found: MutableList<String> = mutableListOf()
    for (value in this) {
        if (value.contains(query, true)) found.add(value)
    }
    return found.toTypedArray()
}