package mealplanner.model

import java.lang.StringBuilder

data class Meal(val id: Long,
                val name: String,
                val category: MealCategory,
                val ingredients: List<Ingredient>) {

    constructor(name: String, category: MealCategory, ingredients: List<Ingredient>) :
            this(NONEXISTENT_ID, name, category, ingredients)

    override fun toString(): String {
        var result = StringBuilder()

        val newLine = System.lineSeparator()

        result.append("Category: ${category}${newLine}")
        result.append("Name: ${name}${newLine}")

        result.append("Ingredients:${newLine}")
        for (ingredient in ingredients) {
            result.append("${ingredient}${newLine}")
        }

        return result.toString().substring(0, (result.length - 2))
    }

    companion object {
        const val NONEXISTENT_ID = -1L;
    }
}