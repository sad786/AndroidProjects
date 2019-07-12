package com.example.implicitintent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
class SecondActivity:AppCompatActivity()
{
    override fun onCreate(saved:Bundle?)
    {
        super.onCreate(saved)
        this.setContentView(R.layout.activity_second)

        val btn = findViewById<Button>(R.id.third_btn)
        btn.setOnClickListener{
            val intent = Intent(this,ThirdActivity::class.java)
            this.startActivity(intent)
        }
    }
}