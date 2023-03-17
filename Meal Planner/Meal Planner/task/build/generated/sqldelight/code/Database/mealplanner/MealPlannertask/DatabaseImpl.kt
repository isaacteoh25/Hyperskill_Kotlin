package mealplanner.MealPlannertask

import com.squareup.sqldelight.Query
import com.squareup.sqldelight.TransacterImpl
import com.squareup.sqldelight.db.SqlCursor
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.internal.copyOnWriteList
import kotlin.Any
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.MutableList
import kotlin.jvm.JvmField
import kotlin.reflect.KClass
import mealplanner.Database
import mealplanner.data.DaoQueries
import mealplanner.data.Ingredient
import mealplanner.data.Meal
import mealplanner.data.Plan

internal val KClass<Database>.schema: SqlDriver.Schema
  get() = DatabaseImpl.Schema

internal fun KClass<Database>.newInstance(driver: SqlDriver): Database = DatabaseImpl(driver)

private class DatabaseImpl(
  driver: SqlDriver
) : TransacterImpl(driver), Database {
  override val daoQueries: DaoQueriesImpl = DaoQueriesImpl(this, driver)

  object Schema : SqlDriver.Schema {
    override val version: Int
      get() = 1

    override fun create(driver: SqlDriver) {
      driver.execute(null, """
          |CREATE TABLE IF NOT EXISTS Meal (
          |    meal_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
          |    meal TEXT NOT NULL,
          |    category TEXT NOT NULL
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE IF NOT EXISTS Ingredient (
          |    ingredient_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
          |    ingredient TEXT NOT NULL,
          |    meal_id INTEGER NOT NULL,
          |    FOREIGN KEY (meal_id) REFERENCES Meal(meal_id) ON UPDATE CASCADE ON DELETE CASCADE
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE IF NOT EXISTS Plan (
          |    plan_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
          |    day TEXT NOT NULL,
          |    category TEXT NOT NULL,
          |    meal_id INTEGER NOT NULL,
          |    FOREIGN KEY (meal_id) REFERENCES Meal(meal_id) ON UPDATE CASCADE ON DELETE CASCADE
          |)
          """.trimMargin(), 0)
      driver.execute(null, "CREATE UNIQUE INDEX IF NOT EXISTS IX_Meal_meal ON Meal(meal)", 0)
      driver.execute(null,
          "CREATE INDEX IF NOT EXISTS IX_Ingredient_meal_id ON Ingredient(meal_id)", 0)
      driver.execute(null,
          "CREATE INDEX IF NOT EXISTS IX_Ingredient_ingredient ON Ingredient(ingredient)", 0)
      driver.execute(null, "CREATE INDEX IF NOT EXISTS IX_Plan_meal_id ON Plan(meal_id)", 0)
    }

    override fun migrate(
      driver: SqlDriver,
      oldVersion: Int,
      newVersion: Int
    ) {
    }
  }
}

