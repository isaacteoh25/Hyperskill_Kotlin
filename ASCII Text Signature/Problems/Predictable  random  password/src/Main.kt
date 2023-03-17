import kotlin.random.Random
//fun generatePredicatablePassword(seed: Int): String {
//    var randomPassword = ""
//    val randomGenerator42 = Random(seed)
//    for (i in 0..6) {
//        val a = randomGenerator42.nextInt(20, 30)
//        println(a)
//    }
//    // write your code here, Random is already imported for you
////    val randomGenerator42 = Random(seed) // the generator takes the seed
////    for (i in 0..9) {
////        val a = randomGenerator42.nextInt(33, 126).toChar()
////        randomPassword+=a
////
////    }
//	return randomPassword
//}
fun createDiceGameRandomizer(n: Int): Int {
    var seed = 0

    do {
        val generator = Random(seed)
        val friends = List(n) { generator.nextInt(1, 7) }
        val me = List(n) { generator.nextInt(1, 7) }
        seed++
    } while (friends.sumBy { it } > me.sumBy { it })

    return seed
}

fun main() {
//    print(generatePredicatablePassword(42))
    print(createDiceGameRandomizer(5))
}