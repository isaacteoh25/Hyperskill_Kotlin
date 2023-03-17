//class City(val name: String) {
//    var population: Int = 0
////set(value) {
////    field = if (value < 0) 0 else (if (value > 50_000_00) 50_000_00 else value)
////}
//    set(value) {
//        field = when {
//            value < 0 -> 0
//            value > 50_000_000 -> 50_000_000
//            else -> value
//        }
//    }
//}

//fun main() {
//    var five = highFive()
//}
//
//class Six(var six: Int) {
//    var seven: String = "seven"
//    var nine: Int = seven.length
//}
//
//fun highFive(): Int {
//    var eight: Int = 8
//    return 5
//}

fun main() {
    val smartOne = Smartphone("Ericsong")
    smartOne.price = -24
    val smartTwo = Smartphone("iNokhe")
    print(smartTwo.price - smartOne.price)
}

class Smartphone(val name: String) {
    var price: Int = -5
        get() = name.length - field
}