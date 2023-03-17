package minesweeper

const val FIELD_SIZE = 9
const val EMPTY_SYMBOL = '.'

class Minesweeper {
    private val minefield: List<MutableList<Char>> = List(FIELD_SIZE) { MutableList(FIELD_SIZE) { EMPTY_SYMBOL } }
    private val emptyLocations = MutableList(FIELD_SIZE * FIELD_SIZE) { Pair(it / FIELD_SIZE, it % FIELD_SIZE) }
    private val mineLocations = mutableListOf<Pair<Int, Int>>()

    fun generateField(mineCount: Int) {
        repeat(mineCount) {
            val (x, y) = emptyLocations.random()
            val currentLocation = Pair(x, y)

            emptyLocations.remove(currentLocation)
            mineLocations.add(currentLocation)
        }

        for ((x, y) in emptyLocations) {
            val adjacentMineCount = countAdjacentMines(x, y)

            if (adjacentMineCount != 0) {
                minefield[x][y] = adjacentMineCount.toString().first()
            }
        }
        printField()
    }

    fun markCell(col: Int, row: Int): Boolean {
        var hasWon = false

        when (minefield[row - 1][col - 1]) {
            '.' -> minefield[row - 1][col - 1] = '*'
            '*' -> minefield[row - 1][col - 1] = '.'
            else -> {
                println("There is a number here")
                return hasWon
            }
        }
        printField()
        hasWon = checkIfWon()
        if (hasWon) println("Congratulations! You found all the mines!")
        return hasWon
    }

    private fun printField() {
        println(" │123456789│")
        println("—│—————————│")
        minefield.forEachIndexed { index, mutableList ->
            println("${index + 1}│${mutableList.joinToString("")}│")
        }
        println("—│—————————│")
    }

    private fun countAdjacentMines(x: Int, y: Int): Int {
        val values = mutableListOf<Boolean>()

        for (col in (x - 1)..(x + 1)) {
            for (row in (y - 1)..(y + 1)) {
                val cellIsAMine = Pair(col, row) in mineLocations
                if (cellIsAMine) values.add(cellIsAMine)
            }
        }
        return values.size
    }

    private fun checkIfWon(): Boolean {
        return mineLocations.map { (x, y) -> minefield[x][y] }
            .all { it == '*' }
    }
}

fun main() {
    print("How many mines do you want on the field? ")
    val mineCount = readLine()!!.toInt()

    val minesweeper = Minesweeper()
    minesweeper.generateField(mineCount)

    while (true) {
        print("Set/delete mines marks (x and y coordinates): ")
        val (col, row) = readLine()!!.split(" ").map { it.toInt() }
        val hasWon = minesweeper.markCell(col, row)

        if (hasWon) break
    }
}