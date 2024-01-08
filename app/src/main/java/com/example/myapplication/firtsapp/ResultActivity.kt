package com.example.myapplication.firtsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatTextView
import com.example.myapplication.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tresult = findViewById<AppCompatTextView>(R.id.tresult)
        val name: String  = intent.extras?.getString("ExtraName").orEmpty()
        tresult.text = "Hola $name"
    }
}