package com.example.workfit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class BMIresult : AppCompatActivity() {
    var txtBMI : TextView ?= null
    var imgBMI : ImageView?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmiresult)

        val receivedValue = intent.getStringExtra("bmi")

        txtBMI = findViewById(R.id.txtBMI)
        imgBMI = findViewById(R.id.imgBMI)

        txtBMI?.text = "Your BMI is " + receivedValue

        if(receivedValue?.toFloat()!! < 18.0f){
            imgBMI?.setImageResource(R.drawable.underweight_bmi)
        }else if(receivedValue?.toFloat()!! <= 24.9f){
            imgBMI?.setImageResource(R.drawable.normal_bmi)
        }else if(receivedValue?.toFloat()!! <= 29.9f){
            imgBMI?.setImageResource(R.drawable.overweight_bmi)
        }else{
            imgBMI?.setImageResource(R.drawable.obesity_bmi)
        }
    }
}