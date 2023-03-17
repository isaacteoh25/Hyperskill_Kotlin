package minesweeper

fun main() {
    print("How many mines do you want on the field? ")
    val mineCount = readLine()!!.toInt()

    val mineField = Array(9) { Array(9) {"."} }
    val cellLocations = MutableList(9 * 9) { Pair(it / 9, it % 9) }

    repeat(mineCount) {
        val (x, y) = cellLocations.random()
        mineField[x][y] = "X"
        cellLocations.remove(Pair(x, y))
    }

    mineField.map { it.joinToString("") }
        .forEach(::println)
}