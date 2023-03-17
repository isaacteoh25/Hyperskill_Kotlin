// write the classes here
//class OperatingSystem {
//    var name: String = "a"
////    constructor(data: String) {
////        // code
////    }
////    constructor(data: String, numberOfData: Int) {
////        // code
////    }
//}
data class OperatingSystem(var name: String = "Linux")
class DualBoot() {
    var primaryOs = OperatingSystem("Linux")
    var secondaryOs = OperatingSystem("Windows")
//    constructor(data: String): super(data) {
//        // code
//    }
//    constructor(data: String, numberOfData: Int): super(data, numberOfData) {
//        // code
//    }
val os1 = primaryOs.name
val os2 = secondaryOs.name

}