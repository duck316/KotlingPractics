package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.example.myapplication.ImcApp.ImcAppActivity
import com.example.myapplication.firtsapp.MyFirtsAppActyvity
import com.example.myapplication.taskapp.TaskApp

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val BtnWelApp = findViewById<AppCompatButton>(R.id.WelApp)
        val BtnImcApp = findViewById<AppCompatButton>(R.id.ImcApp)
        val BtnTaskApp = findViewById<AppCompatButton>(R.id.TaskButton)

        BtnWelApp.setOnClickListener {navigationtoWelcome()}
        BtnImcApp.setOnClickListener {navigationtoImcApp()}
        BtnTaskApp.setOnClickListener {navigationtoTaskApp()}
    }
    private fun navigationtoWelcome(){
        val intent = Intent(this, MyFirtsAppActyvity::class.java)
        startActivity(intent)
    }
    private fun navigationtoImcApp(){
        val intent = Intent(this, ImcAppActivity::class.java)
        startActivity(intent)
        }

    private fun navigationtoTaskApp(){
        val intent = Intent(this, TaskApp::class.java)
        startActivity(intent)
    }


}