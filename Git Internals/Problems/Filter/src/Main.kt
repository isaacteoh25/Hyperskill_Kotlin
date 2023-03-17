import java.util.Scanner
fun evenFilter(numbers: Set<Int>): Set<Int> {
    // put your code here
    val num = mutableSetOf<Int>()
    for (n in numbers){
        if (n.toInt() % 2 == 0){
            num.add(n.toInt())
        }
    }
//    print(num)
    return num //% 2
}

fun main(){
    val a = readLine()!!
//    val scanner = Scanner(System.`in`)
//    val arr = scanner.nextLine().split(" ")
    val numbers = mutableSetOf<Int>( 1 , 2 , 3 , 4 , 3)
    print(evenFilter(numbers).joinToString(separator = " "))
//    println(evenFilter(a.split(" ").toSet()).joinToString(" "))
//    val mutableSetA = mutableSetOf<Int>( 1 , 2 , 3 , 4 , 3);
//    println(mutableSetA)


}

//fun evenFilter(numbers: Set<Int>): Set<Int> {
//    return numbers.filter { it % 2 == 0 }.toSet()
//}
//fun evenFilter(numbers: Set<Int>): Set<Int> = numbers.filter { it % 2 == 0 }.toMutableSet()
//
//fun evenFilter(numbers: Set<Int>): Set<Int> {
//    val set = numbers.toMutableSet()
//    set.removeIf { it % 2 != 0 }
//    return set
//}