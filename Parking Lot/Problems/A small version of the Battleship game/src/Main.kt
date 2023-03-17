import java.util.Scanner

//fun main() {
//    val input = Scanner(System.`in`)
//    // put your code here
//
//    val axes = IntArray(6) { input.nextInt() }
//    var rows = ""
//    var columns = ""
//
//    for (x in 1..5) {
//        if (axes[0] == x || axes[2] == x || axes[4] == x) continue
//        rows += "$x "
//    }
//    for (y in 1..5) {
//        if (axes[1] == y || axes[3] == y || axes[5] == y) continue
//        columns += "$y "
//    }
//    println(rows.trim())
//    println(columns.trim())
//}

//fun main(args: Array<String>) {
//    val inp = readLine()!!.split(" ")
//
//    var xCord: String = ""
//    var yCord: String = ""
//
//    for (i in 0..inp.lastIndex step 2) xCord += inp[i] + " "
//    for (j in 1..inp.lastIndex step 2) yCord += inp[j] + " "
//
//    var x = ""
//    var y = ""
//
//    for (i in "12345") {
//        if (i !in xCord.split(" ").joinToString()) x += i + " "
//        if (i !in yCord.split(" ").joinToString()) y += i + " "
//    }
//
//    println(x.trim() + "\n" + y.trim())
//
//}

//
//fun main(args: Array<String>) {
//    val cords = readLine()!!.chunked(4).map { chunk -> chunk.trim().split(' ').map { it.toInt() } }
//    val rows = mutableListOf(1, 2, 3, 4, 5)
//    val cols = mutableListOf(1, 2, 3, 4, 5)
//
//    for (cord in cords) {
//        rows[cord[0] - 1] = 0
//        cols[cord[1] - 1] = 0
//    }
//
//    println(getFreeCell(rows))
//    println(getFreeCell(cols))
//}
//
//private fun getFreeCell(cells: MutableList<Int>): String {
//    return cells.filter { it != 0 }.joinToString(" ")
//}
//
//
//fun main(args: Array<String>) {
//    val input = Scanner(System.`in`)
//    val rows = mutableListOf<Int>(1, 2, 3, 4, 5)
//    val columns = mutableListOf<Int>(1, 2, 3, 4, 5)
//    repeat(3) {
//        val x = input.nextInt()
//        val y = input.nextInt()
//
//        when (x) {
//            1 -> rows.remove(1)
//            2 -> rows.remove(2)
//            3 -> rows.remove(3)
//            4 -> rows.remove(4)
//            5 -> rows.remove(5)
//            else -> return
//        }
//
//        when (y) {
//            1 -> columns.remove(1)
//            2 -> columns.remove(2)
//            3 -> columns.remove(3)
//            4 -> columns.remove(4)
//            5 -> columns.remove(5)
//            else -> return
//        }
//    }
//    println(rows.joinToString(separator = " "))
//    println(columns.joinToString(separator = " "))
//}