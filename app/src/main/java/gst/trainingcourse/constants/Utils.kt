package gst.trainingcourse.constants


import gst.trainingcourse.database.model.Budget
import gst.trainingcourse.mockproject.R

object Utils {
    const val normal ="Normal"
    const val normal_des_1="Sometimes,you can eat in cafe\nUp to 3% of economy"

    const val alot ="That's a lot"
    const val alot_des_1="Sometimes,you can eat in cafe\nUp to 3% of economy"

    const val crazy="Are you crazy?"
    const val crazy_des_1="Eat in restaurant every day\nBlow off 30% of money"

    const val DATABASE_NAME="BUDGET_DATABASE"
    const val TABLE ="budget_table"
    const val BUDGET_ID="budget_id"
    const val BUDGET_NAME="budget_name"
    const val BUDGET_VALUE="budget_value"
    const val BUDGET_IMAGE1="image1"
    const val BUDGET_IMAGE2="image2"

    fun getBudgetValue() :List<Budget>{
        return listOf(Budget(0,"Cafe",400, R.drawable.cafe,R.drawable.cafe) ,
            Budget(0,"Taxi",400, R.drawable.taxi,R.drawable.taxi) ,
            Budget(0,"Love",400, R.drawable.love,R.drawable.love) ,
            Budget(0,"Taxi",400, R.drawable.house,R.drawable.house) ,
            Budget(0,"House",400, R.drawable.gym,R.drawable.gym) ,
            Budget(0,"Other",400, R.drawable.other,R.drawable.other) )
    }
}