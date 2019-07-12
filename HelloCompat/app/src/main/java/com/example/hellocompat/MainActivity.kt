package com.example.hellocompat

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.support.v4.content.ContextCompat

class MainActivity : AppCompatActivity() {
    var coloredText:TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        coloredText = findViewById(R.id.helloText)
        val chButton = findViewById<Button>(R.id.choiceBtn)
        //!savedInstanceState?:coloredText?.setTextColor(sa)
        if(savedInstanceState!=null)
            coloredText?.setTextColor(savedInstanceState.getInt("color"))
        val colorArray = arrayOf("red", "pink", "purple", "deep_purple",
            "indigo", "blue", "light_blue", "cyan", "teal", "green",
            "light_green", "lime", "yellow", "amber", "orange", "deep_orange",
            "brown", "grey", "blue_grey", "black")

        chButton.setOnClickListener{
            val num = (Math.random()*20).toInt()
            val colorName = colorArray[num]
            val colorRes = resources.getIdentifier(colorName,"color",applicationContext.packageName)
            val color = ContextCompat.getColor(this,colorRes)
            coloredText?.setTextColor(color)
        }

    }

    override fun onSaveInstanceState(out:Bundle?)
    {
        super.onSaveInstanceState(out)
        out?.putInt("color",coloredText?.currentTextColor!!)
    }
}
