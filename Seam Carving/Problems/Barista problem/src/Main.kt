data class EspressoMachine(private val coffeeCapsulesCount: Int, private val totalCost: Float) {
    var costPerServing: Float = totalCost / coffeeCapsulesCount

    constructor(coffeeBeansWeight: Float, totalCost: Float) : this(0, 0F) {
        costPerServing = totalCost / (coffeeBeansWeight / 10.6F)
    }
}

data class EspressoMachine(val costPerServing: Float) {
    constructor(coffeeCapsulesCount: Int, totalCost: Float) :
            this(totalCost / coffeeCapsulesCount)

    constructor(coffeeBeansWeight: Float, totalCost: Float) :
            this(totalCost / coffeeBeansWeight * 10.6f)
}