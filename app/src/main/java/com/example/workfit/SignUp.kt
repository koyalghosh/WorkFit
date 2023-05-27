package com.example.workfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SignUp : AppCompatActivity() {
    var user : EditText ?= null
    var email : EditText ?= null
    var pass : EditText ?= null
    var cpass : EditText ?= null
    var createAcc : Button ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        user = findViewById(R.id.uname)
        email = findViewById(R.id.email)
        pass = findViewById(R.id.pass)
        cpass = findViewById(R.id.cpass)
        createAcc = findViewById(R.id.createAcc)

        createAcc?.setOnClickListener {
            intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}