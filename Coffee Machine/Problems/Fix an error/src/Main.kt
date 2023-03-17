//val player: Player

//val player: Player = Player(100, "a")

class Player(val id: Int, val name: String) {

//    companion object {
//        val role = "playable character"
//    }
//
//    fun getInfo(): String {
//        return "${id}, ${name}, $role"
//    }
val role = "playable character"
    fun getInfo() = "$id, $name, $role"
    companion object {
        const val role = "playable character"
        fun getInfo(p: Player) = "${p.id}, ${p.name}, $role"
    }
}
fun getPlayerInfo(player: Player): String {
//    val player = Player(100, "a")
    return player.getInfo()
}


//fun main(args: Array<String>){
//    println(getPlayerInfo(player))
//}
