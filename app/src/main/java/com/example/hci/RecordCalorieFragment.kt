package com.example.hci

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.hci.databinding.RecordCalorieBinding

class RecordCalorieFragment :Fragment(){
    private lateinit var binding: RecordCalorieBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = RecordCalorieBinding.inflate(layoutInflater)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragment = DietTipsFragment()
        val breakfast =  binding.root.findViewById<Button>(R.id.submit)
        breakfast.setOnClickListener {
            childFragmentManager.beginTransaction().replace(R.id.viewpager, fragment).commit()
        }

    }
}
