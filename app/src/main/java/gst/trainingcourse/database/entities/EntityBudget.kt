package gst.trainingcourse.database.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import gst.trainingcourse.constants.Utils
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName =Utils.TABLE)
data class EntityBudget (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name=Utils.BUDGET_ID)
    val budgetId:Long ,
    @ColumnInfo(name=Utils.BUDGET_NAME)
    val budgetName:String ,
    @ColumnInfo(name=Utils.BUDGET_VALUE)
    val budgetValue:Int ,
    @ColumnInfo(name=Utils.BUDGET_IMAGE1)
    val budgetImage1:Int ,
    @ColumnInfo(name=Utils.BUDGET_IMAGE2)
    val budgetImage2:Int
):Parcelable