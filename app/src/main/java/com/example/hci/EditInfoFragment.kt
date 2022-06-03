package com.example.hci

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.hci.databinding.EditInfoBinding
import java.util.*
import kotlin.collections.ArrayList

class EditInfoFragment :Fragment(){
    private lateinit var binding: EditInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = EditInfoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nameinfo2 = binding.root.findViewById<TextView>(R.id.nameinfo)
        val weightinfo2 = binding.root.findViewById<TextView>(R.id.weightinfo)
        val ageinfo2 = binding.root.findViewById<TextView>(R.id.ageinfo)
        val heightinfo2 = binding.root.findViewById<TextView>(R.id.heightinfo)

        val scan =Scanner(activity?.openFileInput("out.txt"))

        while(scan.hasNextLine()) {
            val lines = scan.nextLine()
            val info = lines.split(" "," "," "," ")

            val user = info[0]
            val age = info[3]
            val weight = info[2]
            val height = info[4]

            nameinfo2.setText(user).toString()
            weightinfo2.setText(weight).toString()
            ageinfo2.setText(age).toString()
            heightinfo2.setText(height).toString()

        }

        init()
    }

    private fun init(){
        val btn =  binding.root.findViewById<Button>(R.id.regisbtn2)


        btn.setOnClickListener {


            val intent = Intent(this@EditInfoFragment.context, Edit1Activity::class.java)
            startActivity(intent)
        }
    }

}
