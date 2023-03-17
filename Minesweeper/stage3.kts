package minesweeper

const val FIELD_SIZE = 9
const val MINE_SYMBOL = 'X'
const val EMPTY_SYMBOL = '.'

fun <T> Array<Array<T>>.adjacentValues(x: Int, y: Int): MutableList<T> {
    val values = mutableListOf<T>()

    for (col in (x - 1)..(x + 1)) {
        for (row in (y - 1)..(y + 1)) {
            val cellSymbol = this.getOrNull(col)?.getOrNull(row)
            cellSymbol ?: continue
            values.add(cellSymbol)
        }
    }
    return values
}

fun main() {
    print("How many mines do you want on the field? ")
    val mineCount = readLine()!!.toInt()

    val mineField = Array(FIELD_SIZE) { Array(FIELD_SIZE) { EMPTY_SYMBOL } }
    val cellLocations = MutableList(FIELD_SIZE * FIELD_SIZE) { Pair(it / FIELD_SIZE, it % FIELD_SIZE) }

    repeat(mineCount) {
        val (x, y) = cellLocations.random()
        mineField[x][y] = MINE_SYMBOL
        cellLocations.remove(Pair(x, y))
    }

    for ((x, y) in cellLocations) {
        val adjacentMineCount = mineField.adjacentValues(x, y)
            .count { it == MINE_SYMBOL }

        if (adjacentMineCount != 0) {
            mineField[x][y] = adjacentMineCount.toString().first()
        }
    }

    mineField.map { it.joinToString("") }
        .forEach(::println)
}