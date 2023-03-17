package mealplanner.util

enum class ProgramAction {
    ADD,
    SHOW,
    EXIT,
    PLAN,
    UNKNOWN;

    companion object {
        fun lookupByName(name: String): ProgramAction {
            return when (name.toUpperCase()) {
                "ADD" -> ADD
                "SHOW" -> SHOW
                "EXIT" -> EXIT
                "PLAN" -> PLAN
                else -> UNKNOWN
            }
        }
    }
}