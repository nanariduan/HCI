package com.example.hci

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.hci.databinding.HomepageBinding
import java.io.File

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
            if(checkIfFileExists()) {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
            else{
                val builder = AlertDialog.Builder(this@HomepageActivity)
                builder!!.setMessage("No Registered Account Available")
                    .setTitle("Log In")

                builder.apply {
                    setPositiveButton("OK") { dialog, id ->
                        val selectedId = id
                    val intent = Intent(this@HomepageActivity, Register1Activity::class.java)
                    startActivity(intent)
                    }
                    setNegativeButton("CANCEL") { dialog, id ->
                        val selectedId = id

                    }
                }
                val dialog: AlertDialog? = builder.create()

                dialog!!.show()
            }
        }

        reg.setOnClickListener {
            val intent = Intent(this, Register1Activity::class.java)
            startActivity(intent)
        }

    }

    fun checkIfFileExists():Boolean {
        val fileName2 = "out.txt"
        var file = File(getFilesDir().getAbsolutePath(), fileName2)
        var fileExists = file.exists()


        if(fileExists) {
            return true
        }
        else {
            return false
        }

    }



}