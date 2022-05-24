package com.example.hci

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.hci.databinding.HomepageBinding

class HomepageActivity:AppCompatActivity() {
    lateinit var binding:HomepageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initLayout()
    }

    private fun initLayout(){
        val login = findViewById<Button>(R.id.loginbtn)
        val reg = findViewById<Button>(R.id.regbtn)

        login.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        reg.setOnClickListener {
            val intent = Intent(this, Register1Activity::class.java)
            startActivity(intent)
        }

    }



}