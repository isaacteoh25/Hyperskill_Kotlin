import kotlin.math.roundToInt

//fun main() {
//    val rooms = readLine()!!.toInt()
//    val price = readLine()!!.toInt()
//    val house = when (rooms) {
//        1 -> Cabin(1, price)
//        in 2..3 -> Bungalow(rooms, price)
//        4 -> Cottage(rooms, price)
//        in 5..7 -> Mansion(rooms, price)
//        in 8..10 -> Palace(rooms, price)
//        else -> House(rooms, price)
//    }
//    println(totalPrice(house))
//}
//
//open class House(val rooms: Int, val price: Int, val coef: Double = 1.00) {
//    val basePrice = price.coerceIn(0..1_000_000)
//}
//class Cabin(rooms: Int, price: Int, coef: Double = 1.00) : House(rooms, price, coef)
//class Bungalow(rooms: Int, price: Int, coef: Double = 1.20) : House(rooms, price, coef)
//class Cottage(rooms: Int, price: Int, coef: Double = 1.25) : House(rooms, price, coef)
//class Mansion(rooms: Int, price: Int, coef: Double = 1.40) : House(rooms, price, coef)
//class Palace(rooms: Int, price: Int, coef: Double = 1.60) : House(rooms, price, coef)
//fun totalPrice(house: House): Int = (house.basePrice * house.coef).toInt()
//
//
//fun main() {
//    val rooms = readLine()!!.toInt()
//    val price = readLine()!!.toInt()
//    val house = when (rooms) {
//        in Int.MIN_VALUE..1 -> Cabin(price)
//        in 2..3 -> Bungalow(price)
//        4 -> Cottage(price)
//        in 5..7 -> Mansion(price)
//        else -> Palace(price)
//    }
//    println(house.totalPrice(house))
//}
//
//open class House(private var price: Int, private val coefficient: Double = 0.0) {
//    init {
//        if (price < 0) price = 0 else if (price > 1_000_000) price = 1_000_000
//    }
//
//    fun totalPrice(house: House): Int {
//        return (house.price * house.coefficient).toInt()
//    }
//}
//
//class Cabin(price: Int) : House(price, 1.0)
//class Bungalow(price: Int) : House(price, 1.2)
//class Cottage(price: Int) : House(price, 1.25)
//class Mansion(price: Int) : House(price, 1.4)
//class Palace(price: Int) : House(price, 1.6)


//fun main() {
//    val factory = FactoryWithRoof(3, 2, 23000)
//    print(factory.employeesPerFloor())
//}
//
//open class Facility(val floors: Byte) {
//    fun addFloors(num: Byte): Int = floors + num
//}
//
//open class Factory(floors: Byte, val employees: Short, val roof: Byte) : Facility(floors) {
//    fun buildRoof(): Int = super.addFloors(roof)
//    open fun employeesPerFloor(): Int = employees / floors
//}
//
//open class FactoryWithRoof(floors: Byte, roof: Byte, employees: Short) : Factory(floors, employees, roof) {
//    override fun employeesPerFloor(): Int = employees / (floors + super.buildRoof())
//}


fun main() {
    val leatherCase = LeatherCase(190, "brown")
    val softCase = SoftCase(120, "yellow")
    val woodCase = WoodCase(230, "orange")
    println(getCaseTax(leatherCase) + getCaseTax(softCase) + getCaseTax(woodCase))
}

open class Case(val cost: Int) {
    fun getFullInfo(): String = "$$cost cost" + getTax()

    open fun getTax(): Int = (cost * 0.25).roundToInt()
}

open class SoftCase(cost: Int, val color: String) : Case(cost) {
    override fun getTax(): Int = super.getTax() + 100
}

open class WoodCase(cost: Int, val color: String) : Case(cost)

open class LeatherCase(cost: Int, color: String) : SoftCase(cost, color) {
    override fun getTax(): Int = (cost * 0.35).roundToInt()
}

fun getCaseTax(case: Case): Int = case.getTax()