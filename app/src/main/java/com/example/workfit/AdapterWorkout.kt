package com.example.workfit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView

class AdapterWorkout(private val workoutItemList: List<WorkoutItem>) :
    RecyclerView.Adapter<AdapterWorkout.ViewHolder>() {
    private var onItemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.workout_activity_items, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = workoutItemList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return workoutItemList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemImageView: LottieAnimationView = itemView.findViewById(R.id.lavExercise)
        private val itemTextView: TextView = itemView.findViewById(R.id.text)

        fun bind(workoutItem: WorkoutItem) {
            itemImageView.setAnimation(workoutItem.lottieId)
            itemTextView.text = workoutItem.name
        }
        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                onItemClickListener?.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.onItemClickListener = listener
    }

}


