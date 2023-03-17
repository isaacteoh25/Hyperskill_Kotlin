import java.lang.ArithmeticException

fun intDivision(x: String, y: String): Int {

 return x.toInt()/y.toInt()

}

fun main() {
    try {
    val x = readLine()!!
    val y = readLine()!!
    println(intDivision(x, y))
    }
    catch(e: ArithmeticException) {
        println("Exception: division by zero!")
        println(0)
    }

    catch (e: Exception){
        println("Read values are not integers.")
        println(0)

    }
}