fun solution(first: Set<String>, second: Array<String>): Boolean {
    // put your code here
    val a = first.containsAll(second.toSet())
    if (first.size == second.size && a) return true else return false

}
fun solution(first: Set<String>, second: Array<String>): Boolean = (first - second.toSet()).isEmpty()

fun solution(first: Set<String>, second: Array<String>) = first.containsAll(second.toList())