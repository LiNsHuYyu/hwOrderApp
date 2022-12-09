package com.example.hw5

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView

class MaindishSelect : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maindish_select)
        var btnConfirmMD = findViewById<Button>(R.id.btnConfirmMD)
        var tvTableNoMD = findViewById<TextView>(R.id.tvTableNoMD)
        lateinit var mealA: CheckBox
        lateinit var mealB: CheckBox
        lateinit var mealC: CheckBox
        lateinit var mealD: CheckBox
        mealA = findViewById(R.id.cbAMeal)
        mealB = findViewById(R.id.cbBMeal)
        mealC = findViewById(R.id.cbCMeal)
        mealD = findViewById(R.id.cbDMeal)

        val intent= intent
        val mainTableNo = intent.getStringExtra("tableNo")
        tvTableNoMD.text = "桌號: "+(mainTableNo)


        //tvTableNoMD.text = intent.getStringExtra("dataTransfer")

        btnConfirmMD.setOnClickListener {
            var meal1 = if (mealA.isChecked) "A餐" else ""
            var meal2 = if (mealB.isChecked) "B餐" else ""
            var meal3 = if (mealC.isChecked) "C餐" else ""
            var meal4 = if (mealD.isChecked) "D餐" else ""
            val meal = "$meal1 $meal2 $meal3 $meal4"

            val intent = Intent().apply {
                putExtra("resultMD", "$meal")
            }
            setResult(RESULT_OK, intent)

            finish()
        }
    }
}