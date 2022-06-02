package com.example.hci

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hci.databinding.AddFoodRowBinding

class FoodAdapter(val items:ArrayList<FoodData>): RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    interface OnItemClickListener{
        fun OnItemClick(data:FoodData)
    }

    var itemClickListener:OnItemClickListener?=null
    inner class ViewHolder(val binding: AddFoodRowBinding)  :  RecyclerView.ViewHolder(binding.root) {
            init{
                binding.textView.setOnClickListener{
                }
            }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AddFoodRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.textView.text = items[position].food
        holder.binding.calView.text = items[position].calorie + " kcal"
    }
}