package com.example.hci

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.hci.databinding.Register1Binding
import java.io.File
import java.io.PrintStream
import java.io.PrintWriter

class Register1Activity:AppCompatActivity() {
    lateinit var binding: Register1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Register1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        initLayout()
    }

    private fun initLayout(){
        val next = findViewById<ImageButton>(R.id.nextbtn)
        val username   = findViewById<EditText>(R.id.usernametxt)
       val password = findViewById<EditText>(R.id.passwdtxt)
        val age = findViewById<EditText>(R.id.agetxt)
       val weight = findViewById<EditText>(R.id.weighttxt)
        val height = findViewById<EditText>(R.id.heighttxt)


        next.setOnClickListener {

            var user = username.getText().trim().toString()
            var pass = password.getText().trim().toString()
            var age2 = age.getText().trim().toString()
            var weight2 = weight.getText().trim().toString()
            var height2 = height.getText().trim().toString()

            val output = PrintStream(openFileOutput("out.txt", MODE_APPEND))
            //output.println()
            output.println(user+" "+pass+" "+weight2+" "+age2+" "+height2)
            output.close()

            val intent = Intent(this, Register2Activity::class.java)
            startActivity(intent)
        }

    }
}