package com.example.myapplication.firtsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import com.example.myapplication.R

class MyFirtsAppActyvity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_firts_app_actyvity)


        // Creando coneccion entre xml y objetos con el codigo
        val etName = findViewById<AppCompatEditText>(R.id.etName)
        val textQ = findViewById<AppCompatTextView>(R.id.text)
        val btnStart = findViewById<AppCompatButton>(R.id.btnStart)

        //Funcion del boton
        btnStart.setOnClickListener {
            val name= etName.text.toString()

            if (name.isNotEmpty()){

                //haciendo llamada de una segunda pantalla
                val intent = Intent(this, ResultActivity::class.java)

                // Haciendo envio de variables entre pantallas
                intent.putExtra("ExtraName", name)
                startActivity(intent)


            }
                //textQ.text= name

                //Log.i("Bloque", "Button Pulsado $name")}
        }
    }
}