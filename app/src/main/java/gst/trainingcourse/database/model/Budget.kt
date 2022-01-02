package gst.trainingcourse.database.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Budget (
    val budgetId :Long = 0 ,
    val budgetName :String ,
    val budgetValue:Int ,
    val budgetImage1:Int ,
    val budgetImage2:Int,
    var expanded:Boolean =false
        ) :Parcelable