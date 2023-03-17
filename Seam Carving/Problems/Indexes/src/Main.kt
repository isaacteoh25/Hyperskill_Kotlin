


fun solution(products: List<String>, product: String) {
    // put your code here
//    val a = listOf<String>()
////products.forEachIndexed { i, product ->
//
//    a.toMutableList().add(i.toString())
//    val c: List<Int> = a.withIndex().filter { it.value }.map { it.index }
//    return products.count { it == product }
//    val a = booleanArrayOf(true,false,true,false)
//    val c: List<Int> = a.withIndex().filter { it.value }.map { it.index }
//    products.withIndex()
//            .filter { it.value == product }
//            .forEach { print("${it.index} ") }
    val a = intArrayOf(8, 11, 13, 2)
    products.forEachIndexed { index, _product -> if (_product == product) print("$index ") }
//    print(b)
//    return products.forEachIndexed { index, s -> if (s == product) print("$index ") }
   return a.filter { it % 2 == 0 }.forEach { print("${it} ") }
}

fun solution(numbers: List<Int>) = numbers.filter { it % 2 == 0 }
        .joinToString(" ")
        .let { println(it) }
fun main(args: Array<String>) {
//      solution(listOf<String>("Mustard", "Cheese", "Eggs", "Cola", "Eggs" ),"Eggs")
    for (i in 1..4) {
        loop@ for (j in 1..3) {
            for (k in 1..2) {
                if (i == 2 || j == 3 || k == 2) break@loop
                print("$k")
            }
        }
    }
}

//fun solution(strings: List<String>, str: String): Int {
//    // put your code here
//    return strings.count { it == str }
//}
