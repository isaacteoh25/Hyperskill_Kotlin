package mealplanner.data

import com.squareup.sqldelight.Query
import com.squareup.sqldelight.Transacter
import kotlin.Any
import kotlin.Long
import kotlin.String

interface DaoQueries : Transacter {
  fun <T : Any> findAllMeals(mapper: (
    meal_id: Long,
    meal: String,
    category: String
  ) -> T): Query<T>

  fun findAllMeals(): Query<Meal>

  fun <T : Any> findMealById(meal_id: Long, mapper: (
    meal_id: Long,
    meal: String,
    category: String
  ) -> T): Query<T>

  fun findMealById(meal_id: Long): Query<Meal>

  fun <T : Any> findMealByName(meal: String, mapper: (
    meal_id: Long,
    meal: String,
    category: String
  ) -> T): Query<T>

  fun findMealByName(meal: String): Query<Meal>

  fun <T : Any> findMealsByCategory(category: String, mapper: (
    meal_id: Long,
    meal: String,
    category: String
  ) -> T): Query<T>

  fun findMealsByCategory(category: String): Query<Meal>

  fun findMealsSummaryByCategory(category: String): Query<String>

  fun countAllMeals(): Query<Long>

  fun <T : Any> findAllIngredients(mapper: (
    ingredient_id: Long,
    ingredient: String,
    meal_id: Long
  ) -> T): Query<T>

  fun findAllIngredients(): Query<Ingredient>

  fun <T : Any> findIngredientById(ingredient_id: Long, mapper: (
    ingredient_id: Long,
    ingredient: String,
    meal_id: Long
  ) -> T): Query<T>

  fun findIngredientById(ingredient_id: Long): Query<Ingredient>

  fun <T : Any> findIngredientByName(ingredient: String, mapper: (
    ingredient_id: Long,
    ingredient: String,
    meal_id: Long
  ) -> T): Query<T>

  fun findIngredientByName(ingredient: String): Query<Ingredient>

  fun <T : Any> findIngredientByMealId(meal_id: Long, mapper: (
    ingredient_id: Long,
    ingredient: String,
    meal_id: Long
  ) -> T): Query<T>

  fun findIngredientByMealId(meal_id: Long): Query<Ingredient>

  fun countAllIngredients(): Query<Long>

  fun <T : Any> findAllPlans(mapper: (
    plan_id: Long,
    day: String,
    category: String,
    meal_id: Long
  ) -> T): Query<T>

  fun findAllPlans(): Query<Plan>

  fun <T : Any> findPlanById(plan_id: Long, mapper: (
    plan_id: Long,
    day: String,
    category: String,
    meal_id: Long
  ) -> T): Query<T>

  fun findPlanById(plan_id: Long): Query<Plan>

  fun lastInsertedId(): Query<Long>

  fun addMeal(meal: String, category: String)

  fun modifyMeal(
    meal: String,
    category: String,
    meal_id: Long
  )

  fun removeMeal(meal_id: Long)

  fun removeAllMeals()

  fun addIngredient(ingredient: String, meal_id: Long)

  fun modifyIngredient(
    ingredient: String,
    meal_id: Long,
    ingredient_id: Long
  )

  fun removeIngredient(ingredient_id: Long)

  fun removeAllIngredients()

  fun addPlan(
    day: String,
    category: String,
    meal_id: Long
  )

  fun modifyPlan(
    day: String,
    category: String,
    meal_id: Long,
    plan_id: Long
  )

  fun removePlan(plan_id: Long)

  fun removeAllPlans()
}
