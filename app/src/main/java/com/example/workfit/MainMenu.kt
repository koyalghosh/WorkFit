package com.example.workfit

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.airbnb.lottie.LottieAnimationView
import com.google.android.material.navigation.NavigationView


class MainMenu : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    var txtQuote: TextView ?= null
    var ibWater: LottieAnimationView ?=null
    var ibBMI: LottieAnimationView ?= null
    var ibWorkout: LottieAnimationView ?= null
    var ibDiet : LottieAnimationView ?=null

    lateinit var drawerLayout: DrawerLayout
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    var navView: NavigationView ?= null

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
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        drawerLayout = findViewById(R.id.my_drawer_layout)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navOpen, R.string.navClose)
        actionBarDrawerToggle.isDrawerIndicatorEnabled = true

        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        navView = findViewById(R.id.nav_view)
        navView?.setNavigationItemSelectedListener(this)


        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        handler.postDelayed(runnable, interval)

        txtQuote = findViewById(R.id.quote)
        ibWater = findViewById(R.id.water)
        ibBMI = findViewById(R.id.bmi)
        ibWorkout = findViewById(R.id.workout)
        ibDiet = findViewById(R.id.diet)

        ibWater?.setOnClickListener {
            val intent = Intent(this,WaterActivity::class.java)
            startActivity(intent)
        }
        ibBMI?.setOnClickListener {
            val intent = Intent(this,BmiCalc::class.java)
            startActivity(intent)
        }
        ibWorkout?.setOnClickListener {
            intent = Intent(this,Workout::class.java)
            startActivity(intent)
        }
        ibDiet?.setOnClickListener {
            Toast.makeText(this,"Diet",Toast.LENGTH_LONG).show()
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }
    override fun onDestroy() {
        super.onDestroy()
        // Remove any pending callbacks to prevent memory leaks
        handler.removeCallbacks(runnable)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_profile -> Toast.makeText(this,"Profile Page (TODO)",Toast.LENGTH_SHORT).show()
            R.id.nav_water -> startActivity(Intent(this,WaterActivity::class.java))
            R.id.nav_bmi -> startActivity(Intent(this,BmiCalc::class.java))
            R.id.nav_workout -> startActivity(Intent(this,Workout::class.java))
            R.id.nav_diet -> Toast.makeText(this,"Diet Page (TODO)",Toast.LENGTH_SHORT).show()
            R.id.nav_logout -> Toast.makeText(this,"Logout (TODO)",Toast.LENGTH_SHORT).show()
        }
        val drawer : DrawerLayout = findViewById(R.id.my_drawer_layout)
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}