private class DaoQueriesImpl(
  private val database: DatabaseImpl,
  private val driver: SqlDriver
) : TransacterImpl(driver), DaoQueries {
  internal val findAllMeals: MutableList<Query<*>> = copyOnWriteList()

  internal val findMealById: MutableList<Query<*>> = copyOnWriteList()

  internal val findMealByName: MutableList<Query<*>> = copyOnWriteList()

  internal val findMealsByCategory: MutableList<Query<*>> = copyOnWriteList()

  internal val findMealsSummaryByCategory: MutableList<Query<*>> = copyOnWriteList()

  internal val countAllMeals: MutableList<Query<*>> = copyOnWriteList()

  internal val findAllIngredients: MutableList<Query<*>> = copyOnWriteList()

  internal val findIngredientById: MutableList<Query<*>> = copyOnWriteList()

  internal val findIngredientByName: MutableList<Query<*>> = copyOnWriteList()

  internal val findIngredientByMealId: MutableList<Query<*>> = copyOnWriteList()

  internal val countAllIngredients: MutableList<Query<*>> = copyOnWriteList()

  internal val findAllPlans: MutableList<Query<*>> = copyOnWriteList()

  internal val findPlanById: MutableList<Query<*>> = copyOnWriteList()

  internal val lastInsertedId: MutableList<Query<*>> = copyOnWriteList()

  override fun <T : Any> findAllMeals(mapper: (
    meal_id: Long,
    meal: String,
    category: String
  ) -> T): Query<T> = Query(1407055479, findAllMeals, driver, "Dao.sq", "findAllMeals",
      "SELECT meal_id, meal, category FROM Meal ORDER BY meal_id") { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getString(2)!!
    )
  }

  override fun findAllMeals(): Query<Meal> = findAllMeals { meal_id, meal, category ->
    mealplanner.data.Meal(
      meal_id,
      meal,
      category
    )
  }

  override fun <T : Any> findMealById(meal_id: Long, mapper: (
    meal_id: Long,
    meal: String,
    category: String
  ) -> T): Query<T> = FindMealByIdQuery(meal_id) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getString(2)!!
    )
  }

  override fun findMealById(meal_id: Long): Query<Meal> = findMealById(meal_id) { meal_id, meal,
      category ->
    mealplanner.data.Meal(
      meal_id,
      meal,
      category
    )
  }

  override fun <T : Any> findMealByName(meal: String, mapper: (
    meal_id: Long,
    meal: String,
    category: String
  ) -> T): Query<T> = FindMealByNameQuery(meal) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getString(2)!!
    )
  }

  override fun findMealByName(meal: String): Query<Meal> = findMealByName(meal) { meal_id, meal,
      category ->
    mealplanner.data.Meal(
      meal_id,
      meal,
      category
    )
  }

  override fun <T : Any> findMealsByCategory(category: String, mapper: (
    meal_id: Long,
    meal: String,
    category: String
  ) -> T): Query<T> = FindMealsByCategoryQuery(category) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getString(2)!!
    )
  }

  override fun findMealsByCategory(category: String): Query<Meal> = findMealsByCategory(category) {
      meal_id, meal, category ->
    mealplanner.data.Meal(
      meal_id,
      meal,
      category
    )
  }

  override fun findMealsSummaryByCategory(category: String): Query<String> =
      FindMealsSummaryByCategoryQuery(category) { cursor ->
    cursor.getString(0)!!
  }

  override fun countAllMeals(): Query<Long> = Query(1913009743, countAllMeals, driver, "Dao.sq",
      "countAllMeals", "SELECT COUNT(*) AS Quantity FROM Meal") { cursor ->
    cursor.getLong(0)!!
  }

  override fun <T : Any> findAllIngredients(mapper: (
    ingredient_id: Long,
    ingredient: String,
    meal_id: Long
  ) -> T): Query<T> = Query(100364521, findAllIngredients, driver, "Dao.sq", "findAllIngredients",
      "SELECT ingredient_id, ingredient, meal_id FROM Ingredient ORDER BY ingredient_id") {
      cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getLong(2)!!
    )
  }

  override fun findAllIngredients(): Query<Ingredient> = findAllIngredients { ingredient_id,
      ingredient, meal_id ->
    mealplanner.data.Ingredient(
      ingredient_id,
      ingredient,
      meal_id
    )
  }

  override fun <T : Any> findIngredientById(ingredient_id: Long, mapper: (
    ingredient_id: Long,
    ingredient: String,
    meal_id: Long
  ) -> T): Query<T> = FindIngredientByIdQuery(ingredient_id) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getLong(2)!!
    )
  }

  override fun findIngredientById(ingredient_id: Long): Query<Ingredient> =
      findIngredientById(ingredient_id) { ingredient_id, ingredient, meal_id ->
    mealplanner.data.Ingredient(
      ingredient_id,
      ingredient,
      meal_id
    )
  }

  override fun <T : Any> findIngredientByName(ingredient: String, mapper: (
    ingredient_id: Long,
    ingredient: String,
    meal_id: Long
  ) -> T): Query<T> = FindIngredientByNameQuery(ingredient) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getLong(2)!!
    )
  }

  override fun findIngredientByName(ingredient: String): Query<Ingredient> =
      findIngredientByName(ingredient) { ingredient_id, ingredient, meal_id ->
    mealplanner.data.Ingredient(
      ingredient_id,
      ingredient,
      meal_id
    )
  }

  override fun <T : Any> findIngredientByMealId(meal_id: Long, mapper: (
    ingredient_id: Long,
    ingredient: String,
    meal_id: Long
  ) -> T): Query<T> = FindIngredientByMealIdQuery(meal_id) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getLong(2)!!
    )
  }

  override fun findIngredientByMealId(meal_id: Long): Query<Ingredient> =
      findIngredientByMealId(meal_id) { ingredient_id, ingredient, meal_id ->
    mealplanner.data.Ingredient(
      ingredient_id,
      ingredient,
      meal_id
    )
  }

  override fun countAllIngredients(): Query<Long> = Query(821718721, countAllIngredients, driver,
      "Dao.sq", "countAllIngredients", "SELECT COUNT(*) FROM Ingredient") { cursor ->
    cursor.getLong(0)!!
  }

  override fun <T : Any> findAllPlans(mapper: (
    plan_id: Long,
    day: String,
    category: String,
    meal_id: Long
  ) -> T): Query<T> = Query(1410034641, findAllPlans, driver, "Dao.sq", "findAllPlans",
      "SELECT plan_id, day, category, meal_id FROM Plan ORDER BY plan_id") { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getString(2)!!,
      cursor.getLong(3)!!
    )
  }

  override fun findAllPlans(): Query<Plan> = findAllPlans { plan_id, day, category, meal_id ->
    mealplanner.data.Plan(
      plan_id,
      day,
      category,
      meal_id
    )
  }

  override fun <T : Any> findPlanById(plan_id: Long, mapper: (
    plan_id: Long,
    day: String,
    category: String,
    meal_id: Long
  ) -> T): Query<T> = FindPlanByIdQuery(plan_id) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getString(2)!!,
      cursor.getLong(3)!!
    )
  }

  override fun findPlanById(plan_id: Long): Query<Plan> = findPlanById(plan_id) { plan_id, day,
      category, meal_id ->
    mealplanner.data.Plan(
      plan_id,
      day,
      category,
      meal_id
    )
  }

  override fun lastInsertedId(): Query<Long> = Query(-824069768, lastInsertedId, driver, "Dao.sq",
      "lastInsertedId", "SELECT last_insert_rowid()") { cursor ->
    cursor.getLong(0)!!
  }

  override fun addMeal(meal: String, category: String) {
    driver.execute(-263640843, """INSERT INTO Meal(meal, category) VALUES (?, ?)""", 2) {
      bindString(1, meal)
      bindString(2, category)
    }
    notifyQueries(-263640843, {database.daoQueries.findAllMeals + database.daoQueries.findMealById +
        database.daoQueries.findMealByName + database.daoQueries.findMealsByCategory +
        database.daoQueries.findMealsSummaryByCategory + database.daoQueries.countAllMeals})
  }

  override fun modifyMeal(
    meal: String,
    category: String,
    meal_id: Long
  ) {
    driver.execute(-264224500, """UPDATE Meal SET meal = ?, category = ? WHERE meal_id = ?""", 3) {
      bindString(1, meal)
      bindString(2, category)
      bindLong(3, meal_id)
    }
    notifyQueries(-264224500, {database.daoQueries.findAllMeals + database.daoQueries.findMealById +
        database.daoQueries.findMealByName + database.daoQueries.findMealsByCategory +
        database.daoQueries.findMealsSummaryByCategory + database.daoQueries.countAllMeals})
  }

  override fun removeMeal(meal_id: Long) {
    driver.execute(-377041962, """DELETE FROM Meal WHERE meal_id = ?""", 1) {
      bindLong(1, meal_id)
    }
    notifyQueries(-377041962, {database.daoQueries.findAllMeals + database.daoQueries.findMealById +
        database.daoQueries.findMealByName + database.daoQueries.findMealsByCategory +
        database.daoQueries.findMealsSummaryByCategory + database.daoQueries.countAllMeals})
  }

  override fun removeAllMeals() {
    driver.execute(-1813098878, """DELETE FROM Meal""", 0)
    notifyQueries(-1813098878, {database.daoQueries.findAllMeals +
        database.daoQueries.findMealById + database.daoQueries.findMealByName +
        database.daoQueries.findMealsByCategory + database.daoQueries.findMealsSummaryByCategory +
        database.daoQueries.countAllMeals})
  }

  override fun addIngredient(ingredient: String, meal_id: Long) {
    driver.execute(857495939, """INSERT INTO Ingredient(ingredient, meal_id) VALUES (?, ?)""", 2) {
      bindString(1, ingredient)
      bindLong(2, meal_id)
    }
    notifyQueries(857495939, {database.daoQueries.findMealsSummaryByCategory +
        database.daoQueries.findAllIngredients + database.daoQueries.findIngredientById +
        database.daoQueries.findIngredientByName + database.daoQueries.findIngredientByMealId +
        database.daoQueries.countAllIngredients})
  }

  override fun modifyIngredient(
    ingredient: String,
    meal_id: Long,
    ingredient_id: Long
  ) {
    driver.execute(1947255898,
        """UPDATE Ingredient SET ingredient = ?, meal_id = ? WHERE ingredient_id = ?""", 3) {
      bindString(1, ingredient)
      bindLong(2, meal_id)
      bindLong(3, ingredient_id)
    }
    notifyQueries(1947255898, {database.daoQueries.findMealsSummaryByCategory +
        database.daoQueries.findAllIngredients + database.daoQueries.findIngredientById +
        database.daoQueries.findIngredientByName + database.daoQueries.findIngredientByMealId +
        database.daoQueries.countAllIngredients})
  }

  override fun removeIngredient(ingredient_id: Long) {
    driver.execute(-1166897244, """DELETE FROM Ingredient WHERE ingredient_id = ?""", 1) {
      bindLong(1, ingredient_id)
    }
    notifyQueries(-1166897244, {database.daoQueries.findMealsSummaryByCategory +
        database.daoQueries.findAllIngredients + database.daoQueries.findIngredientById +
        database.daoQueries.findIngredientByName + database.daoQueries.findIngredientByMealId +
        database.daoQueries.countAllIngredients})
  }

  override fun removeAllIngredients() {
    driver.execute(1682855092, """DELETE FROM Ingredient""", 0)
    notifyQueries(1682855092, {database.daoQueries.findMealsSummaryByCategory +
        database.daoQueries.findAllIngredients + database.daoQueries.findIngredientById +
        database.daoQueries.findIngredientByName + database.daoQueries.findIngredientByMealId +
        database.daoQueries.countAllIngredients})
  }

  override fun addPlan(
    day: String,
    category: String,
    meal_id: Long
  ) {
    driver.execute(-263544741, """INSERT INTO Plan (day, category, meal_id) VALUES (?, ?, ?)""", 3)
        {
      bindString(1, day)
      bindString(2, category)
      bindLong(3, meal_id)
    }
    notifyQueries(-263544741, {database.daoQueries.findAllPlans + database.daoQueries.findPlanById})
  }

  override fun modifyPlan(
    day: String,
    category: String,
    meal_id: Long,
    plan_id: Long
  ) {
    driver.execute(-264128398,
        """UPDATE Plan SET day = ?, category = ?, meal_id = ? WHERE plan_id = ?""", 4) {
      bindString(1, day)
      bindString(2, category)
      bindLong(3, meal_id)
      bindLong(4, plan_id)
    }
    notifyQueries(-264128398, {database.daoQueries.findAllPlans + database.daoQueries.findPlanById})
  }

  override fun removePlan(plan_id: Long) {
    driver.execute(-376945860, """DELETE FROM Plan WHERE plan_id = ?""", 1) {
      bindLong(1, plan_id)
    }
    notifyQueries(-376945860, {database.daoQueries.findAllPlans + database.daoQueries.findPlanById})
  }

  override fun removeAllPlans() {
    driver.execute(-1810119716, """DELETE FROM Plan""", 0)
    notifyQueries(-1810119716, {database.daoQueries.findAllPlans +
        database.daoQueries.findPlanById})
  }

  private inner class FindMealByIdQuery<out T : Any>(
    @JvmField
    val meal_id: Long,
    mapper: (SqlCursor) -> T
  ) : Query<T>(findMealById, mapper) {
    override fun execute(): SqlCursor = driver.executeQuery(-1358927683,
        """SELECT meal_id, meal, category FROM Meal WHERE meal_id = ?""", 1) {
      bindLong(1, meal_id)
    }

    override fun toString(): String = "Dao.sq:findMealById"
  }

  private inner class FindMealByNameQuery<out T : Any>(
    @JvmField
    val meal: String,
    mapper: (SqlCursor) -> T
  ) : Query<T>(findMealByName, mapper) {
    override fun execute(): SqlCursor = driver.executeQuery(-259295827,
        """SELECT meal_id, meal, category FROM Meal WHERE meal = ?""", 1) {
      bindString(1, meal)
    }

    override fun toString(): String = "Dao.sq:findMealByName"
  }

  private inner class FindMealsByCategoryQuery<out T : Any>(
    @JvmField
    val category: String,
    mapper: (SqlCursor) -> T
  ) : Query<T>(findMealsByCategory, mapper) {
    override fun execute(): SqlCursor = driver.executeQuery(-533459939,
        """SELECT meal_id, meal, category FROM Meal WHERE category = ? ORDER BY meal_id""", 1) {
      bindString(1, category)
    }

    override fun toString(): String = "Dao.sq:findMealsByCategory"
  }

  private inner class FindMealsSummaryByCategoryQuery<out T : Any>(
    @JvmField
    val category: String,
    mapper: (SqlCursor) -> T
  ) : Query<T>(findMealsSummaryByCategory, mapper) {
    override fun execute(): SqlCursor = driver.executeQuery(-334282733, """
    |SELECT
    |    m.meal || ' ' || GROUP_CONCAT(i.ingredient, ' ')
    |FROM
    |    Meal AS m
    |    INNER JOIN
    |    Ingredient AS i
    |    ON (m.meal_id = i.meal_id)
    |WHERE
    |    m.category = ?
    |GROUP BY
    |    m.meal_id,
    |    m.meal
    |ORDER BY
    |    m.meal_id
    """.trimMargin(), 1) {
      bindString(1, category)
    }

    override fun toString(): String = "Dao.sq:findMealsSummaryByCategory"
  }

  private inner class FindIngredientByIdQuery<out T : Any>(
    @JvmField
    val ingredient_id: Long,
    mapper: (SqlCursor) -> T
  ) : Query<T>(findIngredientById, mapper) {
    override fun execute(): SqlCursor = driver.executeQuery(-1150875189,
        """SELECT ingredient_id, ingredient, meal_id FROM Ingredient WHERE ingredient_id = ?""", 1)
        {
      bindLong(1, ingredient_id)
    }

    override fun toString(): String = "Dao.sq:findIngredientById"
  }

  private inner class FindIngredientByNameQuery<out T : Any>(
    @JvmField
    val ingredient: String,
    mapper: (SqlCursor) -> T
  ) : Query<T>(findIngredientByName, mapper) {
    override fun execute(): SqlCursor = driver.executeQuery(2110655291,
        """SELECT ingredient_id, ingredient, meal_id FROM Ingredient WHERE ingredient = ?""", 1) {
      bindString(1, ingredient)
    }

    override fun toString(): String = "Dao.sq:findIngredientByName"
  }

  private inner class FindIngredientByMealIdQuery<out T : Any>(
    @JvmField
    val meal_id: Long,
    mapper: (SqlCursor) -> T
  ) : Query<T>(findIngredientByMealId, mapper) {
    override fun execute(): SqlCursor = driver.executeQuery(1089887470,
        """SELECT ingredient_id, ingredient, meal_id FROM Ingredient WHERE meal_id = ?""", 1) {
      bindLong(1, meal_id)
    }

    override fun toString(): String = "Dao.sq:findIngredientByMealId"
  }

  private inner class FindPlanByIdQuery<out T : Any>(
    @JvmField
    val plan_id: Long,
    mapper: (SqlCursor) -> T
  ) : Query<T>(findPlanById, mapper) {
    override fun execute(): SqlCursor = driver.executeQuery(1493941539,
        """SELECT plan_id, day, category, meal_id FROM Plan WHERE plan_id = ?""", 1) {
      bindLong(1, plan_id)
    }

    override fun toString(): String = "Dao.sq:findPlanById"
  }
}
