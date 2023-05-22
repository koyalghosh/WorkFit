package com.example.workfit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

class BmiCalc : AppCompatActivity() {
    var dropDown: Spinner? = null
    var dropDown2: Spinner?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi_calc)

        val height = resources.getStringArray(R.array.height_unit)
        val weight = resources.getStringArray(R.array.weight_unit)
        dropDown = findViewById(R.id.dropdown)
        dropDown2 = findViewById(R.id.dropdown2)

        if (dropDown != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, height
            )
            dropDown?.adapter = adapter
            dropDown?.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    Toast.makeText(this@BmiCalc, "Selected", Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
        }
        if (dropDown2 != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, weight
            )
            dropDown2?.adapter = adapter
            dropDown2?.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    Toast.makeText(this@BmiCalc, "Selected", Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
        }
    }
}