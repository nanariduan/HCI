package com.example.hci

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.hci.databinding.LoginBinding
import java.util.*
import kotlin.collections.ArrayList

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
        val passwd = findViewById<EditText>(R.id.passwdtxt)

        var arrname=ArrayList<String>()
        var arrpass=ArrayList<String>()


      //  val scan = Scanner(resources.openRawResource(R.raw.logininfo))
        val scan =Scanner(openFileInput("out.txt"))

       while(scan.hasNextLine()) {
            val lines = scan.nextLine()
            val info = lines.split(" ")
            val name = info[0]
            val pass = info[1]
            arrname.add(name)
            arrpass.add(pass)

        }

        log.setOnClickListener {

            var user = username.getText().trim().toString()
            var pw = passwd.getText().trim().toString()
            var nextPage: Boolean


            arrname.zip(arrpass){arrname,arrpass->(if (user.equals(arrname) && pw.equals(arrpass)){
                val b = Bundle()
                val intent = Intent(this, MainActivity::class.java)
                b.putString("name",user)
                intent.putExtras(b)
                      startActivity(intent)
                nextPage = true
             }
            else nextPage = false)

                if (nextPage == false)  {
                Toast.makeText(this, "Wrong id or password. Try again. ", Toast.LENGTH_LONG).show()
                //nextPage = true

                    //toast xjadi
            }
        }

        }

    }
}