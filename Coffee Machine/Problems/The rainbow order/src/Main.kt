import java.util.Scanner


//enum class Rainbow(val num: Int) {
//    red(1),
//    orange(2),
//    yellow(3),
//    green(4),
//    blue(5),
//    indigo(6),
//    violet(7)
//
//}

fun main() = println(Rainbow.valueOf(readLine()!!.toString().toUpperCase()).ordinal + 1)
enum class Rainbow {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}
fun main(args: Array<String>) {
    val input = Scanner(System.`in`)

    val c = input.next()

    when (c) {
        "red" -> print("1")
        "orange" -> print("2")
        "yellow" -> print("3")
        "green" -> print("4")
        "blue" -> print("5")
        "indigo" -> print("6")
        "violet" -> print("7")

    }

}
import java.util.Scanner

enum class Rainbow(val number: Int) {
    RED(1),
    ORANGE(2),
    YELLOW(3),
    GREEN(4),
    BLUE(5),
    INDIGO(6),
    VIOLET(7);
    companion object {
        fun findByName(rgb: String): Rainbow? {
            for (enum in Rainbow.values()) {
                if (rgb == enum.name) return enum
            }
            return null
        }
    }



    fun getLevel(): Int {
        return number
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val input = scanner.nextLine().toUpperCase()
    val word = Rainbow.findByName(input)
    println(word?.getLevel())
}