package com.example.workfit

import  androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.VideoView

class Cardio : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    private lateinit var startButton: Button
    private lateinit var videoView: VideoView

    private lateinit var timeTextView: TextView
    private lateinit var timeRemainingTextView: TextView
    private lateinit var cardioExName: TextView

    private val videoResources = arrayOf(
        R.raw.squats,
        R.raw.mountain,
        R.raw.something ,
        R.raw.standinglunges,
        R.raw.kuchto,
        R.raw.skiprope,
        R.raw.squatjump,
        R.raw.running,
        R.raw.burpees,
        R.raw.jumprope,

    )
    private val exerciseNames = arrayOf("Squats", "Mountain Climbers", "Something", "Standing Lunges","Kuch to h","Skip Rope","Squat Jump","Running in place","Burpees","Jump Rope")


    private var currentVideoIndex = 0
    private var countdownTimer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cardio)

        progressBar = findViewById(R.id.progressBar)
        startButton = findViewById(R.id.startButton)
        videoView = findViewById(R.id.cardioVideo)

        timeTextView = findViewById(R.id.timeTextView)
         timeRemainingTextView= findViewById(R.id.timeRemainingTextView)
        cardioExName = findViewById(R.id.cardioExName)

        startButton.setOnClickListener {
            startButton.isEnabled = false
            countdownTimer?.cancel()
            countdownTimer = createCountDownTimer()
            countdownTimer?.start()
        }
    }

    private fun createCountDownTimer(): CountDownTimer {
        return object : CountDownTimer(40000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val secondsRemaining = (millisUntilFinished / 1000).toInt()
                val minutes = secondsRemaining / 60
                val seconds = secondsRemaining % 60
                val timeString = String.format("%02d:%02d", minutes, seconds)
                timeTextView.text = timeString
                if (millisUntilFinished <= 10000) {
                    timeRemainingTextView.text = "Wind Down"
                }

                val progress = millisUntilFinished.toInt()
                progressBar.progress = progress
            }

            override fun onFinish() {
                progressBar.progress = 0
                startButton.isEnabled = true
                changeVideo()
                timeRemainingTextView.text = "Time Remaining"
            }
        }
    }

    private fun changeVideo() {
        if (currentVideoIndex < videoResources.size - 1) {
            currentVideoIndex++
        } else {
            currentVideoIndex = 0
        }
        val videoPath = "android.resource://${packageName}/${videoResources[currentVideoIndex]}"
        videoView.setVideoPath(videoPath)
        videoView.setOnPreparedListener { mediaPlayer ->
            // Set the looping property to true
            mediaPlayer.isLooping = true
            // Start playing the video
            mediaPlayer.start()
        }
        videoView.setOnCompletionListener { mediaPlayer ->
            // Restart the video playback when it reaches the end
            mediaPlayer.start()
        }
        cardioExName.text = exerciseNames[currentVideoIndex]
    }
    }




