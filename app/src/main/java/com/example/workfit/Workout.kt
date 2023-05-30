package com.example.workfit

import android.content.ClipData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Workout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        val items: List<ClipData.Item> = listOf(
            ClipData.Item("Item 1")
        )
        val adapter: RecyclerView.Adapter<*> = AdapterWorkout(items)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

    }
}