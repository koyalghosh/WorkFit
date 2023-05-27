package com.example.workfit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.airbnb.lottie.LottieAnimationView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val flStartButton : FrameLayout = findViewById(R.id.flStart)
        val animationView: LottieAnimationView = findViewById(R.id.animationView)
        var tvCount : TextView = findViewById(R.id.tvCount)
        var timesClicked = 0
        flStartButton.setOnClickListener{
            animationView.playAnimation()
            timesClicked = timesClicked + 100
            tvCount.text = "$timesClicked/3000 ml"
            if (timesClicked >= 3000) {
                Toast.makeText(this, "Daily Goal Completed, Stay Hydrated !", Toast.LENGTH_LONG).show()
            }
        }
    }
}