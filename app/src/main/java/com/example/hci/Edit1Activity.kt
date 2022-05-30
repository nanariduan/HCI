package com.example.hci

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.hci.databinding.Edit1Binding

class Edit1Activity:AppCompatActivity() {
    lateinit var binding: Edit1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Edit1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        initLayout()
    }

    private fun initLayout(){
        val next = findViewById<ImageButton>(R.id.nextbtn)

        next.setOnClickListener {
                val intent = Intent(this, Edit2Activity::class.java)
                startActivity(intent)
        }

    }
}