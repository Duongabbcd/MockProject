package gst.trainingcourse.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import gst.trainingcourse.mockproject.databinding.ItemIndexBinding


class SeekBarAdapter(private val list: ArrayList<Int>, private val context:Context) :RecyclerView.Adapter<SeekBarAdapter.NumberViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeekBarAdapter.NumberViewHolder {
      val binding = ItemIndexBinding.inflate(LayoutInflater.from(context),parent,false)
        return NumberViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SeekBarAdapter.NumberViewHolder, position: Int) {
            holder.display(position)

    }

    override fun getItemCount(): Int {
       return list.size
    }

    inner class NumberViewHolder(private val binding :ItemIndexBinding ):RecyclerView.ViewHolder(binding.root){
        fun display(i: Int) {
            if(i%4 ==0){
                binding.viewValue.visibility= View.GONE
                binding.viewValue1.visibility= View.VISIBLE
            }
            else{
                binding.viewValue.visibility= View.VISIBLE
                binding.viewValue1.visibility= View.GONE
            }
        }

    }

}