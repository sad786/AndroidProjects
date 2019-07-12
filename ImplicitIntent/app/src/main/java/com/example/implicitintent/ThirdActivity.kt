package com.example.implicitintent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
class ThirdActivity:AppCompatActivity()
{
    override fun onCreate(saved:Bundle?)
    {
        super.onCreate(saved)
        this.setContentView(R.layout.activity_third)
    }
}