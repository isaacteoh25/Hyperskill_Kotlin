package mealplanner.model

data class Ingredient (val id: Long,
                       val name: String) {

    constructor(name: String) : this(NONEXISTENT_ID, name)

    override fun toString(): String {
        return name
    }

    companion object {
        const val NONEXISTENT_ID = -1L;
    }
}