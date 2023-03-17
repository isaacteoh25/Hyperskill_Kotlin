package search

//fun main() {
////    val a = readLine()!!.split(" ")
////    val b = readLine()
////    if (a.contains(b)) println(a.indexOf(b) + 1) else println("Not found")
//}

//import Criteria
//import utility.*
import java.io.File

enum class Criteria {
    ALL, ANY, NONE;

    fun print(indexes: Array<Int>, everyone: Array<String>) {
        when (this) {
            ALL, ANY -> {
//                println("\n${indexes.size} persons found:")
                println("\nFound people:")
                for (num in indexes) println(everyone[num])
            }
            NONE -> {
                println("\n${everyone.size - indexes.size} persons found:")
                if (indexes.isEmpty()) everyone.forEach { println(it) } else {
                    for (num in everyone.indices) if (!indexes.contains(num)) println(everyone[num])
                }
            }
        }
    }
}
private lateinit var EVERYONE: Array<String>
private lateinit var CRITERIA: Criteria
private lateinit var EVERYONE_MAP: Map<String, Array<Int>>
var persons = mutableListOf<List<String>>()
var isFound = false

fun main(args: Array<String>) {
    val filename: String
    var fileFound = true

    try {
        if (args[0] != "--data" || !File(args[1]).isFile) fileFound = false
    } catch (e: Exception) {
        fileFound = false
    }

    filename = if (!fileFound) {
        print(if (args.isNotEmpty() && args.size == 2) "Loading ${args[1]} failed." else "No filename provided.")
        println(" Loading default file names.txt for searching.\n")
        "C:\\Users\\746046\\IdeaProjects\\Simple Search Engine\\Simple Search Engine\\task\\src\\search/names.txt"
    } else args[1]

    initialize(filename)
//    menu()
//    println("\nBye!")
//   addToStorage()

//    File(fileName).forEachLine {
//        muteLines.add(it)
//        val split = splitToArray(it)
//        for (word in split) {
//            if (muteMap.containsKey(word)) {
//                muteMap[word]?.add(count)
//            } else muteMap[word] = mutableListOf(count)
//        }
//        count++
//    }

menu()
    println("\nBye!")
}

fun addToStorage () {
    val muteMap = mutableMapOf<String, MutableList<Int>>()
    val muteLines = mutableListOf<String>()
//    var count = 0
    println("Enter the number of people:")
    val count = readLine()!!.toInt()
    println("Enter all people:")
    repeat(count) {
        val line = readLine()!!
        persons.add(line.split("\\s+".toRegex()))
        muteLines.add(line)
        val split = splitToArray(line)
        for (word in split) {
            if (muteMap.containsKey(word)) {
                muteMap[word]?.add(count)
            } else muteMap[word] = mutableListOf(count)
        }
        val mapHold = mutableMapOf<String, Array<Int>>()
        for (string in muteMap.keys) mapHold[string] = muteMap[string]!!.toTypedArray()

        EVERYONE_MAP = mapHold.toMap()
        EVERYONE = muteLines.toTypedArray()
    }
    println()
}
private fun initialize(fileName: String) {
    val muteMap = mutableMapOf<String, MutableList<Int>>()
    val muteLines = mutableListOf<String>()
    var count = 0

    File(fileName).forEachLine {
        muteLines.add(it)
        persons.add(it.split("\\s+".toRegex()))
        val split = splitToArray(it)
        for (word in split) {
            if (muteMap.containsKey(word)) {
                muteMap[word]?.add(count)
            } else muteMap[word] = mutableListOf(count)
        }
        count++
    }
    val mapHold = mutableMapOf<String, Array<Int>>()
    for (string in muteMap.keys) mapHold[string] = muteMap[string]!!.toTypedArray()

    EVERYONE_MAP = mapHold.toMap()
    EVERYONE = muteLines.toTypedArray()
}

private fun menu() {
    val menu = "=== Menu ===\n1. Find a person\n2. Print all people\n0. Exit"
    var read = getString(menu)
    val num = { read.toIntOrNull() ?: getNum(read, true) }
    var exit = false

    while (!exit) {
        when (num()) {
            1 -> find()
            2 -> printAll()
            0 -> exit = true
            else -> incorrectOption()
        }
        if (!exit) read = getString("\n$menu")
    }
}

private fun find() {
    CRITERIA = when (getString("\nSelect a matching strategy: ALL, ANY, NONE").toLowerCase().trim()) {
        "all" -> Criteria.ALL
        "any" -> Criteria.ANY
        "none" -> Criteria.NONE
        else -> {
            incorrectOption()
            find()
            return
        }
    }
    findCriteria()
}

fun search() {
//    println("Enter the number of search queries:")
//    val count = readLine()!!.toInt()
//    println()
//    repeat(count) {
        isFound = false
        println("Enter data to search people:")
        val query = readLine()!!
        var result = "\nFound people:\n"
        persons.forEach({result += simpleSearch(it, query)})
        if (isFound) {
            println(result)
        } else {
            println("No matching people found.\n")
        }
//    }
}
fun simpleSearch(list: List<String>, query: String): String {
    var res = ""
    for (element in list) {
        if (element.toLowerCase().contains(query.toLowerCase())) {
            res = list.joinToString(" ") + "\n"
            isFound = true
        }
    }
    return res
}

private fun findCriteria() {
    var found = true
    val search = splitToArray(getString("\nEnter a name or email to search all suitable people.").toLowerCase())
    val indexes = mutableListOf<Int>()

    for (word in search) {
        if (EVERYONE_MAP.containsKey(word)) {
            if (indexes.isEmpty()) EVERYONE_MAP[word]?.forEach { indexes.add(it) } else {
                val tempList = EVERYONE_MAP[word]?.toList()
                if (CRITERIA == Criteria.ALL) {
                    var done = false
                    while (!done && indexes.isNotEmpty()) {
                        for (num in indexes.indices) {
                            if (!tempList!!.contains(indexes[num])) {
                                indexes.removeAt(num)
                                break
                            }
                        }
                        done = true
                    }
                    if (indexes.isEmpty()) break
                } else for (num in tempList!!) if (!indexes.contains(num)) indexes.add(num)
            }
        } else if (CRITERIA == Criteria.ALL) {
            found = false
            break
        }
    }
    if (found && indexes.isEmpty() && CRITERIA != Criteria.NONE) found = false
    if (found) CRITERIA.print(indexes.toTypedArray(), EVERYONE) else println("\nNo matching people found.")
}

private fun printAll() {
    println("\n=== List of people ===")
    EVERYONE.forEach { println(it) }
}

private fun incorrectOption() = println("\nIncorrect option! Please try again.")

fun splitToArray(words: String): Array<String> {
    var hold = words.trim()
    while (hold.contains("  ")) hold = hold.replace("  ", " ")
    return hold.toLowerCase().split(" ").toTypedArray()
}

fun getNum(text: String, defaultMessage: Boolean = false): Int {
    val strErrorNum = " was not a number, please try again: "
    var num = text
    var default = defaultMessage

    do {
        num = getString(if (default) num + strErrorNum else num)
        if (!default) default = true
    } while (!isNumber(num))

    return num.toInt()
}

fun getString(text: String): String {
    println(text)
    return readLine()!!
}

fun isNumber(number: String) = number.toIntOrNull() != null