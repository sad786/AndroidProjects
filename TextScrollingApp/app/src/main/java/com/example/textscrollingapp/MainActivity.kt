package com.example.textscrollingapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.comment)

        btn.setOnClickListener{
            val intent = Intent("com.example.dell.helloworld.MainActivity")
            intent.addCategory("LAUNCHER")
            intent.setClassName("com.example.dell.helloWorld","MainActivity")
            startActivity(intent)
        }
    }
}
