import java.util.*

fun main(args: Array<String>) {
    var d = 0
    var c = 0
    var b = 0
    var a = 0
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    // put your code here
    repeat(n) {
        val next = scanner.nextInt()
        if (next == 2){
            d += 1
        }
        if (next == 3){
            c += 1
        }
        if (next == 4){
            b += 1
        }
        if (next == 5){
            a += 1
        }
    }
    print(d.toString() + " " + c.toString() + " " + b.toString() + " " + a.toString())
    repeat(count) {
        val next = scanner.nextInt()
        if (next == 2) d++
        if (next == 3) c++
        if (next == 4) b++
        if (next == 5) a++
    }
    print("$d $c $b $a")
    fun main() = Scanner(System.`in`).run { Array(nextInt()) { nextInt() } }.run {
        println("${count { it == 2 }} ${count { it == 3 }} ${count { it == 4 }} ${count { it == 5 }}")
    }
    var (D, C, B, A) = IntArray(4) { 0 }

    val students = scanner.nextInt()
    repeat(students) {
        when (scanner.nextInt()) {
            2 -> D += 1
            3 -> C += 1
            4 -> B += 1
            5 -> A += 1
        }
    }

    println("$D $C $B $A")

    val arr = mutableListOf<Int>()
    repeat(scanner.nextInt()) {
        arr.add(scanner.nextInt())
    }
    val arr2 = arr.filter { it == 2 }.count()
    val arr3 = arr.filter { it == 3 }.count()
    val arr4 = arr.filter { it == 4 }.count()
    val arr5 = arr.filter { it == 5 }.count()

    println("$arr2 $arr3 $arr4 $arr5")

}
