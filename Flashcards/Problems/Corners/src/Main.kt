

fun main(){
    val inputArray = arrayOf(
        arrayOf(1, 0, 0, 1),
        arrayOf(0, 0, 0, 0),
        arrayOf(1, 0, 0, 1)
    )
    val size = inputArray.size - 1
    val a1 = inputArray[0].first()
    val a2 = inputArray[0].last()
    val b1 = inputArray[size].first()
    val b2 = inputArray[size].last()

    println("$a1 $a2")
    println("$b1 $b2")

    val d = inputArray[inputArray.lastIndex]
    val e = d[d.lastIndex]
    println("${inputArray[0][0]} ${inputArray[0][inputArray[0].lastIndex]}\n${inputArray[inputArray.lastIndex][0]} $e")
}

