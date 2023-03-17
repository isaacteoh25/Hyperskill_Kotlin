package mealplanner

import mealplanner.util.Worker

fun main(args: Array<String>) {
    require(args.size == 1) { "Database name must be specified!" }

    val databaseName = args[0]

    val worker = Worker(databaseName)

    worker.perform()
}