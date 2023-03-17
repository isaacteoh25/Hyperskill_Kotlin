package mealplanner.util

import mealplanner.model.Ingredient
import mealplanner.model.Meal
import mealplanner.model.MealCategory
import mealplanner.model.Plan
import kotlin.system.exitProcess

class Worker(databaseName: String) {
    private var repository = MealPlannerRepository(databaseName)

    fun perform() {
        while (true) {
            println("What would you like to do (add, show, plan, exit)?")
            val action = readLine()!!

            when (ProgramAction.lookupByName(action.toUpperCase())) {
                ProgramAction.ADD -> add()
                ProgramAction.SHOW -> show()
                ProgramAction.PLAN -> plan()
                ProgramAction.EXIT -> exit()
                else -> wrongAction()
            }
        }
    }

    private fun add() {
        println("Which meal do you want to add (breakfast, lunch, dinner)?")
        var category = MealCategory.UNKNOWN
        while (category == MealCategory.UNKNOWN) {
            category = MealCategory.lookupByName(readLine()!!.toUpperCase())
            if (category == MealCategory.UNKNOWN) {
                println("Wrong meal category! Choose from: breakfast, lunch, dinner.")
            }
        }
        val regex = """[a-zA-Z ]+""".toRegex()
        println("Meal's name:")
        var name = ""
        while (true) {
            name = readLine()!!.trim()
            if (regex.matches(name)) {
                break
            } else {
                println("Wrong format. Use letters only!")
            }
        }
        println("Ingredients:")
        var ingredientsName = mutableListOf<String>()
        var wrongIngredient = true
        while (wrongIngredient) {
            ingredientsName = readLine()!!.split(",").map { it.trim() }.toMutableList()
            for (ingredientName in ingredientsName) {
                if (!regex.matches(ingredientName)) {
                    wrongIngredient = true
                    break
                } else {
                    wrongIngredient = false
                }
            }
            if (wrongIngredient) {
                println("Wrong format. Use letters only!")
            }
        }
        val ingredients = mutableListOf<Ingredient>()

        ingredientsName.forEach {
            val ingredient = Ingredient(name=it)
            ingredients.add(ingredient)
        }

        repository.addMeal(Meal(name=name, category=category, ingredients=ingredients.toList()))
        println("Meal added!")
    }

    private fun show() {
        println("Which category do you want to print? (breakfast, lunch, dinner)?")
        var ready = true;
        do {
            val category = MealCategory.lookupByName(readLine()!!)
            if (category != MealCategory.UNKNOWN) {
                val meals = repository.getMealsFromCategory(category)
                if (meals.isNotEmpty()) {
                    println("Category: ${category.dbName}")
                    for (meal in meals) {
                        println("Name: ${meal.name}")
                        println() // only because required by the test engine
                        for (ingredient in meal.ingredients) {
                            println(ingredient.name)
                        }
                        println() // only because required by the test engine
                    }
                } else {
                    println("No meals found.")
                }
// just for fun :-), and because we can ;-)
//                val mealsSummary = repository.getMealsSummaryFromCategory(category)
//                if (mealsSummary.isNotEmpty()) {
//                    println("Category: ${category.dbName}")
//                    for (mealSummary in mealsSummary) {
//                        println(mealSummary)
//                    }
//                } else {
//                    println("No meals found.")
//                }
            } else {
                println("Wrong meal category! Choose from: breakfast, lunch, dinner.")
                ready = false
            }
        } while (!ready)
    }

    private fun plan() {
        val dow = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
        val categories = listOf(MealCategory.BREAKFAST, MealCategory.LUNCH, MealCategory.DINNER)

        for (day in dow) {
            println("$day")
            for (category in categories) {
                val meals = repository.getMealsFromCategory(category)
                for (meal in meals) {
                    println("${meal.name}")
                }
                println("Choose ${category.dbName} for $day from the list above:")
                var meal: Meal? = null
                do {
                    val mealName = readLine()!!

                    meal = meals.firstOrNull() { it.name == mealName}

                    if (meal == null) {
                        println("This meal doesn’t exist. Choose a meal from the list above.")
                    }
                } while (meal == null)
                val plan = Plan(day=day,category=category, meal=meal)
                repository.addPlan(plan)
            }
            println("Yeah! We planned the meals for Monday.")
        }

        val plans = repository.getAllPlans()

        for (day in dow) {
            println()
            println("$day")
            val dayPlans = plans.filter { it.day == day }
            for (plan in dayPlans) {
                println("${plan.category}: ${plan.meal.name}")
            }
        }
    }

    private fun exit() {
        repository.close()

        println("Bye!")
        exitProcess(0)
    }

    private fun wrongAction() {
        "Wrong action! Choose from: add, show, exit."
    }
}