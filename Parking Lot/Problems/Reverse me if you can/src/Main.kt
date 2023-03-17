fun reverse(input: Int?): Int {
    return input?.let {
        var r = 0
        var i = it
        while (i > 0) {
            r = r * 10 + i % 10
            i = i / 10
        }
        r
    } ?: -1
}
fun reverse(input: Int?): Int = (input ?: "1-").toString().reversed().toInt()
fun reverse(input: Int?): Int {
    return input?.toString()?.reversed()?.toInt() ?: -1
}


//fun isNumber(input: String?) = input?.toIntOrNull()?.let { input.toInt() } ?: input// write this function
fun isNumber(input: String) = input.toIntOrNull() ?: input

//fun String.intOrString(): Any {
//    val v = toIntOrNull()
//    return when(v) {
//        null -> this
//        else -> v
//    }
//}
fun main(){
    print(isNumber("two"))
}