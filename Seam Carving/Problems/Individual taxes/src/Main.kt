import java.util.*
import kotlin.math.max

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val array = IntArray(scanner.nextInt()) { scanner.nextInt() }
    val array2 = IntArray(array.size) { scanner.nextInt() }
    val array3 = IntArray(array.size) { 0 }
    for (i in array.indices) {
        array3[i] = array[i] * array2[i]
    }
    println(array3.indexOf(array3.max()!!) + 1)
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // write your code here
    val n = scanner.nextInt()
    val incomes = IntArray(n) { scanner.nextInt() }
    val taxes = IntArray(n) { scanner.nextInt() }

    val companyWhoPaysMore = incomes
            .zip(taxes)
            .withIndex()
            .maxBy { it.value.first * it.value.second }!!
            .index + 1

    println(companyWhoPaysMore)
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val size = scanner.nextInt()
    val countriesAndTaxes = DoubleArray(size) { scanner.nextDouble() }.zip(
            DoubleArray(size) { scanner.nextDouble() }
    ).toMap()

    val taxes = countriesAndTaxes.map {
        if (it.value > 0) {
            it.key * (it.value / 100)
        } else {
            it.key * 0
        }
    }

    print(taxes.indexOf(taxes.max()) + 1)
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val size = scanner.nextInt()
    val companies = IntArray(size) { scanner.nextInt() }
    val taxes = IntArray(size) { scanner.nextInt() }
    var maxTaxes = 0
    var companyWithMaxTaxes = 0

    for (i in 0..companies.lastIndex) {
        val companyTaxes = companies[i] * taxes[i]
        if (companyTaxes > maxTaxes) {
            maxTaxes = companyTaxes
            companyWithMaxTaxes = i + 1
        }
    }

    println(companyWithMaxTaxes)
}

fun main(args: Array<String>) {
    val (n, yearlyIncomes, individualTaxes) = Scanner(System.`in`)
            .let { scanner -> Array(3) { readLine()!!.split(" ") } }
    val incomesAndTaxesPairs = (yearlyIncomes zip individualTaxes zip 1..n[0].toInt())
            .map { it.first.first.toInt() * it.first.second.toInt() / 100.0 to it.second }.sortedBy { it.first }
    incomesAndTaxesPairs.filter { incomesAndTaxesPairs.last().first == it.first }[0].second.let(::println)
}