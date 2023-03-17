fun solution(elements: Set<String>, element: String): MutableSet<String> {
    // put your code here
//    val groceries = mutableSetOf(elements)
//    print(groceries)
//    val a = groceries.remove(element)
//    val b = mutableSetOf<String>()
    val a = elements.toMutableSet()
        a.remove(element)
//    println(a.joinToString(" "))
//    a.toString().join(" ")
//    return a.toString().join(" ")
//    return elements.toMutableSet().remove(element)
    return a
}

fun main(){

    print(solution(readLine()!!.split(" ").toSet(), readLine()!!).joinToString(" "))
}

fun solution(elements: Set<String>, element: String) = (elements - element).toMutableSet()

fun solution(es: Set<String>, e: String) = es.toMutableSet().apply { remove(e) }