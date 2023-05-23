package com.example.workfit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest

class MainActivity : AppCompatActivity() {
    var tvSignIn : TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_main)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)

        tvSignIn = findViewById(R.id.signUp)
        tvSignIn?.setOnClickListener{
            Toast.makeText(this,"Hello",Toast.LENGTH_LONG).show()
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
    private suspend fun getData(){
        val client = getClient()
        val supabaseResponse = client.postgrest["Users"].select()
    }
}