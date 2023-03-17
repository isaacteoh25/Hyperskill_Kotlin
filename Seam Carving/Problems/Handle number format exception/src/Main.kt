import java.lang.Exception

fun parseCardNumber(cardNumber: String): Long {
    val a = cardNumber.split(" ")
//    print(a)
//    val commaSeperatedString = a.joinToString (separator = "-") { it -> "\'${it}\'" }
//    print(commaSeperatedString)
    if (a.size == 4) {
        return a.joinToString (separator = "") { it }.toLong()
    }
    else{
        throw Exception("Item price can't be negative")
    }
    if (cardNums.count() == 4) {
        return cardNums.joinToString("").toLong()
    }
    }
//    return cardNumber.toLong()/4
}
fun parseCardNumber(cardNumber: String): Long {
    val count = cardNumber.count { it.isWhitespace() }
    if (count != 3) {
        throw Exception("Invalid Card Number!")
    }
    return cardNumber.replace(" ", "").toLong()

    for (i in 4..14 step 5) {
        if (!cardNumber[i].isWhitespace()) throw Exception()
    }
    return cardNumber.replace(" ", "").toLong()
}
//fun main(){
//    parseCardNumber("AAAA AAAA AAAA AAAA")
//}