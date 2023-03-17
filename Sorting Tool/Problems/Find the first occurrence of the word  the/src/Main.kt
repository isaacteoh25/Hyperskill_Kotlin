import java.util.*

fun main() {
    // write your code here
// val sentence = "The apple is red."
    try {
//        val sentence = "I ate he red apple."
    val sentence = readLine()!!
        print(sentence.indexesOf("the")[0])
        val index = sentence.indexOf("the", 0, true)
        print(index)
    }
    catch (e: Exception){
        print(-1)
    }

}
fun main() = Scanner(System.`in`).nextLine().toLowerCase().indexOf("the").let { print(it) }

public fun String?.indexesOf(substr: String, ignoreCase: Boolean = true): List<Int> {
    return this?.let {
        val regex = if (ignoreCase) Regex(substr, RegexOption.IGNORE_CASE) else Regex(substr)
        regex.findAll(this).map { it.range.start }.toList()
    } ?: emptyList()
}