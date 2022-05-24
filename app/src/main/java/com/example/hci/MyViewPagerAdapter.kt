package com.example.hci

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyViewPagerAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->RecordCalorieFragment()
            1->BMIFragment()
            2->DietTipsFragment()
            3->EditInfoFragment()
            else->RecordCalorieFragment()
        }
    }
}