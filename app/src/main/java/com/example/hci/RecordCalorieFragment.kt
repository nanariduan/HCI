package com.example.hci

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.hci.databinding.RecordCalorieBinding
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList

class RecordCalorieFragment :Fragment(){
    private lateinit var binding: RecordCalorieBinding
    val breakfastdata: ArrayList<FoodData> = ArrayList()
    lateinit var adapter: ArrayAdapter<ArrayList<FoodData>>
    private lateinit var listView : ListView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = RecordCalorieBinding.inflate(layoutInflater)
        return binding.root

    }
    private fun initdata(){
            val scan2 =Scanner(activity?.openFileInput("breakfast.txt"))
            readFileScan(scan2,breakfastdata)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initdata()
        binding.linlay.adapter = ArrayAdapter(this, R.layout.food_row, breakfastdata)
        val b = Bundle()
        val breakfast =  binding.root.findViewById<Button>(R.id.addBreakfast)
        breakfast.setOnClickListener {
            val intent = Intent(this@RecordCalorieFragment.context, AddFoodActivity::class.java)
            b.putInt("key", 1)
            intent.putExtras(b)
            startActivity(intent)
        }

        val lunch =  binding.root.findViewById<Button>(R.id.addLunch)
        lunch.setOnClickListener {
            val intent = Intent(this@RecordCalorieFragment.context, AddFoodActivity::class.java)
            b.putInt("key", 2)
            intent.putExtras(b)
            startActivity(intent)
        }

        val dinner =  binding.root.findViewById<Button>(R.id.addDinner)
        dinner.setOnClickListener {
            val intent = Intent(this@RecordCalorieFragment.context, AddFoodActivity::class.java)
            b.putInt("key", 3)
            intent.putExtras(b)
            startActivity(intent)
        }

        val snack =  binding.root.findViewById<Button>(R.id.addSnack)
        snack.setOnClickListener {
            val intent = Intent(this@RecordCalorieFragment.context, AddFoodActivity::class.java)
            b.putInt("key", 4)
            intent.putExtras(b)
            startActivity(intent)
        }

    }
    fun readFileScan(scan: Scanner,data:ArrayList<FoodData>){
        while (scan.hasNextLine()) {
            val food = scan.nextLine()
            val calorie = scan.nextLine()
            data.add(FoodData(food, calorie))

        }
    }
}
