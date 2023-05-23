package com.example.workfit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast

class BmiCalc : AppCompatActivity() {
    var switch: Switch ?= null
    var cm: TextView ?= null
    var inch : TextView ?= null
    var kg : TextView ?= null
    var inchText : EditText ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi_calc)

        switch = findViewById(R.id.switchButton)
        cm = findViewById(R.id.cm)
        inch = findViewById(R.id.inch)
        kg = findViewById(R.id.kg)
        inchText = findViewById(R.id.numInch)

        switch?.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                cm?.text = "feet"
                inch?.setVisibility(View.VISIBLE)
                kg?.text = "pounds"
                inchText?.setVisibility(View.VISIBLE)
            }else{
                cm?.text = "cm"
                inch?.setVisibility(View.INVISIBLE)
                kg?.text = "kg"
                inchText?.setVisibility(View.INVISIBLE)
            }
        }

    }
}