//import com.sun.security.ntlm.Server

//import com.sun.corba.se.spi.activation.Server

class CustomerInfo(
        /** Unique user id */
        val uid: String,
        /** Operation system: Windows, Linux, macOS, iOS */
        val operationSystem: String,
        /** In GB */
        val ram: Int,
        /** In GHz */
        val coreSpeed: Double,
        val timeStamp: Long
    ) {

//    override fun toString(): String =
//        "Id: $uid; Operation System: $operationSystem; RAM: $ram; Core Speed: $coreSpeed; Timestamp: $timeStamp"
//    //put your code here
    override fun toString(): String {
        return listOf(
            "Id: $uid",
            "Operation System: $operationSystem",
            "RAM: $ram",
            "Core Speed: $coreSpeed",
            "Timestamp: $timeStamp"
        ).joinToString("; ")
    }
}
//
fun sendCustomerInfoToServer(customer: String) {
    Server.send(customer.toString())
}
//val user = CustomerInfo("1", "marys01", 1, 1.1,1)
//print(user)