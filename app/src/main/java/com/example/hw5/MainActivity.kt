package com.example.hw5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnmaindish = findViewById<Button>(R.id.btnMainDish)
        btnmaindish.setOnClickListener {
            val intent=intent
            finish()
            startActivity(intent)
        }
    }
}