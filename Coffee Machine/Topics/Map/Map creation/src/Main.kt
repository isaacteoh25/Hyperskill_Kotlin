fun stringToMap(first: String, second: String, third: String): Map<String, Int> {
    // put your code here
    return  mapOf(
        first to first.length,
        second to second.length,
        third to third.length
    )
//    print(a.joinToString { it -> "{" +it + " to ${it.length}}" })
}

//fun main(){
//.map { "{${it.key} to ${it.value}}" }
//    val a = readLine()!!.split(" ")
//    print(a.joinToString { it -> "{" +it + " to ${it.length}}" })
//    for (i in a){
////    print("${i} to ${i.length}")
//    }
//    val employees = mapOf(
//        "Mike" to 1500,
//        "Jim" to 500,
//        "Sara" to 1000
//    )
//    if (!employees.isEmpty()) {
//        println("Number of employees: ${employees.size}")
//        println("Mike wants to earn ${employees["Mike"]}")
//    }
//}