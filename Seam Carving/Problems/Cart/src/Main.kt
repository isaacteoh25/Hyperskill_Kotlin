import java.math.BigDecimal

//open class Vehicle(val name: String, val wheelsNum: Int = 0)
//
//open class Car(name: String, wheelsNum: Int, val spareWheelsNum: Int = 0)
//    : Vehicle(name, wheelsNum)
//
//open class Truck(name: String, wheelsNum: Int, spareWheelsNum: Int, val type: String)
//    : Car(name, wheelsNum, spareWheelsNum)
//
//fun wheelsNum(vehicle: Vehicle): Int {
//    return if (vehicle.wheelsNum < 0) 0 else vehicle.wheelsNum
//}
//
//fun totalWheelsNum(car: Car): Int {
//    return car.wheelsNum + car.spareWheelsNum
//}
//
//fun spareWheelsNum(car: Car): Int {
//    return totalWheelsNum(car) - wheelsNum(car)
//}
//
//fun main() {
//    val car = Car("Edison", 4, 2)
//    val truck = Truck("Riebhell", 8, 2, "Heavy")
//    println(spareWheelsNum(car) + spareWheelsNum(truck))
//}

//open class Wood(val age: Int) {
//    fun getWoodInfo(): String {
//        return "age $age"
//    }
//}
//
//class Pine(val isSpiny: Boolean, age: Int) : Wood(age) {
//    fun getPineInfo(): String {
//        return getWoodInfo() + ", spiny $isSpiny"
//    }
//}
//
//fun main() {
//    val pine = Pine(true, 3)
//    println(pine.getPineInfo() + ", " + pine.getWoodInfo())
//}

//fun main() {
//    val productType = readLine()!!
//    val price = readLine()!!
//    val product = Product(price, productType)
//    println(totalPrice(product))
//}
//
//fun totalPrice(product: Product): Int {
//    if (product.productType == "headphones"){
//
//      return (product.price.toBigDecimal() + (product.price.toBigDecimal() * 11.toBigDecimal() / 100.toBigDecimal())).toInt()
//    }
//    else if (product.productType == "smartphone"){
//
//        return (product.price.toBigDecimal() + product.price.toBigDecimal() * 15.toBigDecimal() / 100.toBigDecimal()).toInt()
//    }
//    else if (product.productType == "tv"){
//
//        return (product.price.toBigDecimal() + product.price.toBigDecimal() * 17.toBigDecimal() / 100.toBigDecimal()).toInt()
//    }
//    else {
//        return (product.price.toBigDecimal() + product.price.toBigDecimal() * 19.toBigDecimal() / 100.toBigDecimal()).toInt()
//    }
////    return (product.price.toBigDecimal() + product.price.toBigDecimal() * product_tax).toInt()
//}
//
//open class Product(val price: String, val productType: String)
//

fun main() {
    val productType = readLine()!!
    val price = readLine()!!.toInt()
    val product = when (productType) {
        "headphones" -> HeadPhones(price)
        "smartphone" -> SmartPhone(price)
        "tv" -> Tv(price)
        "laptop" -> Laptop(price)
        else -> Product(price)
    }
    print(product.totalPrice())
}
open class Product(val cost: Int, var tax: Float = 1.00F) {
    fun totalPrice(): Int = (cost * tax).toInt()
}
class HeadPhones(cost: Int, tax: Float = 1.11F) : Product(cost, tax)
class SmartPhone(cost: Int, tax: Float = 1.15F) : Product(cost, tax)
class Tv(cost: Int, tax: Float = 1.17F) : Product(cost, tax)
class Laptop(cost: Int, tax: Float = 1.19F) : Product(cost, tax)