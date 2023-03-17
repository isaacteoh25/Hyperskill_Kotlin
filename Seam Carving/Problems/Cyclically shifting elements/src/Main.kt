import java.util.*
fun append(arr: Array<Int>, element:Int):Array<Int>{
    val list: MutableList<Int> = arr.toMutableList()
    list.add(element)
    return list.toTypedArray()
}
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // write your code here
//    var array = arrayOf(1, 2, 3, 4)
    var array = arrayOf<Int>()
//    var array: ArrayList<Int> = ArrayList()
    var n = scanner.nextInt()
    for (index in 0..n-1)
    {
//        array = arrayOf(scanner.nextInt())
//       array.add(scanner.nextInt())
        array= append(array,scanner.nextInt())
//        array[index]=scanner.nextInt()
    }

    (0 until 1).forEach {
        array = arrayOf(array.last()) + array.sliceArray(0 until array.size - 1)
        array.forEach { print(it.toString() + " ") }
    }

}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val array = IntArray(scanner.nextInt())
    for (i in array.indices) {
        if (i < array.size - 1) {
            array[i + 1] = scanner.nextInt()
        }
    }
    array[0] = scanner.nextInt()
    println(array.joinToString().replace(",", ""))
}
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val number = scanner.nextInt()
    val array = IntArray(number) { scanner.nextInt() }
    val shiftedArray = IntArray(number)
    for (i in array.indices) {
        shiftedArray[i] = array[(array.size + i - 1) % array.size]
    }
    for (i in array.indices) {
        print("${shiftedArray[i]} ")
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val size = scanner.nextInt()
    val oldarray = IntArray(size) { scanner.nextInt() }
    val newarray = IntArray(size)
    newarray[0] = oldarray[oldarray.size - 1]
    for (i in 1..oldarray.lastIndex) { newarray[i] = oldarray[i - 1] }
    for (i in newarray) { print("$i ") }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val n = scanner.nextInt()
    val numbers = IntArray(n)
    for (i in 1..n) {
        numbers[i % n] = scanner.nextInt()
    }
    println(numbers.joinToString(" "))
}