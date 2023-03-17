import java.math.BigInteger
fun main() {
    // write your code here
    val a = readLine()!!.toBigInteger()
    val b = readLine()!!.toBigInteger()
    val r = a + b
    println("${(a * 100.toBigInteger()) / r}% ${b * 100.toBigInteger() / r}%")


    val result = 5.5.addInt(10)
    print(result)
}
fun Double.addInt(i: Int) = this + i.toDouble()