package sorting

fun main(args: Array<String>) {
    val dataType = if (args.contains("-dataType")) {
        args.elementAtOrNull(args.indexOf("-dataType") + 1) ?: return println("No data type defined!")
    } else "word"
    val sortType = if (args.contains("-sortingType")) {
        args.elementAtOrNull(args.indexOf("-sortingType") + 1) ?: return println("No sorting type defined!")
    } else "natural"

    args.forEach {
        if (it.startsWith('-') && !Data.validArgs.contains(it)) {
            println("\"$it\" is not a valid parameter. It will be skipped.")
        }
    }

    while (true) {
        val line = readLine() ?: break

        Data.input.add(line)
    }

    sortingTool(dataType, sortType)
}

object Data {
    val input = mutableListOf<String>()
    val validArgs = arrayOf("-dataType", "-sortingType")
}

fun sortingTool(dataType: String, sortingType: String) {
    val list = mutableListOf<String>()
    val sortedMap: List<Pair<String, Int>>
    var sep = " "
    var textSortedData = ""
    val textDataType = when (dataType) {
        "long" -> "numbers"
        "word" -> "words"
        else -> "lines"
    }

    if (dataType == "line") list.addAll(Data.input) else {
        Data.input.forEach { it.split(Regex("\\s+")).also { line -> list.addAll(line) } }
    }

    if (dataType == "long") {
        list.forEach { if (it.toLongOrNull() == null) println("\"$it\" is not a long. It will be skipped.") }
        list.removeIf { it.toLongOrNull() == null }
        list.sortBy { it.toLong() }
    } else list.sort()

    if (sortingType == "natural") {
        if (dataType == "line") sep = "\n"
        textSortedData = "Sorted data:" + list.joinToString(sep, sep)
    } else {
        sortedMap = list.groupingBy { it }.eachCount().toList().sortedBy { it.second }
        sortedMap.forEach { (k, v) -> textSortedData += "$k: $v time(s), ${(v / (list.size / 100.0)).toInt()}%\n" }
    }

    print("Total $textDataType: ${list.size}.\n$textSortedData")

}
