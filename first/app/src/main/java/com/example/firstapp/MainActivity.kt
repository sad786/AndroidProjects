package com.example.firstapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_toast = findViewById<Button>(R.id.toast)
        val btn_count = findViewById<Button>(R.id.count)
        val count_view = findViewById<TextView>(R.id.textView)

        counter = savedInstanceState?.getInt("counter") as Int
        count_view.text = "$counter"
        btn_toast.setOnClickListener {
            Toast.makeText(this,"Hello Toast!",Toast.LENGTH_SHORT).show()
        }

        btn_count.setOnClickListener{
            counter +=1
            count_view.text = "$counter"
        }
    }

    override fun onSaveInstanceState(saved:Bundle?)
    {
        super.onSaveInstanceState(saved)
        saved?.putInt("counter",counter)
    }
    override fun onRestoreInstanceState(saved: Bundle?) {
        super.onRestoreInstanceState(saved)

        counter = saved?.getInt("counter") as Int
    }
}
