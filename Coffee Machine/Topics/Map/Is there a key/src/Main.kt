
//fun containsKeyAndValue(map: Map<String, String>, value: String): Boolean {
//    return map.containsKey(value) && map.containsValue(value)
//}

//fun containsKeyAndValue(map: Map<String, String>, value: String): Boolean {
//    var flag = 0
//    for ((k, v) in map) {
//        if (k == value) {
//            flag++
//        }
//        if (v == value) {
//            flag++
//        }
//    }
//    return if (flag > 1) true else false
//}
//
//fun containsKeyAndValue(m: Map<String, String>, v: String): Boolean = m[v]?.let { m.containsValue(v) } ?: false
//
////fastest with null check O(1) + O(n)
//fun containsKeyAndValue(map: Map<String, String>, value: String) =
//    map[value]?.let { map.containsValue(value) } ?: false

fun isNumber(s: String?): Boolean {
    return !s.isNullOrEmpty() && s.matches(Regex("\\d+"))
}

fun main() {
    val s = "chicken salad123"
    if (isNumber(s)) print("Number") else print("Not a Number")
}