package signature

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    print("Enter name and surname: ")
    val name = scanner.nextLine()
    print("Enter person's status: ")
    val status = scanner.nextLine()
    val space = arrayOf("    ", "    ", "    ")
    val a = arrayOf("____", "|__|", "|  |")
    val b = arrayOf("___ ", "|__]", "|__]")
    val c = arrayOf("____", "|   ", "|___")
    val d = arrayOf("___ ", "|  \\", "|__/")
    val e = arrayOf("____", "|___", "|___")
    val f = arrayOf("____", "|___", "|   ")
    val g = arrayOf("____", "| __", "|__]")
    val h = arrayOf("_  _", "|__|", "|  |")
    val i = arrayOf("_", "|", "|")
    val j = arrayOf(" _", " |", "_|")
    val k = arrayOf("_  _", "|_/ ", "| \\_")
    val l = arrayOf("_   ", "|   ", "|___")
    val m = arrayOf("_  _", "|\\/|", "|  |")
    val n = arrayOf("_  _", "|\\ |", "| \\|")
    val o = arrayOf("____", "|  |", "|__|")
    val p = arrayOf("___ ", "|__]", "|   ")
    val q = arrayOf("____", "|  |", "|_\\|")
    val r = arrayOf("____", "|__/", "|  \\")
    val s = arrayOf("____", "[__ ", "___]")
    val t = arrayOf("___", " | ", " | ")
    val u = arrayOf("_  _", "|  |", "|__|")
    val v = arrayOf("_  _", "|  |", " \\/ ")
    val w = arrayOf("_ _ _", "| | |", "|_|_|")
    val x = arrayOf("_  _", " \\/ ", "_/\\_")
    val y = arrayOf("_   _", " \\_/ ", "  |  ")
    val z = arrayOf("___ ", "  / ", " /__")
    val letters = arrayOf(space, a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z)
    val lines = arrayOf(" ", " ", " ", ' ' + status + ' ')
    for (char in name.toLowerCase()) {
        val index = if (char in 'a'..'z') char - 'a' + 1 else 0
        for (line in 0..2) {
            lines[line] += letters[index][line] + ' '
        }
    }
    val length = lines.maxBy { it.length }!!.length
    for (line in 0..3) {
        val lengthDifference = length - lines[line].length + 2
        lines[line] = '*' + lines[line].padStart(lines[line].length + lengthDifference / 2).padEnd(lines[line].length + lengthDifference) + '*'
    }
    printAsterisk(lines[0].length)
    println()
    for (line in lines) println(line)
    printAsterisk(lines[0].length)
}

fun printAsterisk(times: Int = 1) {
    repeat (times) {
        print('*')
    }
}