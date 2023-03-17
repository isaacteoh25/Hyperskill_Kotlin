//fun main(args: Array<String>) {
//    try {
//        // some code
//        val a = listOf<String>("Mustard", "Cheese", "Eggs", "Cola", "Eggs" )
//
//        a.forEachIndexed { i, element ->
//            println("Argument " + (i + 1).toString()+ ": argument. It has "+ element.length +" characters")
//        }
//        println("Hello, $a[0]!")
//    }
//    catch (e: Exception) {
//        // handler
//        println("Invalid number of program arguments")
//    }
//}
fun main(args: Array<String>) {
    if (args.size == 3) {
        args.forEachIndexed { i, s -> println("Argument ${i + 1}: $s. It has ${s.length} characters") }
    } else {
        println("Invalid number of program arguments")
    }
}