package com.example.hci

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.hci.placeholder.PlaceholderContent.PlaceholderItem
import com.example.hci.databinding.RecordCalorieBinding

class MyItemRecyclerViewAdapter(
    private val values: List<String>
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            RecordCalorieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
//        holder.contentView.text = item
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: RecordCalorieBinding) : RecyclerView.ViewHolder(binding.root) {
//        val contentView: TextView = binding.content
//
//        override fun toString(): String {
//            return super.toString() + " '" + contentView.text + "'"
//        }
    }

}