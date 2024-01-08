package com.example.myapplication.taskapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.taskapp.TaskCategory.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.text.FieldPosition

class TaskApp : AppCompatActivity() {

    private val Category = listOf(
        Negocios,
        Personal,
        Otros
    )

    private val tasks = mutableListOf(
        ObjTask("Test Negocios", Negocios),
        ObjTask("Test Personal", Personal),
        ObjTask("Test Otro", Otros),
    )

    private lateinit var ReViewCategory: RecyclerView
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var ReViewTask:  RecyclerView
    private lateinit var TaskAdapter: TaskAdapter
    private lateinit var AddTask: FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_app)

        initcomponet()
        initUI()
        initListener()
    }

    private fun initListener(){
        AddTask.setOnClickListener {showDialog()

        }
    }
    private fun showDialog(){
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)

        val EditTask: EditText= dialog.findViewById(R.id.EditTask)
        val btnAddTask: Button = dialog.findViewById(R.id.BtAddTask)
        val RGCategory: RadioGroup = dialog.findViewById(R.id.RGCategory)

        btnAddTask.setOnClickListener {

            val currenttask = EditTask.text.toString()
            if(currenttask.isNotEmpty()){
                val selecterid = RGCategory.checkedRadioButtonId
                val SelecterRadioButton = RGCategory.findViewById<RadioButton>(selecterid)
                val CurrentCategory: TaskCategory = when(SelecterRadioButton.text){
                    "Negocio" -> Negocios
                    "Personal" -> Personal
                    else -> Otros
                }

                tasks.add(ObjTask(EditTask.text.toString(), CurrentCategory))
                UpdateTask()
                dialog.hide()
            }

        }
        dialog.show()

    }

    private fun initcomponet(){
        ReViewCategory = findViewById(R.id.ReViewCategory)
        ReViewTask = findViewById(R.id.ReViewTask)
        AddTask = findViewById(R.id.AddTask)
    }

    private fun initUI(){
        categoryAdapter = CategoryAdapter(Category) {position -> UpdateCategory(position)}
        ReViewCategory.layoutManager= LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        ReViewCategory.adapter = categoryAdapter

        TaskAdapter = TaskAdapter(tasks) {position -> onItemSelected(position)}
        ReViewTask.layoutManager= LinearLayoutManager(this)
        ReViewTask.adapter = TaskAdapter

    }

    private fun onItemSelected(position: Int){
        tasks[position].isSelected = !tasks[position].isSelected
        UpdateTask()
    }

    private fun UpdateCategory(position: Int){
        Category[position].isSelected = !Category[position].isSelected
        categoryAdapter.notifyItemChanged(position)
        UpdateTask()

    }

    private fun UpdateTask(){
        val selectedCategories: List<TaskCategory> = Category.filter { it.isSelected }
        val newtask = tasks.filter { selectedCategories.contains(it.category) }
        TaskAdapter.tasks = newtask
        TaskAdapter.notifyDataSetChanged()
    }
}