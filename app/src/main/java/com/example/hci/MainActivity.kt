package com.example.hci

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.example.hci.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val textarr = arrayListOf<String>("calorie", "bmi", "tips", "info")
    val iconarr = arrayListOf<Int>(
        R.drawable.ic_baseline_dinner_dining_24,
        R.drawable.ic_baseline_architecture_24,
        R.drawable.ic_baseline_library_books_24,
        R.drawable.ic_baseline_person_24
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initLayout()
    }

    fun initLayout() {
        binding.viewpager.adapter = MyViewPagerAdapter(this)
        TabLayoutMediator(binding.tablayout, binding.viewpager) { tab, position ->
            tab.text = textarr[position]
            tab.setIcon(iconarr[position])
        }.attach()

    }

    fun reload(){
        binding.viewpager.adapter = MyViewPagerAdapter(this)
    }
}