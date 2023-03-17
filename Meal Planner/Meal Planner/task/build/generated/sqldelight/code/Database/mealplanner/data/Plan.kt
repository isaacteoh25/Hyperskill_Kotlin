package mealplanner.data

import kotlin.Long
import kotlin.String

data class Plan(
  val plan_id: Long,
  val day: String,
  val category: String,
  val meal_id: Long
) {
  override fun toString(): String = """
  |Plan [
  |  plan_id: $plan_id
  |  day: $day
  |  category: $category
  |  meal_id: $meal_id
  |]
  """.trimMargin()
}
