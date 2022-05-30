package com.example.hci

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.hci.databinding.EditInfoBinding

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
