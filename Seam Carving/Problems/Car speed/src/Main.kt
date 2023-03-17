import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val number1 = scanner.nextInt()
    val number2 = scanner.next()
    if (number2== "no"){
    print(perimeter(number1))
    }
    else{
        print(perimeter(number1, number2.toInt()))
    }
    // write your code here
}
fun perimeter(x1: Int, y1: Int =60): String {
    if (x1 <= y1){
        return "Within the limit"
    }
    else{
    return "Exceeds the limit by ${(x1-y1).toString()} kilometers per hour"
    }
}
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val speed = scanner.nextLine().toInt()
    val limitInput = scanner.nextLine()
    var limit = 60
    when (limitInput) {
        "no limit" -> limit = 60
        else -> limit = limitInput.toString().toInt()
    }

    fun speeding(speed: Int = 60, limit: Int = 60) {
        when {
            limit - speed >= 0 -> println("Within the limit")
            limit - speed < 0 -> println("Exceeds the limit by ${ speed - limit } kilometers per hour")
        }
    }
    speeding(speed, limit)
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val speed = scanner.nextLine()
    val limit = scanner.nextLine()
    checkSpeed(speed.toInt(), limit)
}

private fun checkSpeed(speed: Int, limit: Any = 60) {
    when {
        limit.toString().toIntOrNull() == null -> checkSpeed(speed)
        speed > limit.toString().toInt() ->
            println("Exceeds the limit by ${speed - limit.toString().toInt()} kilometers per hour")
        else -> println("Within the limit")
    }
}