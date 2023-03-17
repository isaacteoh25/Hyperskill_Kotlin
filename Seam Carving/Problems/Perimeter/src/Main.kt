//import kotlin.math.hypot
//
//fun dist(point1: Pair<Double, Double>, point2: Pair<Double, Double>): Double {
//    return hypot(point1.first - point2.first, point1.second - point2.second)
//}
//
//fun perimeter(vararg coords: Double): Double {
//    val points = coords.foldIndexed(mutableListOf<Pair<Double, Double>>()) { index, acc, d ->
//        if (index % 2 == 0) {
//            acc += Pair(d, coords[index + 1])
//        }
//        acc
//    }
//    return points.foldIndexed(0.0) { index, acc, pair ->
//        var nextPointIndex = index + 1
//        if (nextPointIndex > points.lastIndex) {
//            nextPointIndex = 0
//        }
//        acc + dist(pair, points[nextPointIndex])
//    }
//}
//
//fun perimeter(x1: Double, y1: Double, x2: Double, y2: Double, x3: Double, y3: Double, x4: Double = x3, y4: Double = y3): Double {
//    val len12 = len(x1, y1, x2, y2)
//    val len23 = len(x2, y2, x3, y3)
//    val len34 = len(x3, y3, x4, y4)
//    val len41 = len(x4, y4, x1, y1)
//    return len12 + len23 + len34 + len41
//}
//
//fun len(x1: Double, y1: Double, x2: Double, y2: Double): Double {
//    return Math.hypot(x2 - x1, y2 - y1)
//}
//
//
//fun perimeter(vararg coords: Double): Double {
//    val xy = coords.toMutableList()
//    if (xy.size == 6) xy.addAll(listOf(xy[0], xy[1]))
//    return hypot(xy[0] - xy[2], xy[1] - xy[3]) + hypot(xy[4] - xy[2], xy[5] - xy[3]) +
//            hypot(xy[4] - xy[6], xy[7] - xy[5]) + hypot(xy[6] - xy[0], xy[7] - xy[1])
//}


