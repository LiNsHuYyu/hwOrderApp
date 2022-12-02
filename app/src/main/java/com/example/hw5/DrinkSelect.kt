package com.example.hw5

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class DrinkSelect : AppCompatActivity() {
    lateinit var drinkGroup: RadioGroup
    lateinit var sugarGroup: RadioGroup
    lateinit var iceGroup: RadioGroup
    lateinit var ice: RadioButton
    lateinit var sugar: RadioButton
    lateinit var selectedDrink: RadioButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink_select)

        var tvTableNoD = findViewById<TextView>(R.id.tvTableNoD)
        var btnConfirmD = findViewById<Button>(R.id.btnConfirmD)

        drinkGroup = findViewById(R.id.DrinkSelect)
        sugarGroup = findViewById(R.id.SweetSelect)
        iceGroup = findViewById(R.id.IceSelect)

        tvTableNoD.text = intent.getStringExtra("dataTransfer")

        btnConfirmD.setOnClickListener {
            var selectOption: Int = iceGroup!!.checkedRadioButtonId
            ice = findViewById(selectOption)

            selectOption = sugarGroup!!.checkedRadioButtonId
            sugar = findViewById(selectOption)

            selectOption = drinkGroup!!.checkedRadioButtonId
            selectedDrink = findViewById(selectOption)

            val finalDrink = "${selectedDrink.text} \n\n甜度:${sugar.text} \n\n冰塊:${ice.text}"
            val intent = Intent().apply {
                putExtra("result", "$finalDrink")
            }

            setResult(Activity.RESULT_OK, intent)

            finish()
        }
    }
}