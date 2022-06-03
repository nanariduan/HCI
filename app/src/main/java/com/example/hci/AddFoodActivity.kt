package com.example.hci

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hci.databinding.AddFoodBinding
import com.example.hci.databinding.HomepageBinding
import java.io.PrintStream
import java.lang.Exception
import java.util.*

class AddFoodActivity :AppCompatActivity(){
    lateinit var binding: AddFoodBinding
    val data: ArrayList<FoodData> = ArrayList()
    lateinit var adapter: FoodAdapter
    var value:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AddFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initData()
        init()
    }

    private fun initData() {
        val scan = Scanner(resources.openRawResource(R.raw.foodlist))
        readFileScan(scan)
        val b = getIntent().getExtras()
         value = -1 // or other values
        if(b != null)
            value = b.getInt("key")

    }

    fun readFileScan(scan: Scanner){
        while (scan.hasNextLine()) {
            val food = scan.nextLine()
            val calorie = scan.nextLine()
            data.add(FoodData(food, calorie))

        }
    }

    private fun init(){
        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapter = FoodAdapter(data)
        adapter.itemClickListener = object : FoodAdapter.OnItemClickListener {
            override fun OnItemClick(data: FoodData) {
                val intent = Intent(this@AddFoodActivity, MainActivity::class.java)
                startActivity(intent)
                writeFile(data.food,data.calorie,value)

            }
        }
        binding.recyclerView.adapter = adapter

    }

    private fun writeFile(food:String,calorie:String,value:Int){
        var name:String = ""
        when(value){
            1->name ="breakfast.txt"
            2->name ="lunch.txt"
            3->name ="dinner.txt"
            4->name ="snack.txt"
        }

        val output = PrintStream(openFileOutput(name, MODE_APPEND))
        output.println(food)
        output.println(calorie)
        output.close()
    }
}
