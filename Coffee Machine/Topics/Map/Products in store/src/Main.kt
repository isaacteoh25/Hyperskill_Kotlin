fun bill(priceList: Map<String, Int>, shoppingList: Array<String>): Int {
    // put your code here
    var s = 0
    for ((k, v) in priceList) {
        if (k in shoppingList) s += v.toInt()
//        println("$k -> $v")
    }
    return s
//    var total = 0
//    shoppingList.forEach { item ->
//        total += priceList[item] ?: 0
//    }
//    return total
}
fun bill(prices: Map<String, Int>, shoppingList: Array<String>) = shoppingList.mapNotNull { prices[it] }.sum()

fun bill(priceList: Map<String, Int>, shoppingList: Array<String>): Int =
    shoppingList.map { priceList[it] }.sumBy { it ?: 0 }
fun bill(p: Map<String, Int>, s: Array<String>): Int = p.filterKeys { s.contains(it) }.values.sum()

fun bill(priceList: Map<String, Int>, shoppingList: Array<String>): Int =
    priceList.filter { entry -> entry.key in shoppingList }.values.sum()