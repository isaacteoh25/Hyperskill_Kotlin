package machine
import java.util.Scanner

class ProcessingStates {
    val MSG_MAKING_COFFEE = "I have enough resources, making you a coffee!"

    enum class State { WAITING_ACTION, WAITING_PRODUCT_CHOICE, WAITING_WATER, WAITING_MILK, WAITING_BEANS, WAITING_CUPS }

    enum class Product(val id:String, val water:Int, val milk:Int, val beans:Int, val cost:Int) {
        ESPRESSO("1",250, 0, 16, 4),
        LATTE("2",350, 75, 20, 7),
        CAPPUCCINO("3",200, 100, 12, 6)
    }

    var availableWater = 400
    var availableMilk = 540
    var availableBeans = 120
    var availableCups = 9
    var availableMoney = 550
    var currentState = State.WAITING_ACTION

    fun entryPoint(input:String) {
        when(currentState) {
            State.WAITING_ACTION -> actionSelected(input)
            State.WAITING_PRODUCT_CHOICE -> {
                processBuy(input)
                currentState = State.WAITING_ACTION
            }
            State.WAITING_WATER -> {
                fillWater(input.toInt())
                currentState = State.WAITING_MILK
            }
            State.WAITING_MILK -> {
                fillMilk(input.toInt())
                currentState = State.WAITING_BEANS
            }
            State.WAITING_BEANS -> {
                fillBeans(input.toInt())
                currentState = State.WAITING_CUPS
            }
            State.WAITING_CUPS -> {
                fillCups(input.toInt())
                currentState = State.WAITING_ACTION
            }
        }
    }

    private fun printResources() {
        println("The coffee machine has:")
        println("$availableWater of water")
        println("$availableMilk of milk")
        println("$availableBeans of coffee beans")
        println("$availableCups of disposable cups")
        println("\$$availableMoney of money")
    }

    private fun enoughResources(requestedVariety: Product): Boolean {
        val message = when {
            availableCups < 1 -> "Sorry, not enough cups!"
            availableWater < requestedVariety.water -> "Sorry, not enough water!"
            availableMilk < requestedVariety.milk -> "Sorry, not enough milk!"
            availableBeans < requestedVariety.beans -> "Sorry, not enough beans!"
            else -> ""
        }
        if (message == "") return true
        else {
            println(message)
            return false
        }
    }

    private fun actionSelected(input:String) {
        println("Write action (buy, fill, take, remaining, exit): $input")
        when (input) {
            "buy" -> currentState = State.WAITING_PRODUCT_CHOICE
            "fill" -> currentState = State.WAITING_WATER
            "take" -> {
                processTake()
                currentState = State.WAITING_ACTION
            }
            "remaining" -> {
                printResources()
                currentState = State.WAITING_ACTION
            }
        }
    }

    private fun processBuy(input:String) {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: $input")

        if (input == "back") return

        val variety:Product = when(input) {
            Product.ESPRESSO.id ->  Product.ESPRESSO
            Product.LATTE.id ->  Product.LATTE
            else ->  Product.CAPPUCCINO
        }

        if (enoughResources(variety)) println(MSG_MAKING_COFFEE)
        else return

        availableWater -= variety.water
        availableMilk -= variety.milk
        availableBeans -= variety.beans
        availableMoney += variety.cost
        availableCups--
    }

    private fun fillWater(input:Int) {
        println("Write how many ml of water do you want to add: $input")
        availableWater += input
    }

    private fun fillMilk(input:Int) {
        println("Write how many ml of milk do you want to add: $input")
        availableMilk += input
    }

    private fun fillBeans(input:Int) {
        println("Write how many grams of coffee beans do you want to add: $input")
        availableBeans += input
    }

    private fun fillCups(input:Int) {
        println("Write how many disposable cups of coffee do you want to add: $input")
        availableCups += input
    }

    private fun processTake() {
        println("I gave you \$$availableMoney")
        availableMoney = 0
    }
}


fun main() {
    val scanner = Scanner(System.`in`)
    var exit = false

    val maker = ProcessingStates()
    do {
        println()
        val type = scanner.nextLine().trim()
        if(type == "exit") exit = true
        else {
            maker.entryPoint(type)
        }
    } while (!exit);
//    println("99" + "" + "99")  // 1
////    println("9"*4)             // 2
//    println("" + 9999)         // 3
//    println("9".repeat(4))     // 4
}