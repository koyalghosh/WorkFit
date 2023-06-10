package com.example.workfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Workout : AppCompatActivity() ,AdapterWorkout.OnItemClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val workoutItemLists = listOf(
            WorkoutItem(R.raw.cardio, "Cardio"),
            WorkoutItem(R.raw.gym_exercise, "Gym"),
            WorkoutItem(R.raw.yoga, "Yoga"),
            WorkoutItem(R.raw.home_workout, "Home Workout")
        )
        val adapter = AdapterWorkout(workoutItemLists)
        adapter.setOnItemClickListener(this)
        recyclerView.adapter = adapter


    }
    override fun onItemClick(position: Int) {
        // Handle the click event
        // For example, show the index of the clicked item
        if(position == 0){
            intent = Intent(this,Cardio::class.java)
            startActivity(intent)
        }else if(position == 1){
            intent = Intent(this,Gym::class.java)
            startActivity(intent)
        }else if(position == 2){
            intent = Intent(this,Yoga::class.java)
            startActivity(intent)
        }else{
            intent = Intent(this,HomeWorkout::class.java)
            startActivity(intent)
        }
    }
}