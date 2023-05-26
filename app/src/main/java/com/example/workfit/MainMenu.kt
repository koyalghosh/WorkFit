package com.example.workfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageButton
import android.widget.TextView

class MainMenu : AppCompatActivity() {
    var txtQuote: TextView ?= null
    var ibWater: ImageButton ?=null
    var ibBMI: ImageButton ?= null
    var ibWorkout: ImageButton ?= null
    var ibDiet : ImageButton ?=null

    private val handler = Handler(Looper.getMainLooper())
    private var currentIndex = 0
    private val texts = arrayOf("“I hated every minute of training, but I said, ‘Don’t quit. Suffer now and live the rest of your life as a champion.” \n– Muhammad Ali",
        "“Yoga is not about touching your toes, it’s about what you learn on the way down.” \n— Jigar Gor",
        "“The hard days are the best because that’s when champions are made, so if you push through, you can push through anything.” \n– Dana Vollmer"
    )
    private val interval = 5000L // milliseconds

    private val runnable = object : Runnable {
        override fun run() {
            // Update the text in the TextView
            txtQuote?.text = texts[currentIndex]

            // Increment the index or reset if it exceeds the array length
            currentIndex = (currentIndex + 1) % texts.size

            // Schedule the next execution after the interval
            handler.postDelayed(this, interval)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        handler.postDelayed(runnable, interval)

        txtQuote = findViewById(R.id.quote)
        ibWater = findViewById(R.id.water)
        ibBMI =findViewById(R.id.bmi)
        ibWorkout = findViewById(R.id.workout)
        ibDiet = findViewById(R.id.diet)

        ibWater?.setOnClickListener {

        }
        ibBMI?.setOnClickListener {
            intent = Intent(this,BmiCalc::class.java)
            startActivity(intent)
        }
        ibWorkout?.setOnClickListener {

        }
        ibDiet?.setOnClickListener {

        }

    }
    override fun onDestroy() {
        super.onDestroy()
        // Remove any pending callbacks to prevent memory leaks
        handler.removeCallbacks(runnable)
    }
}