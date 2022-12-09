package com.example.hw5

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts.GetContent
import androidx.activity.result.registerForActivityResult

class MainActivity : AppCompatActivity() {
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        data?.extras?.let {
            if (requestCode == 1 && resultCode == Activity.RESULT_OK){
                var tvMainDish = findViewById<TextView>(R.id.tvMainDish)
                tvMainDish.text = "主餐: ${it.getString("resultMD")}"
            }
            if (requestCode == 2 && resultCode == Activity.RESULT_OK){
                var tvDrink = findViewById<TextView>(R.id.tvDrink)
                tvDrink.text = "飲料: ${it.getString("resultD")}"
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnMainDish = findViewById<Button>(R.id.btnMainDish)
        var btnDrink = findViewById<Button>(R.id.btnDrink)
        var edTableNo = findViewById<EditText>(R.id.edTableNo)
        var btnReorder = findViewById<Button>(R.id.btnReorder)



        btnMainDish.setOnClickListener {
            if (edTableNo.length() < 1){
                Toast.makeText(this, "請輸入桌號", Toast.LENGTH_SHORT).show()
            }
            else{
                //宣告Bundle
                val b = Bundle()
                val intent = Intent(this, MaindishSelect::class.java)
                b.putString("tableNo", edTableNo.text.toString())
                intent.putExtras(b)
                startActivityForResult(intent, 1)
            }

        }

        btnDrink.setOnClickListener {
            if (edTableNo.length() < 1){
                Toast.makeText(this, "請輸入桌號", Toast.LENGTH_SHORT).show()
            }
            else {
                //宣告Bundle
                val bun = Bundle()
                val intent = Intent(this, DrinkSelect::class.java)
                bun.putString("tableNo", edTableNo.text.toString())
                intent.putExtras(bun)
                startActivityForResult(intent, 2)
            }
        }

        btnReorder.setOnClickListener {
            val intent = intent
            finish()
            startActivity(intent)
        }
    }


}