package com.example.myapplication.ImcApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.myapplication.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class ImcAppActivity : AppCompatActivity() {

    private var isMaleSelecter:Boolean = true
    private var isFemaleSelecter:Boolean = false
    private var CurrentHeight: Int = 120
    private var CurrentWeight: Int = 70
    private var CurrentAge: Int = 25

    private lateinit var viewMale:CardView
    private lateinit var viewFemale:CardView
    private lateinit var ValueHeight:TextView
    private lateinit var SetHeight: RangeSlider
    private lateinit var BtnRemoveWeight: FloatingActionButton
    private lateinit var BtnAddWeight: FloatingActionButton
    private lateinit var ValueWeight: TextView
    private lateinit var BtnRemoveAge: FloatingActionButton
    private lateinit var BtnAddAge: FloatingActionButton
    private lateinit var ValueAge: TextView
    private lateinit var BtnCalculate: Button
    private lateinit var ImcResult: TextView

    companion object{
        const val IMC_KEY = "IMC_RESULT"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_app)
        iniComponent()
        initListeners()
        initUI()
    }

    private fun iniComponent(){
        viewMale= findViewById(R.id.ViewMale)
        viewFemale= findViewById(R.id.ViewFemale)
        ValueHeight= findViewById(R.id.ValueHeight)
        SetHeight= findViewById(R.id.SetHeight)
        BtnRemoveWeight= findViewById(R.id.BtnRemoveWeight)
        BtnAddWeight= findViewById(R.id.BtnAddWeight)
        ValueWeight= findViewById(R.id.ValueWeight)
        BtnRemoveAge= findViewById(R.id.BtnRemoveAge)
        BtnAddAge= findViewById(R.id.BtnAddAge)
        ValueAge= findViewById(R.id.ValueAge)
        BtnCalculate= findViewById(R.id.BtnCalculate)
        ImcResult= findViewById(R.id.ImcResult)
    }

    private fun initListeners(){
        viewMale.setOnClickListener {
            ChangeGender()
            setGenderColor()
        }
        viewFemale.setOnClickListener {
            ChangeGender()
            setGenderColor()
        }

        SetHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            CurrentHeight =df.format(value).toInt()
            ValueHeight.text= "${CurrentHeight.toString()} CM"
        }

        BtnRemoveWeight.setOnClickListener {
            CurrentWeight -= 1
            setWeight()
        }
        BtnAddWeight.setOnClickListener {
            CurrentWeight += 1
            setWeight()
        }

        BtnRemoveAge.setOnClickListener {
            CurrentAge -= 1
            setAge()
        }
        BtnAddAge.setOnClickListener {
            CurrentAge += 1
            setAge()
        }

        BtnCalculate.setOnClickListener {
            val result = CalculateIMC()
            navigatetoResult(result)
        }
    }

    private fun navigatetoResult(result:Double){
        val intent = Intent(this,ImcResultActivity::class.java)
        intent.putExtra(IMC_KEY, result)
        startActivity(intent)

    }

    private fun CalculateIMC():Double{
        val df = DecimalFormat("#.##")
        val imc = CurrentWeight / (CurrentHeight.toDouble() / 100 * CurrentHeight.toDouble() / 100)
        return df.format(imc).toDouble()
        //ImcResult.text = "Su IMC es $result"
    }

    private fun setHeigth(){
        ValueHeight.text = "$CurrentHeight CM"
    }

    private fun setWeight(){
        ValueWeight.text = "$CurrentWeight kg"
    }

    private fun setAge(){
        ValueAge.text = CurrentAge.toString()
    }

    private fun ChangeGender(){
        isMaleSelecter = !isMaleSelecter
        isFemaleSelecter = !isFemaleSelecter
    }

    private fun setGenderColor(){
        viewMale.setCardBackgroundColor(GetBackgroundColor(isMaleSelecter))
        viewMale.setCardBackgroundColor(GetBackgroundColor(isFemaleSelecter))
    }

    private fun GetBackgroundColor(isSelectedComponent:Boolean): Int{
        var ColorReferent = if(isSelectedComponent) {R.color.Background_Component_selected}
        else{R.color.Background_Component}

        return ContextCompat.getColor(this, ColorReferent)
    }

    private fun initUI(){
        setGenderColor()
        setHeigth()
        setWeight()
        setAge()
    }
}