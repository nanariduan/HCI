package com.example.hci

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.hci.databinding.LoginBinding
import com.example.hci.databinding.Register2Binding

class Register2Activity:AppCompatActivity() {
    lateinit var binding: Register2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Register2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        initLayout()
    }

    private fun initLayout(){
        val next = findViewById<Button>(R.id.regisbtn)

        next.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}