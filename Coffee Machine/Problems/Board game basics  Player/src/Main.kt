class Player(val id: Int, val name: String, val hp: Int) {
    companion object {
        var hp = 100
        var id = 0
//        fun create(name: String): Player{
//            id += 1
//            return Player(id, name, hp)
//        }
//        var id = 0

        fun create(name: String) = Player(id++, name, 100)
    }
}