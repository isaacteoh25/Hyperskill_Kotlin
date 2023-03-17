//data class Client(val name: String, val age: Int, val balance: Int) {
//    override fun equals(other: Any?): Boolean {
//        other as Client
//        return name == other.name && age == other.age
//    }
//}
//
//fun main() {
//    val input1 = readLine()!!.split(" ")
//    val input2 = readLine()!!.split(" ")
//    val c1 = Client(input1[0], input1[1].toInt(), input1[2].toInt())
//    val c2 = Client(input2[0], input2[1].toInt(), input2[2].toInt())
//    print(c1 == c2)
//}
//
//
//data class Client(val name: String, val age: Int, val balance: Int) {
//    override fun equals(other: Any?): Boolean {
//        if (this === other) return true
//        if (javaClass != other?.javaClass) return false
//
//        other as Client
//
//        if (name != other.name) return false
//        if (age != other.age) return false
//
//        return true
//    }
//}
//
//fun main(args: Array<String>) {
//    val input = Scanner(System.`in`)
//    val client1 = Client(input.next(), input.nextInt(), input.nextInt())
//    val client2 = Client(input.next(), input.nextInt(), input.nextInt())
//    println(client1 == client2)
//}

//fun main() {
//    val alphabet = mutableMapOf<Int, String>()
//    alphabet[1] = "a"
//    alphabet[3] = "c"
//    alphabet[4] = "d"
//    alphabet[2] = "b"
//    for (entry in alphabet) {
//        print(entry.value)
//    }
//}
