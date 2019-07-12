package com.example.simpleasynctask

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btn)
        val textView = findViewById<TextView>(R.id.textView1)
        val up = findViewById<TextView>(R.id.update)
        btn.setOnClickListener{
           MyTask(textView,up).execute()
        }
    }
}
