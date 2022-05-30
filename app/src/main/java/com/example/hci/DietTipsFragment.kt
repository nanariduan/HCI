package com.example.hci

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.hci.databinding.DietTipsBinding

class DietTipsFragment :Fragment(){
    private lateinit var binding: DietTipsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DietTipsBinding.inflate(layoutInflater)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nut =  binding.root.findViewById<Button>(R.id.nutrition)
        val rec =  binding.root.findViewById<Button>(R.id.recipes)
        nut.setOnClickListener {
            val intent = Intent(this@DietTipsFragment.context, RssNutActivity::class.java)
            startActivity(intent)
        }
        rec.setOnClickListener {
            val intent = Intent(this@DietTipsFragment.context, RssRecActivity::class.java)
            startActivity(intent)
        }
    }
}
