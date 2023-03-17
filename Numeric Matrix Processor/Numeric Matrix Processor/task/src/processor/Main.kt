package processor

import java.lang.RuntimeException
import java.math.RoundingMode
import java.text.DecimalFormat
import java.util.*

fun main() {
    val scanner = Scanner(System.`in`).useLocale(Locale.US)
//    matrixMultiply(scanner)
    menu(scanner)
}

private fun menu(scanner: Scanner) {
    var choice: Int
    do {
        println("1. Add matrices")
        println("2. Multiply matrix to a constant")
        println("3. Multiply matrices")
        println("4. Transpose matrices")
        println("5. Calculate a determinant")
        println("6. Inverse matrix")
        println("0. Exit")

        print("Your choice: ")

        choice = scanner.nextInt()
        when (choice) {
            1 -> matrixAdd(scanner)
            2 -> matrixMultiplyScalar(scanner)
            3 -> matrixMultiply(scanner)
            4 -> matrixTranspose(scanner)
            5 -> calculateDeterminant(scanner)
            6 -> inverseMatrix(scanner)
            else -> {} // Do nothing
        }
    } while (choice != 0)
}

private fun matrixAdd(scanner: Scanner) {

    val matrixA = readMatrix(scanner, "first")
    val matrixB = readMatrix(scanner, "second")

    println("The addition result is: ")
    val maybeResult = addMatrices(matrixA, matrixB)
    if (maybeResult == null) {
        println("ERROR")
    } else {
        printMatrix(maybeResult)
    }
}

private fun matrixMultiplyScalar(scanner: Scanner) {
    val matrix = readMatrix(scanner, "first")

    print("Enter scalar: ")
    val scalar = scanner.nextDouble()

    val result = scalarMultiply(matrix, scalar)
    println("The multiplication result is: ")
    printMatrix(result)
}

private fun matrixMultiply(scanner: Scanner) {
    val matrixA = readMatrix(scanner, "first")
    val matrixB = readMatrix(scanner, "second")

    println("The multiplication result is: ")
    val maybeResult = multiplyMatrices(matrixA, matrixB)
    if (maybeResult == null) {
        println("ERROR")
    } else {
        printMatrix(maybeResult)
    }
}

private fun matrixTranspose(scanner: Scanner) {
    println("1. Main diagonal")
    println("2. Side diagonal")
    println("3. Vertical line")
    println("4. Horizontal line")

    print("Your choice: ")

    val transposeFn = when (val choice = scanner.nextInt()) {
        1 -> ::transposeMainDiagonal
        2 -> ::transposeSideDiagonal
        3 -> ::transposeVertical
        4 -> ::transposeHorizontal
        else -> throw RuntimeException("Wrong choice: $choice")
    }

    val matrix = readMatrix(scanner, "")
    val matrixTransposed = transposeFn(matrix)

    println("The result is: ")
    printMatrix(matrixTransposed)
}

private fun calculateDeterminant(scanner: Scanner) {
    val matrix = readMatrix(scanner, "")

    val (rows, cols) = getRowsAndCols(matrix)

    if (rows != cols) {
        println("ERROR: matrix must be square")
        return
    }

    val determinant = calculateDeterminantRecursively(matrix)

    println("The result is: ")
    println(determinant)
}

private fun inverseMatrix(scanner: Scanner) {
    val matrix = readMatrix(scanner, "")

    val (rows, cols) = getRowsAndCols(matrix)

    if (rows != cols) {
        println("ERROR: matrix must be square")
        return
    }

    val maybeInverse = findInverseMatrix(matrix)

    println("The result is: ")
    if (maybeInverse == null) {
        println("ERROR")
    } else {
        printMatrix(maybeInverse)
    }
}

private fun readMatrix(scanner: Scanner, matrixNumber: String): Array<DoubleArray> {

    print("Enter size of $matrixNumber matrix: ")
    val rows = scanner.nextInt()
    val cols = scanner.nextInt()

    val matrix: Array<DoubleArray> = Array(rows) { DoubleArray(cols) { 0.0 } }

    println("Enter $matrixNumber matrix:")
    repeat(rows) { row ->
        repeat(cols) { col ->
            val element = scanner.nextDouble()
            matrix[row][col] = element
        }
    }

    return matrix
}

private fun addMatrices(matrixA: Array<DoubleArray>, matrixB: Array<DoubleArray>): Array<DoubleArray>? {

    val (rowsA, colsA) = getRowsAndCols(matrixA)
    val (rowsB, colsB) = getRowsAndCols(matrixB)

    if (rowsA != rowsB || colsA != colsB) {
        return null
    }

    val result: Array<DoubleArray> = Array(rowsA) { DoubleArray(colsA) { 0.0 } }

    repeat(rowsA) { row ->
        repeat(colsA) { col ->
            result[row][col] = matrixA[row][col] + matrixB[row][col]
        }
    }

    return result
}

private fun scalarMultiply(matrix: Array<DoubleArray>, scalar: Double): Array<DoubleArray> {
    val (rows, cols) = getRowsAndCols(matrix)

    val result: Array<DoubleArray> = Array(rows) { DoubleArray(cols) { 0.0 } }

    repeat(rows) { row ->
        repeat(cols) { col ->
            result[row][col] = matrix[row][col] * scalar
        }
    }

    return result
}

