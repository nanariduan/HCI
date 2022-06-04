package com.example.hci

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.hci.databinding.BmiBinding
import com.google.android.material.textfield.TextInputEditText
import kotlin.math.pow
import kotlin.math.roundToInt

class BMIFragment :Fragment(){
    private lateinit var binding: BmiBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BmiBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val weight2  = binding.root.findViewById<TextInputEditText>(R.id.weight)
        val height2 = binding.root.findViewById<TextInputEditText>(R.id.height)
        val calc = binding.root.findViewById<Button>(R.id.calculate)
        val bmistatus2 = binding.root.findViewById<TextView>(R.id.bmistatus)
        val bmireview2 = binding.root.findViewById<TextView>(R.id.bmireview)
        val linlay2 = binding.root.findViewById<LinearLayout>(R.id.linlay)

        linlay2.visibility = View.GONE
        calc.setOnClickListener{
            var weightValue = 0.0
            var heightValue = 0.0
            if (weight2.text.toString().isNotEmpty()){
                weightValue = weight2.text.toString().toDouble()
            }
            if (height2.text.toString().isNotEmpty()){
                heightValue = height2.text.toString().toDouble()
            }
            if(weightValue > 0.0 && heightValue > 0.0) {
                var bmiValue =  weightValue / ((heightValue/100).pow(2.0))
                bmistatus2.setText("Your BMI is "+((bmiValue*100.0).roundToInt()/100.0).toString())
                linlay2.visibility = View.VISIBLE

                bmireview2.text = bmiStatusVal(bmiValue)

            }
            else {
                Toast.makeText(activity, "Please input weight and height values greater than 0", Toast.LENGTH_SHORT).show()
            }

        }

    }
    private fun bmiStatusVal(bmi: Double) : String {
        lateinit var bmiReview : String
        if(bmi <18.5)
            bmiReview = "This is considered underweight."
        else if (bmi >=18.5 && bmi <25)
            bmiReview ="This is considered normal."
        else if (bmi >=25 && bmi <30)
            bmiReview ="This is considered overweight."
        if(bmi >30)
            bmiReview = "This is considered obese."
        return bmiReview
    }

}
