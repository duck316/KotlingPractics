package com.example.myapplication.taskapp

import android.content.res.ColorStateList
import android.graphics.Paint
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class TasksViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val tvTask: TextView = view.findViewById(R.id.tvTasks)
    private val CheckBoxTask: CheckBox = view.findViewById(R.id.CheckBoxTask)


    fun render(task: ObjTask) {

        if (task.isSelected) {
            tvTask.paintFlags = tvTask.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            tvTask.paintFlags = tvTask.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }

        CheckBoxTask.isChecked = task.isSelected
        tvTask.text = task.name

        val colorit = when (task.category){
            TaskCategory.Negocios -> R.color.todo_business_category
            TaskCategory.Otros -> R.color.todo_other_category
            TaskCategory.Personal -> R.color.todo_personal_category
        }
        CheckBoxTask.buttonTintList = ColorStateList.valueOf(
            ContextCompat.getColor(CheckBoxTask.context, colorit)
        )

    }
}