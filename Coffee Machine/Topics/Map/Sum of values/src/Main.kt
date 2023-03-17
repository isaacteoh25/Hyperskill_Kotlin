fun summator(map: Map<Int, Int>): Int {
    // put your code here
    var s = 0
    for ((k, v) in map) {
        if (k % 2 == 0) s += v.toInt()
//        println("$k -> $v")
    }
    return s
}
fun summator(map: Map<Int, Int>): Int = map.filter { it.key % 2 == 0 }.values.sum()

fun summator(map: Map<Int, Int>): Int =
    map.toList().sumBy { if (it.first % 2 == 0) it.second else 0 }

fun summator(map: Map<Int, Int>): Int = map.filterKeys { it % 2 == 0 }.values.sum()

// Using fold instead of sum operator
fun summator(map: Map<Int, Int>) = map.filterKeys { it % 2 == 0 }.values.fold(0) { sum, element -> sum + element }


fun summator(map: Map<Int, Int>): Int {
    fun Int.isEven() = this % 2 == 0
    return map.filter { entry -> entry.key.isEven() }.values.sum()
}