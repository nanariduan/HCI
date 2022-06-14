package com.example.hci

import android.app.AlertDialog
import android.content.Intent
import android.icu.text.AlphabeticIndex
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.hci.databinding.RecordCalorieBinding
import java.io.File
import java.io.FileNotFoundException
import java.util.*
import kotlin.collections.ArrayList

class RecordCalorieFragment :Fragment(){
    private lateinit var binding: RecordCalorieBinding
    val breakfastdata: ArrayList<FoodData> = ArrayList()
    val lunchdata: ArrayList<FoodData> = ArrayList()
    val dinnerdata: ArrayList<FoodData> = ArrayList()
    val snackdata: ArrayList<FoodData> = ArrayList()
    lateinit var adapter1:FoodListAdapter
    lateinit var adapter2:FoodListAdapter
    lateinit var adapter3:FoodListAdapter
    lateinit var adapter4:FoodListAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initdata()
        binding = RecordCalorieBinding.inflate(layoutInflater)
        adapter1 = FoodListAdapter(this@RecordCalorieFragment.context,breakfastdata)
        adapter2 = FoodListAdapter(this@RecordCalorieFragment.context,lunchdata)
        adapter3 = FoodListAdapter(this@RecordCalorieFragment.context,dinnerdata)
        adapter4 = FoodListAdapter(this@RecordCalorieFragment.context,snackdata)
        binding.linlay1.adapter = adapter1
        binding.linlay2.adapter = adapter2
        binding.linlay3.adapter = adapter3
        binding.linlay4.adapter = adapter4

        return binding.root

    }

    private fun initdata(){
        try {
            val scan1 = Scanner(activity?.openFileInput("breakfast.txt"))
            readFileScan(scan1, breakfastdata)
        }catch (e:FileNotFoundException){
        }
        try {
            val scan2 = Scanner(activity?.openFileInput("lunch.txt"))
            readFileScan(scan2, lunchdata)
        }catch (e:FileNotFoundException){
        }
        try {
            val scan3 = Scanner(activity?.openFileInput("dinner.txt"))
            readFileScan(scan3, dinnerdata)
        }catch (e:FileNotFoundException){
        }
        try {
            val scan4 = Scanner(activity?.openFileInput("snack.txt"))
            readFileScan(scan4, snackdata)
        }catch (e:FileNotFoundException){

        }
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
            //val intent = Intent(this@RecordCalorieFragment.context, ResultActivity::class.java)
            val intent = Intent(this@RecordCalorieFragment.context, GraphActivity::class.java)
            startActivity(intent)
        }

        val clear =  binding.root.findViewById<Button>(R.id.clear)
        clear.setOnClickListener {
            val builder = AlertDialog.Builder(this@RecordCalorieFragment.context)
            builder!!.setMessage("채울까요?")
                .setTitle("채우기")

            builder.apply {
                setPositiveButton("예") { dialog, id ->
                    val selectedId = id
//                    breakfastdata.clear()
//                    lunchdata.clear()
//                    dinnerdata.clear()
//                    snackdata.clear()
                    val file = File("/data/data/com.example.hci/files/breakfast.txt")
                    file.delete()
                    val file2 = File("/data/data/com.example.hci/files/lunch.txt")
                    file2.delete()
                    val file3 = File("/data/data/com.example.hci/files/dinner.txt")
                    file3.delete()
                    val file4 = File("/data/data/com.example.hci/files/snack.txt")
                    file4.delete()
                    initdata()
                    (activity as MainActivity?)!!.reload()

                }
                setNegativeButton("아니요") { dialog, id ->
                    val selectedId = id

                }
            }
            val dialog: AlertDialog? = builder.create()

            dialog!!.show()
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

