package com.example.hci

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.hci.databinding.RecordCalorieBinding
import java.util.*
import kotlin.collections.ArrayList

class RecordCalorieFragment :Fragment(){
    private lateinit var binding: RecordCalorieBinding
    val breakfastdata: ArrayList<FoodData> = ArrayList()
    val lunchdata: ArrayList<FoodData> = ArrayList()
    val dinnerdata: ArrayList<FoodData> = ArrayList()
    val snackdata: ArrayList<FoodData> = ArrayList()
    lateinit var adapter: FoodListAdapter
    private lateinit var listView : ListView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initdata()
        binding = RecordCalorieBinding.inflate(layoutInflater)
        val adapter1 = FoodListAdapter(this@RecordCalorieFragment.context,breakfastdata)
        val adapter2 = FoodListAdapter(this@RecordCalorieFragment.context,lunchdata)
        val adapter3 = FoodListAdapter(this@RecordCalorieFragment.context,dinnerdata)
        val adapter4 = FoodListAdapter(this@RecordCalorieFragment.context,snackdata)
        binding.linlay1.adapter = adapter1
        binding.linlay2.adapter = adapter2
        binding.linlay3.adapter = adapter3
        binding.linlay4.adapter = adapter4

        return binding.root

    }
    private fun initdata(){
            val scan1 =Scanner(activity?.openFileInput("breakfast.txt"))
            readFileScan(scan1,breakfastdata)
            val scan2 =Scanner(activity?.openFileInput("lunch.txt"))
            readFileScan(scan2,lunchdata)
            val scan3 =Scanner(activity?.openFileInput("dinner.txt"))
            readFileScan(scan3,dinnerdata)
            val scan4 =Scanner(activity?.openFileInput("snack.txt"))
            readFileScan(scan4,snackdata)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

        val submit =  binding.root.findViewById<Button>(R.id.submit)
        submit.setOnClickListener {
            val intent = Intent(this@RecordCalorieFragment.context, ResultActivity::class.java)
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
