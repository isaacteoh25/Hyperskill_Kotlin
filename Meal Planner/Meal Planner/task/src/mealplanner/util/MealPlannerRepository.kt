package mealplanner.util

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver
import mealplanner.Database
import mealplanner.data.DaoQueries
//import mealplanner.data.Database
import mealplanner.model.Ingredient
import mealplanner.model.Meal
import mealplanner.model.MealCategory
import mealplanner.model.Plan

class MealPlannerRepository(databaseName: String) {
    private val driver: SqlDriver
    private val db: Database
    private val dao: DaoQueries

    init {
        val url = "jdbc:sqlite:$databaseName";

        driver = JdbcSqliteDriver(url=url)

        Database.Schema.create(driver)

        db = Database(driver)
        dao = db.daoQueries
    }

    fun addMeal(meal: Meal): Long {
        require(
            meal.id == Meal.NONEXISTENT_ID &&
                    meal.ingredients.filter { it.id != Ingredient.NONEXISTENT_ID }.count() == 0
        ) {
            "All meal and ingredients IDs must not exists!"
        }

        var mealId = Meal.NONEXISTENT_ID

        dao.transaction {
            dao.addMeal(meal=meal.name, category=meal.category.dbName)
            mealId = dao.lastInsertedId().executeAsOne()
            for (ingredient in meal.ingredients) {
                dao.addIngredient(ingredient=ingredient.name, meal_id=mealId)
            }
        }

        return mealId
    }

    fun getAllMeals(): List<Meal> {
        val mealsDto = dao.findAllMeals().executeAsList()
        val ingredientsDto = dao.findAllIngredients().executeAsList()

        val meals = mutableListOf<Meal>()

        for (mealDto in mealsDto) {
            val mealId = mealDto.meal_id
            val mealName = mealDto.meal
            val category = MealCategory.lookupByName(mealDto.category)

            val mealIngredientsDto = ingredientsDto.filter { it.meal_id == mealId }
            val ingredients = mutableListOf<Ingredient>()
            for (ingredientDto in mealIngredientsDto) {
                val ingredientId = ingredientDto.ingredient_id
                val ingredientName = ingredientDto.ingredient
                val ingredient = Ingredient(id=ingredientId, name=ingredientName)
                ingredients.add(ingredient)
            }

            val meal = Meal(id=mealId, name=mealName, category=category, ingredients=ingredients.toList())
            meals.add(meal)
        }

        return meals.toList()
    }

    fun getMealsFromCategory(category: MealCategory): List<Meal> {
        val mealsDto = dao.findMealsByCategory(category=category.dbName).executeAsList()
        val ingredientsDto = dao.findAllIngredients().executeAsList()

        val meals = mutableListOf<Meal>()

        for (mealDto in mealsDto) {
            val mealId = mealDto.meal_id
            val mealName = mealDto.meal
            val category = MealCategory.lookupByName(mealDto.category)

            val mealIngredientsDto = ingredientsDto.filter { it.meal_id == mealId }
            val ingredients = mutableListOf<Ingredient>()
            for (ingredientDto in mealIngredientsDto) {
                val ingredientId = ingredientDto.ingredient_id
                val ingredientName = ingredientDto.ingredient
                val ingredient = Ingredient(id=ingredientId, name=ingredientName)
                ingredients.add(ingredient)
            }

            val meal = Meal(id=mealId, name=mealName, category=category, ingredients=ingredients.toList())
            meals.add(meal)
        }

        return meals.toList()
    }

    fun getMealsSummaryFromCategory(category: MealCategory): List<String> {
        val mealsSummaryDto = dao.findMealsSummaryByCategory(category=category.dbName).executeAsList()

        val mealsSummary = mutableListOf<String>()

        mealsSummaryDto.forEach {
            mealsSummary.add(it)
        }

        return mealsSummary.toList()
    }

    fun getMealsCount() = dao.countAllMeals().executeAsOne()

    fun addPlan(plan: Plan) {
        require(plan.id == Plan.NONEXISTENT_ID) { "Plan ID must not exists"}

        dao.addPlan(day=plan.day, category=plan.category.dbName, meal_id=plan.meal.id)
    }

    fun getAllPlans(): List<Plan> {
        val meals = getAllMeals()
        val plansDto = dao.findAllPlans().executeAsList()

        val plans = mutableListOf<Plan>()

        for (planDto in plansDto) {
            val meal = meals.first { it.id == planDto.meal_id }
            val plan = Plan(id=planDto.plan_id, day=planDto.day, MealCategory.lookupByName(planDto.category), meal)
            plans.add(plan)
        }

        return plans.toList()
    }

    fun close() {
        driver.close()
    }
}
