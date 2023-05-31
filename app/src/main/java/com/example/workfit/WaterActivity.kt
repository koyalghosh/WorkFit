package com.example.workfit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import com.airbnb.lottie.LottieAnimationView
import com.example.workfit.databinding.ActivityWaterBinding

class WaterActivity : AppCompatActivity() {
    private var binding: ActivityWaterBinding?= null

    var waterText : TextView ?= null

    private val handler = Handler(Looper.getMainLooper())
    private var currentIndex = 0
    private val texts = arrayOf("Stay hydrated and let your inner brilliance flow.",
        "Water: Your body's superhero fuel for vitality and well-being.",
        "Hydrate like a champion and unlock your limitless potential.",
        "Quench your thirst, nourish your body, and conquer the day!",
        "Stay hydrated: the secret elixir for a vibrant, energized life."
    )
    private val interval = 5000L // milliseconds

    //function for changing text in water text
    private val runnable = object : Runnable {
        override fun run() {
            // Update the text in the TextView
            waterText?.text = texts[currentIndex]

            // Increment the index or reset if it exceeds the array length
            currentIndex = (currentIndex + 1) % texts.size

            // Schedule the next execution after the interval
            handler.postDelayed(this, interval)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWaterBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        //for changing text in water_text
        handler.postDelayed(runnable, interval)
        waterText = findViewById(R.id.drink_water_text)

            var tvCount: TextView = findViewById(R.id.tvCount)
            var timesClicked = 0
            binding?.flStart?.setOnClickListener {
                timesClicked += 1
                tvCount.text = "$timesClicked/10 Glass"
                if (timesClicked > 10) {
                    Toast.makeText(this, "Daily Goal Completed, Stay Hydrated !", Toast.LENGTH_LONG)
                        .show()
                } else {
                    if (timesClicked == 1)
                        binding?.glass1?.playAnimation()
                    if (timesClicked == 2)
                        binding?.glass2?.playAnimation()
                    if (timesClicked == 3)
                        binding?.glass3?.playAnimation()
                    if (timesClicked == 4)
                        binding?.glass4?.playAnimation()
                    if (timesClicked == 5)
                        binding?.glass5?.playAnimation()
                    if (timesClicked == 6)
                        binding?.glass6?.playAnimation()
                    if (timesClicked == 7)
                        binding?.glass7?.playAnimation()
                    if (timesClicked == 8)
                        binding?.glass8?.playAnimation()
                    if (timesClicked == 9)
                        binding?.glass9?.playAnimation()
                    if (timesClicked == 10)
                        binding?.glass10?.playAnimation()
                }
            }
        }

        //for water_text
        override fun onDestroy() {
            super.onDestroy()
            // Remove any pending callbacks to prevent memory leaks
            handler.removeCallbacks(runnable)
        }
    }