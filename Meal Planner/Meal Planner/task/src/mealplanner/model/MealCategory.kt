package mealplanner.model

enum class MealCategory {
    BREAKFAST,
    LUNCH,
    DINNER,
    UNKNOWN;

    companion object {
        fun lookupByName(name: String): MealCategory {
            return when (name.toUpperCase()) {
                "BREAKFAST" -> BREAKFAST
                "LUNCH" -> LUNCH
                "DINNER" -> DINNER
                else -> UNKNOWN
            }
        }
    }

    override fun toString(): String {
        return name.toLowerCase()
    }

    val dbName: String
        get() = this.name.toLowerCase()
}