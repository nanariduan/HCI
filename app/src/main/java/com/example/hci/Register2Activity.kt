package com.example.hci

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.hci.databinding.Register2Binding
import java.io.*

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

        val username   = findViewById<EditText>(R.id.usernametxt)
        val password = findViewById<EditText>(R.id.passwdtxt)
        val weight = findViewById<EditText>(R.id.weighttxt)
        val height = findViewById<EditText>(R.id.heighttxt)


        next.setOnClickListener {


            val intent = Intent(this, MainActivity::class.java)
           startActivity(intent)

        }

    }
}