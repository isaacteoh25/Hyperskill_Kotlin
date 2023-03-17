package cryptography

fun main() {
    while (true) {
        println("Task (hide, show, exit):")
        val task = readLine()
        if (task == "hide") {
            print("Hiding message in image.")
        } else if (task == "show") {
            print("Obtaining message from image.")
        } else if (task == "exit") {
            print("Bye!")
            break
        } else {
            print("Wrong task: ${task}")
        }
    }
}

