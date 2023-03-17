import java.util.*
//
//enum class Country(val country: String, val currency: String) {
//    GERMANY("Germany", "Euro"),
//    MALI("Mali", "CFA franc"),
//    DOMINICA("Dominica", "Eastern Caribbean dollar"),
//    CANADA("Canada", "Canadian dollar"),
//    SPAIN("Spain", "Euro"),
//    AUSTRALIA("Australia", "Australian dollar"),
//    BRAZIL("Brazil", "Brazilian real"),
//    SENEGAL("Senegal", "CFA franc"),
//    FRANCE("France", "Euro"),
//    GRENADA("Grenada", "Eastern Caribbean dollar"),
//    KIRIBATI("Kiribati", "Australian dollar"),
//    NULL("", "");
//
//    companion object {
//
//        fun findByName(country: String): String {
//            for (enum in values()) {
//                if (country == enum.country) return enum.currency
//            }
//            return "false"
//        }
//    }
//
//
//
//}
//fun main(args: Array<String>) {
//    val scanner = Scanner(System.`in`)
//    val input1 = scanner.nextLine().split(" ")
////    val input2 = scanner.nextLine()
//    val country1 = Country.findByName(input1[0])
//    val country2 = Country.findByName(input1[1])
//    if (country1 == country2)println("true") else print("false")
//}




//enum class DictionaryOfCurrency(val currency: String) {
//    Germany("Euro"),
//    Mali("CFA franc"),
//    Dominica("Eastern Caribbean dollar"),
//    Canada("Canadian dollar"),
//    Spain("Euro"),
//    Australia("Australian dollar"),
//    Brazil("Brazilian real"),
//    Senegal("CFA franc"),
//    France("Euro"),
//    Grenada("Eastern Caribbean dollar"),
//    Kiribati("Australian dollar")
//}
//
//fun main(args: Array<String>) {
//    val input = Scanner(System.`in`)
//    val country1 = input.next()
//    val country2 = input.next()
//    try {
//        print(DictionaryOfCurrency.valueOf(country1).currency ==
//                DictionaryOfCurrency.valueOf(country2).currency)
//    } catch (e: IllegalArgumentException) {
//        print(false)
//    }
//}


//fun main(args: Array<String>) {
//    val input = Scanner(System.`in`)
//
//    val con1 = input.next()
//    val con2 = input.next()
//
//    println(Country.same(con1, con2))
//}
//
//enum class Country(val currency: String) {
//    Germany("Euro"),
//    Mali("CFA franc"),
//    Dominica("Eastern Caribbean dollar"),
//    Canada("Canadian dollar"),
//    Spain("Euro"),
//    Australia("Australian dollar"),
//    Brazil("Brazilian real"),
//    Senegal("CFA franc"),
//    France("Euro"),
//    Grenada("Eastern Caribbean dollar"),
//    Kiribati("Australian dollar");
//
//    companion object {
//        fun same(con1: String, con2: String): Boolean {
//            if (!isNameExist(con1) || !isNameExist(con2)) {
//                return false
//            }
//            return valueOf(con1).currency.equals(valueOf(con2).currency, true)
//        }
//
//        fun isNameExist(name: String): Boolean {
//            val countryName = Array(values().size) { "" }
//            var index = 0
//
//            for (country in values()) {
//                countryName[index] = country.name.toUpperCase()
//                index++
//            }
//            return countryName.contains(name.toUpperCase())
//        }
//    }
//}


enum class Currency(val currency: String) {
    AustralianDollar("Australian dollar"),
    BrazilianReal("Brazilian real"),
    CanadianDollar("Canadian dollar"),
    CFAFrank("CFA franc"),
    EasternCaribbeanDollar("Eastern Caribbean dollar"),
    Euro("Euro"),
}

enum class Country(val currency: Currency) {
    Australia(Currency.AustralianDollar),
    Brazil(Currency.BrazilianReal),
    Canada(Currency.CanadianDollar),
    Dominica(Currency.EasternCaribbeanDollar),
    France(Currency.Euro),
    Germany(Currency.Euro),
    Grenada(Currency.EasternCaribbeanDollar),
    Kiribati(Currency.AustralianDollar),
    Mali(Currency.CFAFrank),
    Senegal(Currency.CFAFrank),
    Spain(Currency.Euro),
}

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    println(try {
        val country1 = Country.valueOf(input.next())
        val country2 = Country.valueOf(input.next())
        country1.currency == country2.currency
    } catch (e: IllegalArgumentException) {
        false
    })
}