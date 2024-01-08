package com.example.myapplication.taskapp

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val TvCategoryName: TextView = view.findViewById(R.id.CategoryText)
    private val divide: View = view.findViewById(R.id.divide)
    private val ViewConteiner: CardView = view.findViewById(R.id.ViewConteiner)



    fun render(taskCategory: TaskCategory, onItemSelected: (Int) -> Unit) {

        val color = if (taskCategory.isSelected) {
            R.color.todo_background_card
        } else {
            R.color.todo_background_disabled
        }

        ViewConteiner.setCardBackgroundColor(ContextCompat.getColor(ViewConteiner.context, color))

        itemView.setOnClickListener { onItemSelected(layoutPosition) }

        when (taskCategory) {
            TaskCategory.Negocios -> {
                TvCategoryName.text = "Negocios"
                divide.setBackgroundColor(
                    ContextCompat.getColor(divide.context, R.color.todo_business_category)
                )
            }

            TaskCategory.Otros -> {
                TvCategoryName.text = "Otros"
                divide.setBackgroundColor(
                    ContextCompat.getColor(divide.context, R.color.todo_other_category)
                )
            }

            TaskCategory.Personal -> {
                TvCategoryName.text = "Personal"
                divide.setBackgroundColor(
                    ContextCompat.getColor(divide.context, R.color.todo_personal_category)
                )
            }
        }

    }
}