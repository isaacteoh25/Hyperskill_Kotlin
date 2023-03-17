fun main() {
    val input = readLine()!!
    var output = ""
    var count = 1
    for (i in input.indices) {
        if (i + 1 <= input.length - 1) {
            if (input[i] == input[i + 1]) {
                count++
            } else {
                output += "${input[i]}$count"
                count = 1
            }
        }
    }
    output += "${input.last()}$count"
    println(output)
}