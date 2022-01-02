package gst.trainingcourse.viewmodel

import android.app.Application
import androidx.lifecycle.*
import gst.trainingcourse.database.BudgetDatabase
import gst.trainingcourse.database.model.Budget
import gst.trainingcourse.database.toBudgetModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class BudgetViewModel(application: Application) : AndroidViewModel(application) {
    private var database =BudgetDatabase.getInstance(application)
    private val _budgetList = MutableLiveData<List<Budget>>()
    val budgetList :LiveData<List<Budget>>
    get() = _budgetList

    fun getBudgetList(){
        viewModelScope.launch {
            database.budgetDAO().getBudget().catch {

            }.collect {
                value->    _budgetList.value =value.toBudgetModel()
            }
        }
    }

}