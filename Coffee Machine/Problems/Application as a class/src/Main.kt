class Application(val name: String) {
//    val array = intArrayOf(1, 2, 3, 4, 5)
    // write the run method here

    fun run(a: String, b: String, c:String){
        println(name)
        println(a)
        println(b)
        println(c)
    }
    fun run(vararg lines: String) {
        println(name)
        lines.forEach { println(it) }
    }
    fun run(a: String, b: String, c: String) = print("${this.name}\n$a\n$b\n$c")
    fun run(vararg args: String) {
        println(name)
        args.forEach {
            println(it)
        }
    }
    fun run(a: String, b: String, c: String) {
        println(name)
        val list = listOf(a, b, c)
        for (i in list) println(i)
    }
}
//fun main(args: Array<String>){
//
//    val app=Application("a")
////    println(app.run("a", "b", "c"))
////    println(robot1.roboColor)
////    robot1.makeBed()
//}