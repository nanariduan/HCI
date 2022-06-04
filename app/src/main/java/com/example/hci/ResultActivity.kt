package com.example.hci

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.hci.databinding.HomepageBinding
import com.example.hci.databinding.ResultBinding

class ResultActivity:AppCompatActivity() {
    lateinit var binding: ResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}