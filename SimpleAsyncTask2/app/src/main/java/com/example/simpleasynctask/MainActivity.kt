package com.example.simpleasynctask

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startBtn = findViewById<Button>(R.id.startBtn)
        val textView = findViewById<TextView>(R.id.jobText)

        startBtn.setOnClickListener{
            MyTask(textView).execute()
        }
    }
}
