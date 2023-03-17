class Task(val name: String)

// create the Manager singleton here
object Manager{
    var solvedTask: Int = 0
    fun solveTask(task: Task){
//        val task = Task("a")
        println("Task ${task.name} solved!")
        solvedTask+= 1
    }

}
//fun main(args: Array<String>){
//    println(Manager.solvedTask)
//}