private fun multiplyMatrices(matrixA: Array<DoubleArray>, matrixB: Array<DoubleArray>): Array<DoubleArray>? {
    val (rowsA, colsA) = getRowsAndCols(matrixA)
    val (rowsB, colsB) = getRowsAndCols(matrixB)

    if (colsA != rowsB) {
        return null
    }

    val result: Array<DoubleArray> = Array(rowsA) { DoubleArray(colsB) { 0.0 } }

    repeat(rowsA) { resultRow ->
        repeat(colsB) { resultCol ->

            var acc = 0.0
            repeat(colsA) {
                val elementA = matrixA[resultRow][it]
                val elementB = matrixB[it][resultCol]
                acc += elementA * elementB
            }

            result[resultRow][resultCol] = acc
        }
    }

    return result
}

private fun transposeMainDiagonal(matrix: Array<DoubleArray>): Array<DoubleArray> {
    val (rows, cols) = getRowsAndCols(matrix)

    val result: Array<DoubleArray> = Array(cols) { DoubleArray(rows) { 0.0 } }

    repeat(cols) { row ->
        repeat(rows) { col ->
            result[row][col] = matrix[col][row]
        }
    }

    return result
}

private fun transposeSideDiagonal(matrix: Array<DoubleArray>): Array<DoubleArray> {
    val (rows, cols) = getRowsAndCols(matrix)

    val result: Array<DoubleArray> = Array(cols) { DoubleArray(rows) { 0.0 } }

    repeat(cols) { row ->
        repeat(rows) { col ->
            result[row][col] = matrix[cols - col - 1][rows - row - 1]
        }
    }

    return result
}

private fun transposeVertical(matrix: Array<DoubleArray>): Array<DoubleArray> {
    val (rows, cols) = getRowsAndCols(matrix)

    val result: Array<DoubleArray> = Array(rows) { DoubleArray(cols) { 0.0 } }

    repeat(rows) { row ->
        repeat(cols) { col ->
            result[row][col] = matrix[row][cols - col - 1]
        }
    }

    return result
}

private fun transposeHorizontal(matrix: Array<DoubleArray>): Array<DoubleArray> {
    val (rows, cols) = getRowsAndCols(matrix)

    val result: Array<DoubleArray> = Array(rows) { DoubleArray(cols) { 0.0 } }

    repeat(rows) { row ->
        repeat(cols) { col ->
            result[row][col] = matrix[rows - row - 1][col]
        }
    }

    return result
}

private fun calculateDeterminantRecursively(matrix: Array<DoubleArray>): Double {
    val (_, cols) = getRowsAndCols(matrix)

    if (cols == 1) {
        return matrix[0][0]
    }

    if (cols == 2) {
        val leftPart = matrix[0][0] * matrix[1][1]
        val rightPart = matrix[0][1] * matrix[1][0]
        return leftPart - rightPart
    }

    var result = 0.0
    repeat(cols) { j ->
        val coFactor = calculateCoFactor(matrix, 0, j)

        val element = matrix[0][j]
        val elementDet = element * coFactor

        result += elementDet
    }

    return result
}

private fun calculateCoFactor(matrix: Array<DoubleArray>, i: Int, j: Int): Double {
    val subMatrix = copyMatrixRemovingRowAndCol(matrix, i, j)
    val minor = calculateDeterminantRecursively(subMatrix)

    val sign = if ((i + j) % 2 == 0) 1 else -1

    return sign * minor
}

private fun copyMatrixRemovingRowAndCol(matrix: Array<DoubleArray>, rowToRemove: Int, colToRemove: Int): Array<DoubleArray> {
    val (rows, cols) = getRowsAndCols(matrix)

    val result: Array<DoubleArray> = Array(rows - 1) { DoubleArray(cols - 1) { 0.0 } }

    var resultRow = 0
    for (row in 0 until rows) {
        if (row == rowToRemove) continue

        var resultCol = 0
        for (col in 0 until cols) {
            if (col == colToRemove) continue

            result[resultRow][resultCol] = matrix[row][col]
            resultCol++
        }

        resultRow++
    }

    return result
}

private fun findInverseMatrix(matrix: Array<DoubleArray>): Array<DoubleArray>? {
    val det = calculateDeterminantRecursively(matrix)

    if (det == 0.0) {
        return null
    }

    val (rows, cols) = getRowsAndCols(matrix)
    val coFactorMatrix: Array<DoubleArray> = Array(rows) { DoubleArray(cols) { 0.0 } }

    repeat(rows) { row ->
        repeat(cols) { col ->
            coFactorMatrix[row][col] = calculateCoFactor(matrix, row, col)
        }
    }

    val coFactorTransposed = transposeMainDiagonal(coFactorMatrix)
    val detInverse = 1.0 / det

    return scalarMultiply(coFactorTransposed, detInverse)
}

private fun printMatrix(matrix: Array<DoubleArray>) {
    val (rows, cols) = getRowsAndCols(matrix)

    repeat(rows) { row ->
        repeat(cols) { col ->
            val value = matrix[row][col]

            val df = DecimalFormat("#.##")
            val formatted = df.format(value)
            val formattedAligned = String.format("%6s", formatted)
//print(formatted)
            print(formattedAligned)
            if (col < cols) {
                print(' ')
            }
        }
        println()
    }
}

private fun getRowsAndCols(matrix: Array<DoubleArray>): Pair<Int, Int> {
    val rows = matrix.size
    val cols = matrix[0].size

    return Pair(rows, cols)
}