import java.util.Scanner
//fun main() {
//    val bob = Client("Bob", 29, "Male")
//    val john = bob.copy(name = "John", age = 21)
//    val robert = john.copy(name = "Robert")
//    println(bob.age + john.age + robert.age)
//}
//data class Client(val name: String, val age: Int, val gender: String) {
//    var balance: Int = 0
//
//    override fun toString(): String {
//        return "Client(name='$name', age=$age, gender='$gender', balance=$balance)"
//    }
//
//}
// do not change this data class
data class Box(val height: Int, val length: Int, val width: Int)

fun main(args: Array<String>) {
//    val input = Scanner(System.`in`)
//    // implement your code here
//    val a = input.nextInt()
//    val b = input.nextInt()
//    val c = input.nextInt()
//    val d = input.nextInt()
//    val box = Box(height=a, length=b, width=d)
//    val bo = box.copy(height=a, length=c, width=d)
//    println(box)
//    println(bo)
    val (h, l1, l2, w) = readLine()!!.split(" ").map { it.toInt() }
    val b1 = Box(h, l1, w)
    val b2 = b1.copy(length = l2)
    print("$b1\n$b2\n")
}