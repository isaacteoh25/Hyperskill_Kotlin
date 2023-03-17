import java.util.*
//
//
//fun main(args: Array<String>) {
//    val scanner = Scanner(System.`in`)
////    var array = arrayOf<Int>()
//    var array: ArrayList<Int> = ArrayList()
//    val i = scanner.nextInt()
//    for (index in 0..i-1)
//    {
////        array= append(array, scanner.nextInt())
//        array.add(scanner.nextInt())
//    }
//    val n: Int = i
////    array.add(scanner.nextInt())
//    val r = scanner.nextInt()
////    val list = array.toList()
////    Collections.rotate(list, -(r - 1))
////    println(list.toIntArray().joinToString())
//    rightRotate(array, r, n);
//    printArray(array, n);
//}
//
//fun reverseArray(arr: ArrayList<Int>, start: Int,
//                 end: Int) {
//    var start = start
//    var end = end
//    while (start < end) {
//        val temp = arr[start]
//        arr[start] = arr[end]
//        arr[end] = temp
//        start++
//        end--
//    }
//}
//fun rightRotate(arr: ArrayList<Int>, d: Int, n: Int) {
//    reverseArray(arr, 0, n - 1)
//    reverseArray(arr, 0, d - 1)
//    reverseArray(arr, d, n - 1)
//}
//fun printArray(arr: ArrayList<Int>, size: Int) {
////    for (i in 0 until size)
//        print(arr.toString() + " ")
//}
fun append(arr: Array<Int>, element:Int):Array<Int>{
    val list: MutableList<Int> = arr.toMutableList()
    list.add(element)
    return list.toTypedArray()
}
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    var arr = arrayOf<Int>()
//    var array: ArrayList<Int> = ArrayList()
    var n = scanner.nextInt()
    for (index in 0..n-1)
    {
//        array = arrayOf(scanner.nextInt())
//       array.add(scanner.nextInt())
        arr= append(arr,scanner.nextInt())
//        array[index]=scanner.nextInt()
    }
    val list = arr.toList()
    val r = scanner.nextInt()
    Collections.rotate(list, r)
    println(list.toIntArray().joinToString(" "))
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val size = scanner.nextInt()
    val array = IntArray(size) { scanner.nextInt() }
    val rotation = scanner.nextInt()
    val new = array.rightRotation(rotation % size)
    for (e in new) print("$e ")

}
fun IntArray.rightRotation(n: Int): List<Int> {
    val front = this.dropLast(n)
    val back = this.drop(this.size - n)
    return back.plus(front)
}
fun main() {
    val scanner = Scanner(System.`in`)
    val number = scanner.nextInt()
    val array = IntArray(number) { scanner.nextInt() }
    val shifts = scanner.nextInt() % array.size
    val shiftedArray = IntArray(number)
    for (i in array.indices) {
        shiftedArray[i] = array[(array.size + i - shifts) % array.size]
    }
    for (i in shiftedArray) print("$i ")
}
fun main() {
    val scanner = Scanner(System.`in`)
    val numbers = MutableList(scanner.nextInt()) { scanner.nextInt() }

    repeat(scanner.nextInt() % numbers.size){
        numbers.add(0, numbers.last())
        numbers.removeAt(numbers.lastIndex)
    }

    println(numbers.joinToString(" "))
}
