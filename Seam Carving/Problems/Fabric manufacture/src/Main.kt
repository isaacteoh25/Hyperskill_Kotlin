class Fabric(var color: String = "grey") {
    var pattern: String = "none"
    var patternColor: String = "none"

    init {
//        val color: String = "grey"
        println("$color fabric is created")
    }

    constructor(color: String, pattern: String, patternColor: String) : this(color) {
        this.pattern = pattern
        this.patternColor = patternColor
        this.color = color
    println("the fabric is dyed $color")
    println("$patternColor $pattern pattern is printed on the fabric")

    }
}

//fun main() {
//    Fabric("white", "dots", "black")
//}