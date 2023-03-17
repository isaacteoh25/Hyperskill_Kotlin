package mealplanner.data

import kotlin.Long
import kotlin.String

data class Meal(
  val meal_id: Long,
  val meal: String,
  val category: String
) {
  override fun toString(): String = """
  |Meal [
  |  meal_id: $meal_id
  |  meal: $meal
  |  category: $category
  |]
  """.trimMargin()
}
