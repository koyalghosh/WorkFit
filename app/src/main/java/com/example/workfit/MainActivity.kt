package com.example.workfit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Returning

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    var tvSignUp : TextView ?= null
    var login : Button ?= null
    lateinit var email : EditText
    lateinit var password : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_main)

        email = findViewById(R.id.edEmail)
        password = findViewById(R.id.edPass)

        login = findViewById(R.id.login)
        login?.setOnClickListener {
//            val id = email.text.toString()
//            val pass = password.text.toString()
//            signUp(id,pass)
            intent = Intent(this,MainMenu::class.java)
            startActivity(intent)
            finish()
        }
        tvSignUp = findViewById(R.id.signUp)
        tvSignUp?.setOnClickListener{
            intent = Intent(this,SignUp::class.java)
            startActivity(intent)
        }

    }
    private fun signUp(id: String,password: String) {
        val client = getClient()
        val user = User(id = id, password = password)
        try {
            runBlocking {
                launch(Dispatchers.IO) {
                    client.postgrest["users"].insert(
                        user,
                        returning = Returning.MINIMAL
                    ) //returning default to Returning.REPRESENTATION
                }
            }
        }catch(e : Exception){
            e.printStackTrace()
        }
    }
    private fun getClient() : SupabaseClient {
        return createSupabaseClient(
            supabaseUrl = "https://zajjdxpibjsgjvbtsfbi.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InphampkeHBpYmpzZ2p2YnRzZmJpIiwicm9sZSI6ImFub24iLCJpYXQiOjE2ODQ3MzEwODQsImV4cCI6MjAwMDMwNzA4NH0.miRnfnMiHy0fkvGVlBjKE80dHceu6El8JLW1xLSsEaI"
        ){
            install(Postgrest)
        }
    }
}
@kotlinx.serialization.Serializable
data class User(
    val id: String,
    val password: String
)