package com.example.hci

import android.app.ActionBar
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlin.math.pow

class BMIFragment :Fragment(){


//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.bmi, container, false)
    override fun onCreate(savedInstanceState:Bundle?){
    super.onCreate(savedInstanceState)
    setContentView(R.layout.bmi)
    supportActionBar.hide()
    val weight = findViewByID<EditText>(R.id.weight)
    val height = findViewByID<EditText>(R.id.height)
    val calc = findViewByID<Button>(R.id.calculate)
    val cat = findViewByID<TextView>(R.id.bmicat)
    val bmiStatus = findViewByID<TextView>(R.id.bmistatus)
    val bmiReview = findViewByID<TextView>(R.id.review)
    val save = findViewByID<TextView>(R.id.save)

        calc.setOnCLickListener{
            var weightValue = 0.0
            var heightValue = 0.0
            if (weight.text.toString().isNotEmpty()){
                weightValue = weight.text.toString().toDouble()
            }
            if (height.text.toString().isNotEmpty()){
                heightValue = height.text.toString().toDouble()
            }
            if(weightValue > 0.0 && heightValue > 0.0) {
                val bmiValue = String.format("Your Body Mass Index is %.2f", weightValue/heightValue.pow(n:2))
                bmiStatus.text =bmiValue
                bmiReview.text = bmiStatusVal(weightValue/heightValue.pow(n:2))
                bmiStatus.visibility = VISIBLE
                bmiReview.visibility = VISIBLE
            }
            else
                Toast.makeText(context:this,"Please input weight and height values greater than 0",Toast.LENGTH_LONG.show())
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
