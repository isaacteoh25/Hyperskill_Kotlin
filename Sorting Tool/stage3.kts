package sorting

import java.util.*
val scanner = Scanner(System.`in`)
var input = mutableListOf<String>()
var type = "word"

fun main(args: Array<String>) {
    if (args.size > 0 && args.contains("-sortIntegers")) type = "sortInt"
    else if (args.size > 0) type = args[1]
    while(scanner.hasNext()) {
        input.add(scanner.nextLine())
    }
    when (type) {
        "long" -> processAsLongs(input)
        "line" -> processAsLines(input)
        "word" -> processAsWords(input)
        "sortInt" -> sortInt(input)
    }
}

fun processAsLongs(input: List<String>) {
    var longs = mutableListOf<Long>()
    input.forEach { x -> x.split("\\s+".toRegex()).map { it.toLong() }.forEach { longs.add(it) } }
    val maxNumber = longs.maxOrNull()
    var counts = longs.count { x -> x == maxNumber }
    println("Total numbers: ${longs.size}.")
    println("The greatest number: $maxNumber ($counts time(s)), ${counts * 100 / longs.size}%")
}

fun processAsLines(input: List<String>) {
    val maxLine = input.maxByOrNull {it.length}
    val counts = input.count { x -> x.length == maxLine!!.length }
    println("Total lines: ${input.size}.\n" +
            "The longest line:\n" +
            "$maxLine\n" +
            "($counts time(s), ${counts * 100 / input.size}%).")
}

fun processAsWords(input: List<String>) {
    var words = mutableListOf<String>()
    input.forEach { x -> x.split("\\s+".toRegex()).map { it }.forEach { words.add(it) } }
    val maxWord = words.maxByOrNull {it.length}
    val counts = words.count { x -> x.length == maxWord!!.length}
    println("Total words: ${words.size}.\n" +
            "The longest word: $maxWord ($counts time(s), ${counts * 100 / words.size}%).")
}

fun sortInt(input: List<String>) {
    var ints = mutableListOf<Int>()
    input.forEach { x -> x.split("\\s+".toRegex()).map { it.toInt() }.forEach { ints.add(it) } }
    println("Total numbers: ${ints.size}.")
    val sortAsc = ints.sorted()
    print("Sorted data: ")
    sortAsc.forEach{ x -> print("$x ") }
}