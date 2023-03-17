fun concSpecial(s1: String, s2: String, s3: String, sep: String = "NO SEPARATOR"): String {
    if (sep.equals("NO SEPARATOR")) {
        return s1 + " " + s2 + " " + s3
    } else {
        return s1 + sep + s2 + sep + s3
    }
}

fun main() {
    println(concSpecial(readLine()!!, readLine()!!, readLine()!!, readLine()!!))
}