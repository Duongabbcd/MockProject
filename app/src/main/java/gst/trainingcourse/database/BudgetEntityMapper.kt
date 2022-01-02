package gst.trainingcourse.database

import gst.trainingcourse.database.entities.EntityBudget
import gst.trainingcourse.database.model.Budget

fun List<Budget>.toBudgets():List<EntityBudget>{
    return this.map{
          budget->
        EntityBudget(
            budget.budgetId ,
            budget.budgetName ,
            budget.budgetValue,
            budget.budgetImage1,
            budget.budgetImage2
          )
    }
}

fun List<EntityBudget>.toBudgetModel() :List<Budget>{
    return this.map{
            budgetEntity-> Budget(
        budgetEntity.budgetId ,
        budgetEntity.budgetName ,
        budgetEntity.budgetValue,
        budgetEntity.budgetImage1,
        budgetEntity.budgetImage2
    )
    }
}


fun Budget.toBudgetEntites() : EntityBudget{
    return EntityBudget(budgetId, budgetName, budgetValue, budgetImage1, budgetImage2)
}