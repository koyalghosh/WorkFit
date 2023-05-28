package com.example.workfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import java.text.DecimalFormat

class BmiCalc : AppCompatActivity() {
    var switch: Switch ?= null
    var cm: TextView ?= null
    var inch : TextView ?= null
    var kg : TextView ?= null
    var etInch : EditText ?= null
    var btnCal : Button?= null
    var etCm : EditText?= null
    var etKg : EditText?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi_calc)

        switch = findViewById(R.id.switchButton)
        cm = findViewById(R.id.cm)
        inch = findViewById(R.id.inch)
        kg = findViewById(R.id.kg)
        etInch = findViewById(R.id.numInch)
        btnCal = findViewById(R.id.calcBMI)
        etCm = findViewById(R.id.txtCm)
        etKg = findViewById(R.id.txtKg)

        btnCal?.setOnClickListener {
            var height: Float? = null
            var weight:Float? = null
            var bmi:Float? = null
            if(etInch?.visibility == View.INVISIBLE && kg?.text == "kg"){
                height = etCm?.text.toString().toFloat()
                weight = etKg?.text.toString().toFloat()
                height /= 100
                bmi = weight/(height*height)
                val intent = Intent(this,BMIresult::class.java)
                intent.putExtra("bmi",DecimalFormat("##.#").format(bmi))
                startActivity(intent)
                //Toast.makeText(this, DecimalFormat("##.#").format(bmi),Toast.LENGTH_LONG).show()
            }else{
                //feet-inch to m
                height = etCm?.text.toString().toFloat()
                var inch = etInch?.text.toString().toFloat()
                var temp = (height*30.48f) + (inch * 2.54f)
                temp /= 100
                weight = etKg?.text.toString().toFloat()
                weight *= 0.454f
                bmi = weight/(temp*temp)

                val intent = Intent(this,BMIresult::class.java)
                intent.putExtra("bmi",DecimalFormat("##.#").format(bmi))
                startActivity(intent)
            }
        }

        switch?.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                cm?.text = "ft"
                inch?.setVisibility(View.VISIBLE)
                kg?.text = "lbs"
                etInch?.setVisibility(View.VISIBLE)
            }else{
                cm?.text = "cm"
                inch?.setVisibility(View.INVISIBLE)
                kg?.text = "kg"
                etInch?.setVisibility(View.INVISIBLE)
            }
        }

    }
}