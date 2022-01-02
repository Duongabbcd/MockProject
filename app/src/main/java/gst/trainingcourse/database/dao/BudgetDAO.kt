package gst.trainingcourse.database.dao

import androidx.room.*
import gst.trainingcourse.constants.Utils
import gst.trainingcourse.database.entities.EntityBudget
import gst.trainingcourse.database.model.Budget
import kotlinx.coroutines.flow.Flow

@Dao
interface BudgetDAO {
    @Insert
    fun insertBudget(entityBudget: List<EntityBudget>)

    @Update
    suspend fun updateBudget(entityBudget: EntityBudget)

    @Transaction
    @Query("select * from ${Utils.TABLE}")
    fun getBudget() : Flow<List<EntityBudget>>
}