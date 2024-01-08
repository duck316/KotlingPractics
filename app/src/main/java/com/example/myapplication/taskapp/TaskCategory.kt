package com.example.myapplication.taskapp

sealed class TaskCategory(var isSelected: Boolean = true) {
    object Personal :TaskCategory()
    object Negocios :TaskCategory()
    object Otros :TaskCategory()
}