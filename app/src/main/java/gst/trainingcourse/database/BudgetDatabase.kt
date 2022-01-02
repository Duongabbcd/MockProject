package gst.trainingcourse.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import gst.trainingcourse.constants.Utils
import gst.trainingcourse.database.dao.BudgetDAO
import gst.trainingcourse.database.entities.EntityBudget
import java.util.concurrent.Executors

@Database(entities =[EntityBudget::class],version = 1 ,exportSchema = false)
abstract class BudgetDatabase :RoomDatabase() {
    abstract fun budgetDAO():BudgetDAO

    companion object {
        @Volatile
        private var instance: BudgetDatabase? = null
        fun getInstance(context: Context): BudgetDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): BudgetDatabase {
            return Room.databaseBuilder(context, BudgetDatabase::class.java, Utils.DATABASE_NAME)
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        //pre-populate data
                        Executors.newSingleThreadExecutor().execute {
                            instance?.let {
                                it.budgetDAO().insertBudget(Utils.getBudgetValue().toBudgets())
                            }
                        }
                    }
                })
                .build()
        }

    }
}