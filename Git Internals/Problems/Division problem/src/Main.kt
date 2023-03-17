//fun solution(first: Set<Int>, second: Set<Int>): Set<Int> {
//     // put your code here
//    val num = mutableSetOf<Int>()
//    var a = 1
//    for (i in second){
//        a *=  i
//    }
//    for (n in first){
//        if (n.toInt() % a  == 0){
//            num.add(n.toInt())
//        }
//    }
////    print(num)
//    return num //% 2
//}
//
//fun mul(num1: Int, num2: Int): Int {
//    var number = num1.times(num2)
//    return number
//}
//fun multiply(second: Set<Int>): Unit = second.forEach { it.sum() }
fun solution(first: Set<Int>, second: Set<Int>): Set<Int> = first.filter { it % (second.size) == 0 }.toMutableSet()

//fun main() {
////    print(multiply(setOf(1,2,4)))
//}


fun solution(first: Set<Int>, second: Set<Int>): Set<Int> {
    val resultSet = emptySet<Int>().toMutableSet()
    val length = second.size
    for (i in first) {
        if (i % length == 0) resultSet.add(i)
    }
    // do'h , I have intresting task)
    /*for (i in second) {
    for (j in first) {
        if (j % i != 0) resultSet.remove(j)
    }
} */
    return resultSet
}