package com.example.dell.myintent

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.view.View
import android.widget.EditText
class MainActivity : AppCompatActivity() {

    var age = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tt = findViewById<EditText>(R.id.text)
       // age =  Integer.parseInt(tt.text.toString())
        val btn = findViewById<Button>(R.id.button)
        fun click(view:View?)
        {
            val intent = Intent(this,SecondActivity::class.java)
            val msg = findViewById<EditText>(R.id.text).text.toString()
            intent.putExtra("msg",msg)
            startActivity(intent)
        }
        btn.setOnClickListener(::click)
    }

    override fun onSaveInstanceState(saveInstance:Bundle?)
    {
        super.onSaveInstanceState(saveInstance)
        saveInstance?.putInt("age",age)
        println("Age is saved $age")
    }
    override fun onRestoreInstanceState(outState:Bundle?)
    {
        super.onRestoreInstanceState(outState)
        age = outState?.get("age") as Int
        println("Age is retrieved $age")
    }
}
