package mealplanner.model

data class Plan(val id: Long, val day: String, val category: MealCategory, val meal: Meal) {
    constructor(day: String, category: MealCategory, meal: Meal): this(NONEXISTENT_ID, day, category, meal)

    companion object {
        const val NONEXISTENT_ID = -1L
    }
}