package flashcards


import java.io.File
import kotlin.random.Random

private data class Card(val card: String, val definition: String)

class Cards {
    private var list: MutableList<Card> = mutableListOf()

    fun add() {
        println("The card:")
        readLine()!!.let { card ->
            getDef(card, "card") { it.card }?.let {
                println("The definition of the card:")
                readLine()!!.let { answer ->
                    getDef(answer, "definition") { it.definition }?.let {
                        println("The pair (\"$card\":\"$answer\") has been added.")
                        list.add(Card(card, answer))
                    }
                }
            }
        }
    }

    private fun getDef(read: String, name: String, lam: (Card) -> String): String? {
        val alreadyExists = list.find { lam(it) == read } != null
        if (alreadyExists) {
            println("The $name \"$read\" already exists.")
            return null
        }
        return read
    }

    fun remove() {
        println("The card:")
        val card = readLine()!!
        val message = list.removeIf { it.card == card }
        println(if (!message) "Can't remove \"$card\": there is no such card." else "The card has been removed.")
    }

    fun import() {
        println("File name:")
        val myFile = File(readLine()!!)
        if (myFile.isFile) {
            val import = myFile.readText().split("\n").map { it.split(" <--> ") }.filter { it.size == 2 }.map { Card(it[0], it[1]) }
            list.addAll(import)
            list = list.groupBy { it.card }.map { it.value.last() }.groupBy { it.definition }.map { it.value.last() }.toMutableList()
            println("${import.size} cards have been loaded.")
        } else {
            println("File not found.")
        }
    }

    fun export() {
        println("File name:")
        File(readLine()!!).writeText(list.joinToString(separator = "\n") { it.card + " <--> " + it.definition })
        println("${list.size} cards have been saved.")
    }

    fun ask() {
        println("How many times to ask?")
        repeat(readLine()!!.toInt()) {
            val rand = Random.nextInt(list.size)
            ask(list[rand])
        }
    }

    private fun ask(card: Card) {
        println("Print the definition of \"${card.card}\":")
        val message = readLine().let { if (it == card.definition) "Correct!" else checkInOtherCards(card, it) }
        println(message)
    }

    private fun checkInOtherCards(card: Card, definition: String?): String {
        val other = list.find { it.definition == definition }
        return if (other == null) "Wrong. The right answer is \"${card.definition}\"."
        else "Wrong. The right answer is \"${card.definition}\", but your definition is correct for \"${other.card}\"."
    }

}

fun main() {
    Cards().let {
        while (true) {
            println("\nInput the action (add, remove, import, export, ask, exit):")
            when (readLine()) {
                "add" -> it.add()
                "remove" -> it.remove()
                "import" -> it.import()
                "export" -> it.export()
                "ask" -> it.ask()
                "exit" -> break
            }
        }
    }
    print("Bye bye!")
}

//    val result = TERMS.zip(DEFINITIONS)
//    for (term in TERMS){
//result[term]=
//    }
//    print(result)
//    var b = readLine()!!
//    var c = readLine()!!
//for (r in result) {
//    println("Print the definition of \"${r.value}\":")
//    val c = readLine()!!
//    if (r.key == c) {
//        println("Correct!")
//    } else {
//        if (DEFINITIONS.contains(r.key)) {
//            println("Wrong. The right answer is \"${r.key}\", but your definition is correct for \"${result[c]}\".")
//        }
//        else{
//            println("Wrong. The right answer is \"${r.key}\".")
//        }
//    }
//}


