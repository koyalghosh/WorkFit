package com.example.workfit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.airbnb.lottie.LottieAnimationView
import com.example.workfit.databinding.ActivityWaterBinding

class WaterActivity : AppCompatActivity() {
    private var binding: ActivityWaterBinding?= null
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_water)

        val tvCount : TextView? = findViewById(R.id.tvCount)
        var timesClicked = 0
        binding?.flStart?.setOnClickListener{
            timesClicked += 1
            tvCount?.text = "$timesClicked/10 Glass"
            if (timesClicked > 10) {
                Toast.makeText(this, "Daily Goal Completed, Stay Hydrated !", Toast.LENGTH_LONG).show()
            }
            else{
                if(timesClicked==1)
                    binding?.glass1?.playAnimation()
                if(timesClicked==2)
                    binding?.glass2?.playAnimation()
                if(timesClicked==3)
                    binding?.glass3?.playAnimation()
                if(timesClicked==4)
                    binding?.glass4?.playAnimation()
                if(timesClicked==5)
                    binding?.glass5?.playAnimation()
                if(timesClicked==6)
                    binding?.glass6?.playAnimation()
                if(timesClicked==7)
                    binding?.glass7?.playAnimation()
                if(timesClicked==8)
                    binding?.glass8?.playAnimation()
                if(timesClicked==9)
                    binding?.glass9?.playAnimation()
                if(timesClicked==10) {
                    binding?.glass10?.playAnimation()
                    Toast.makeText(this, "Daily Goal Completed, Stay Hydrated !", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}