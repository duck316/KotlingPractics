package com.example.myapplication.ImcApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech.OnInitListener
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.ImcApp.ImcAppActivity.Companion.IMC_KEY
import com.example.myapplication.R

class ImcResultActivity : AppCompatActivity() {

    private lateinit var IMCStatu: TextView
    private lateinit var IMCValue: TextView
    private lateinit var IMCComent: TextView
    private lateinit var ReCalculate: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_result)

        val result:Double = intent.extras?.getDouble(IMC_KEY) ?:-1.0

        InitComponent()
        InitUI(result)
        InitListener()
    }

    private fun InitListener(){
        ReCalculate.setOnClickListener {
            onBackPressed()
        }
    }

    private fun InitUI(result: Double){
        when(result){
            in 0.00..18.50 ->{
                IMCStatu.text = "Bajo peso"
                IMCValue.text = result.toString()
                IMCComent.text = "Estas por debajo del peso con relacion a tu altura"
            }
            in 18.51..24.99 ->{
                IMCStatu.text = "Peso normal"
                IMCValue.text = result.toString()
                IMCComent.text = "Tienes un peso normal"
            }
            in 25.00..29.99 ->{
                IMCStatu.text = "Sobre Peso"
                IMCValue.text = result.toString()
                IMCComent.text = "Tienes un ligero sobre peso"
            }
            in 30.00..99.00 ->{
                IMCStatu.text = "Obesidad"
                IMCValue.text = result.toString()
                IMCComent.text = "Estas en muy por encima de tu peso ideal"
            }
            else ->
            {
                IMCStatu.text = "error"
                IMCValue.text = "error"
                IMCComent.text = "error"
            }
        }

    }

    private fun InitComponent(){

        IMCStatu = findViewById(R.id.IMCStatu)
        IMCValue = findViewById(R.id.IMCValue)
        IMCComent = findViewById(R.id.IMCComent)
        ReCalculate = findViewById(R.id.ReCalculate)

    }
}