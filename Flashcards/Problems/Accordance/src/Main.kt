fun main() {
    // put your code here
//    val a = arrayOf(arrayOf("[0][0]", "[0][1]", "[0][2]"),
//        arrayOf("[1][0]", "[1][1]", "[1][2]"))
    val array = Array(2) { row ->
        Array(3)
        { col ->
            "[$row][$col]"
        }
    }

    print(array.contentDeepToString())

    val arr = Array(2) { it0 -> Array(3) { it1 -> "[$it0][$it1]" } }
    println(arr.contentDeepToString())
}