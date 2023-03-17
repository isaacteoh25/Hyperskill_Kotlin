package mealplanner.data

import kotlin.Long
import kotlin.String

data class Ingredient(
  val ingredient_id: Long,
  val ingredient: String,
  val meal_id: Long
) {
  override fun toString(): String = """
  |Ingredient [
  |  ingredient_id: $ingredient_id
  |  ingredient: $ingredient
  |  meal_id: $meal_id
  |]
  """.trimMargin()
}
