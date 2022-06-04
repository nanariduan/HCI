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
        val fit = binding.root.findViewById<Button>(R.id.fitness)
        val men = binding.root.findViewById<Button>(R.id.mentalhealth)
        val b = Bundle()
        nut.setOnClickListener {
            val intent = Intent(this@DietTipsFragment.context, RssActivity::class.java)
            b.putInt("key", 1)
            intent.putExtras(b)
            startActivity(intent)
        }
        rec.setOnClickListener {
            val intent = Intent(this@DietTipsFragment.context, RssActivity::class.java)
            b.putInt("key", 2)
            intent.putExtras(b)
            startActivity(intent)
        }
        fit.setOnClickListener {
            val intent = Intent(this@DietTipsFragment.context, RssActivity::class.java)
            b.putInt("key", 3)
            intent.putExtras(b)
            startActivity(intent)
        }
        men.setOnClickListener {
            val intent = Intent(this@DietTipsFragment.context, RssActivity::class.java)
            b.putInt("key", 4)
            intent.putExtras(b)
            startActivity(intent)
        }
    }
}