//package flashcards
//
//import java.io.File
//import kotlin.random.Random
//import kotlin.random.nextInt
//
//data class Card(val term: String, val definition: String) {
//    var errors = 0
//
//    constructor(term: String, definition: String, errors: Int = 0) : this(term, definition) {
//        this.errors = errors
//    }
//
//    override fun toString(): String = "(\"$term\":\"$definition\")"
//}
//
//object Deck : MutableSet<Card> by mutableSetOf() {
//    fun containsTerm(term: String) = this.map { it.term }.contains(term)
//    fun containsDefinition(definition: String) = this.map { it.definition }.contains(definition)
//}
//
//val logBook: StringBuilder = StringBuilder("")
//
//fun main(args: Array<String>) {
//    val importFile = if (args.contains("-import")) {
//        File(args[args.indexOf("-import") + 1])
//    } else null
//    val exportFile = if (args.contains("-export")) {
//        File(args[args.indexOf("-export") + 1])
//    } else null
//
//    while (menu(importFile, exportFile) != false) {
//    }
//}
//
//fun Deck.export(file: File) {
//    file.writeText("")
//    for (card in Deck) {
//        file.appendText("\"${card.term}\":\"${card.definition}\":\"${card.errors}\"\n")
//    }
//    println("${Deck.size} cards have been saved.")
//}
//
//private fun Deck.import(file: File) {
//    if (!file.exists()) {
//        println("File not found.")
//        return
//    }
//    val importedCards = file.readLines().map {
//        val (term, def, errors) = it.split(":").map { it.removeSurrounding("\"") }
//        Card(term, def, errors.toInt())
//    }
//    importedCards.forEach { newCard ->
//        if (Deck.containsTerm(newCard.term)) {
//            Deck.removeAll { it.term == newCard.term }
//        }
//        Deck.add(newCard)
//    }
//    println("${importedCards.size} cards have been loaded.")
//}
//
//fun Deck.remove() {
//    println("Which card?")
//    val term = readLine()!!
//    println(
//        if (Deck.remove(Deck.find { it.term == term })) "The card has been removed."
//        else "Can't remove \"$term\": there is no such card."
//    )
//}
//
//fun Deck.add() {
//    println("The card:")
//    val term = readLine()!!
//    if (Deck.containsTerm(term)) {
//        println("The card \"$term\" already exists.")
//        return
//    }
//    println("The definition of the card:")
//    val definition = readLine()!!
//    if (Deck.containsDefinition(definition)) {
//        println("The definition \"$definition\" already exists.")
//        return
//    }
//    val card = Card(term, definition)
//    Deck.add(card)
//    println("The pair $card has been added.")
//}
//
//fun Deck.ask() {
//    println("How many times to ask?")
//    val n = readLine()!!.toInt()
//    repeat(n) { _ ->
//        val randomCard = Deck.toList()[Random.nextInt(Deck.indices)]
//        println("Print the definition of \"${randomCard.term}\":")
//        val inputDefinition = readLine()!!
//        when {
//            (inputDefinition == randomCard.definition) -> println("Correct!")
//            Deck.map { it.definition }.contains(inputDefinition) -> {
//                println("Wrong. The right answer is \"${randomCard.definition}\", but your definition is correct for \"${Deck.find { it.definition == inputDefinition }!!.term}\".")
//                randomCard.errors++
//            }
//            else -> {
//                println("Wrong. The right answer is \"${randomCard.definition}\".")
//                randomCard.errors++
//            }
//        }
//    }
//
//}
//
//fun Deck.hardestCard() {
//    val hardestCards = this.filter { it.errors == this.map { it.errors }.maxOrNull() && it.errors != 0 }
//    val errors = hardestCards.firstOrNull()?.errors ?: 0
//    println(
//        when {
//            hardestCards.size == 1 -> {
//                "The hardest card is \"${hardestCards.first().term}\". You have $errors errors answering it."
//            }
//            hardestCards.size > 1 -> {
//                "The hardest cards are ${
//                    hardestCards.map { "\"${it.term}\"" }.joinToString(", ")
//                }. You have $errors errors answering them."
//            }
//            else -> "There are no cards with errors."
//        }
//    )
//}
//
//fun Deck.resetStats() {
//    this.forEach { it.errors = 0 }
//    println("Card statistics have been reset.")
//}
//
//fun println(string: String) {
//    kotlin.io.println(string)
//    logBook.appendLine(string)
//}
//
//fun readLine(): String? {
//    val input = kotlin.io.readLine()
//    logBook.appendLine(input)
//    return input
//}
//
//fun saveLog() {
//    println("File name:")
//    File(readLine()!!).writeText(logBook.toString())
//    println("The log has been saved.")
//}
//
//fun menu(importFile: File?, exportFile: File?): Any {
//    println("Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):")
//    if (importFile != null) Deck.import(importFile)
//    return when (readLine()!!) {
//        "add" -> Deck.add()
//        "remove" -> Deck.remove()
//        "import" -> Deck.import(run { println("File name:"); File(readLine()!!) })
//        "export" -> {
//            Deck.export(run { println("File name:"); File(readLine()!!) })
//        }
//        "ask" -> Deck.ask()
//        "exit" -> {
//            if (exportFile != null) Deck.export(exportFile)
//            println("Bye bye!")
//            false
//        }
//        "log" -> saveLog()
//        "hardest card" -> Deck.hardestCard()
//        "reset stats" -> Deck.resetStats()
//        else -> true
//    }
//}