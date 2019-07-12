package com.example.dell.myintent
import android.app.Activity
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.TextView
import android.view.Gravity
class SecondActivity:Activity()
{
    override fun onCreate(savedInstance:Bundle?)
    {
        super.onCreate(savedInstance)
        this.setContentView(R.layout.activity_second)
        val btn = findViewById<Button>(R.id.btn)
        val intent = this.intent
        val bundle = intent.extras
        val msg = bundle?.getString("msg")
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = msg
        btn.setOnClickListener{
           val toast =  Toast.makeText(this,"Hello I am Second Activity",Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER,-200,0)
            toast.show()
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        val text = if(newConfig?.orientation==Configuration.ORIENTATION_PORTRAIT) "Potrait mode" else "Landscape mode"

        Toast.makeText(applicationContext,text,Toast.LENGTH_SHORT).show()
    }
}