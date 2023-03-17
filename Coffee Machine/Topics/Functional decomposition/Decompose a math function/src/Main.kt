import kotlin.math.pow

//fun f(x: Double): Double {
//    // call your implemented functions here
//    if (x < 0){
//        return f1(x)
//    }
//    else if(x > 0 && x < 1){
//        return f2(x)
//    }
//    else{
//        return f3(x)
//    }
//}
//
//// implement your functions here
//fun f1(a: Double) = a.pow(2) + 1
//
//fun f2(a: Double) = 1/a.pow(2)
//
//fun f3(a: Double) = a.pow(2) -1

fun f(x: Double) = if (x <= 0.0) f1(x) else if (x >= 1) f3(x) else f2(x)
fun f1(x: Double) = x * x + 1
fun f2(x: Double) = 1 / (x * x)
fun f3(x: Double) = x * x - 1