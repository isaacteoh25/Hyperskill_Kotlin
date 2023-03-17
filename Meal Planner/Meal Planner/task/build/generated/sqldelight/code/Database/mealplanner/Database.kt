package mealplanner

import com.squareup.sqldelight.Transacter
import com.squareup.sqldelight.db.SqlDriver
import mealplanner.MealPlannertask.newInstance
import mealplanner.MealPlannertask.schema
import mealplanner.data.DaoQueries

interface Database : Transacter {
  val daoQueries: DaoQueries

  companion object {
    val Schema: SqlDriver.Schema
      get() = Database::class.schema

    operator fun invoke(driver: SqlDriver): Database = Database::class.newInstance(driver)}
}
