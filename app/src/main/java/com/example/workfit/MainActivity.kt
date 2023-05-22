package com.example.workfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {
    var tvSignIn : TextView?=null
    var tvSignUp: Button ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)

        tvSignIn = findViewById(R.id.signIn)
        tvSignUp = findViewById(R.id.signUp)

        tvSignIn?.setOnClickListener{
            Toast.makeText(this,"Hello",Toast.LENGTH_LONG).show()
        }

        tvSignUp?.setOnClickListener {
            intent = Intent(this,BmiCalc::class.java)
            startActivity(intent)
        }
    }
}