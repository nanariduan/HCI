package com.example.hci

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hci.databinding.AddFoodRowBinding

class FoodListAdapter(private val context: Context?,
                      private val dataSource: ArrayList<FoodData>): BaseAdapter(){

    private val inflater: LayoutInflater
            = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    //1
    override fun getCount(): Int {
        return dataSource.size
    }

    //2
    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    //3
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //4
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get view for row item
        val rowView = inflater.inflate(R.layout.food_row, parent, false)
        val name = rowView.findViewById<TextView>(R.id.textView)
        val cal = rowView.findViewById<TextView>(R.id.calView)
        val data = dataSource[position]
        name.text = data.food
        cal.text = data.calorie + " kcal"

        return rowView
    }

}