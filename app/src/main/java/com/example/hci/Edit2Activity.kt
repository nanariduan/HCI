package com.example.hci

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.hci.databinding.Edit2Binding

class Edit2Activity:AppCompatActivity() {
    lateinit var binding: Edit2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Edit2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        initLayout()
    }

    private fun initLayout(){
        val next = binding.root.findViewById<Button>(R.id.button)

        next.setOnClickListener {
            //if (user!="" && pw!="") {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
           // }
        }


    }
}