package com.example.hci

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.hci.databinding.LoginBinding

class LoginActivity:AppCompatActivity() {
    lateinit var binding: LoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initLayout()
    }

    private fun initLayout(){
        val log = findViewById<Button>(R.id.logbtn)
        val username = findViewById<EditText>(R.id.usernametxt)
        var user = username.getText().toString()
        val passwd = findViewById<EditText>(R.id.passwdtxt)
        var pw = passwd.getText().toString()

        log.setOnClickListener {
            //if (user!="" && pw!="") {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
           // }
        }


    }
}