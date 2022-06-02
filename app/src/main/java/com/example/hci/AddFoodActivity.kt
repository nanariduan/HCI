package com.example.hci

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
import java.lang.Exception
import java.util.*

class AddFoodActivity :AppCompatActivity(){
    lateinit var binding: AddFoodBinding
    val data: ArrayList<FoodData> = ArrayList()
    lateinit var adapter: FoodAdapter

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

            }

        }
        binding.recyclerView.adapter = adapter

    }
}
