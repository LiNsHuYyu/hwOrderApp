package com.example.hw5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts.GetContent
import androidx.activity.result.registerForActivityResult

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnMainDish = findViewById<Button>(R.id.btnMainDish)
        var btnDrink = findViewById<Button>(R.id.btnDrink)
        var tvTableNo = findViewById<TextView>(R.id.tvTableNo)
        var edTableNo = tvTableNo.text
        var tvMainDish = findViewById<TextView>(R.id.tvMainDish)
        var tvDrink = findViewById<TextView>(R.id.tvDrink)
        var tvSweet = findViewById<TextView>(R.id.tvSweet)
        var tvIce = findViewById<TextView>(R.id.tvIce)
        var btnReorder = findViewById<Button>(R.id.btnReorder)

        val myActivityLauncher2 = registerForActivityResult(GetContent()){result ->
            tvMainDish.text = "主餐: $result"
        }


        btnMainDish.setOnClickListener {
            if (tvTableNo.length()<1)
                tvTableNo.hint = "請輸入桌號!"
            else {
                myActivityLauncher2.launch("$edTableNo")
            }
        }

        btnDrink.setOnClickListener {
            if (tvTableNo.length()<1)
                tvTableNo.hint = "請輸入桌號!"
            else {
                myActivityLauncher2.launch("$edTableNo")
            }
        }

        btnReorder.setOnClickListener {
            val intent = intent
            finish()
            startActivity(intent)
        }
    }


}