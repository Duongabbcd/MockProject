package gst.trainingcourse.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import gst.trainingcourse.database.model.Budget

import gst.trainingcourse.mockproject.databinding.ItemBudgetBinding


class BudgetAdapter(private val list: ArrayList<Budget> ,private val context:Context) : RecyclerView.Adapter<BudgetAdapter.BudgetViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BudgetAdapter.BudgetViewHolder {
        val binding = ItemBudgetBinding.inflate(LayoutInflater.from(context),parent,false)
        return BudgetViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return list.size
    }

    inner class BudgetViewHolder(private val binding : ItemBudgetBinding): RecyclerView.ViewHolder(binding.root){
        fun display(i:Int){
            binding.image1.setImageResource(list[i].budgetImage1)
            binding.title1.text= list[i].budgetName
            binding.cost1.text=list[i].budgetValue.toString()
            when((i+1)%6){
                0->binding.container.setBackgroundColor(Color.YELLOW)
                1-> binding.container.setBackgroundColor(Color.MAGENTA)
                2->binding.container.setBackgroundColor(Color.BLUE)
                3->binding.container.setBackgroundColor(Color.GREEN)
                4->binding.container.setBackgroundColor(Color.RED)
                5->binding.container.setBackgroundColor(Color.DKGRAY)
            }
        }
    }

    override fun onBindViewHolder(holder: BudgetViewHolder, position: Int) {
        holder.display(position)
    }

}