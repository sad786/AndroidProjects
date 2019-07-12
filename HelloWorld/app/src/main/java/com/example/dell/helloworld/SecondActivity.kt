package com.example.dell.helloworld
import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class SecondActivity:Activity()
{
    override fun onCreate(savedInstance:Bundle?)
    {
        super.onCreate(savedInstance)
        this.setContentView(R.layout.activity_second)

        val intent = this.intent
        val bundle = intent.extras
        val msg = bundle?.getString("msg")
        val textView = this.findViewById<TextView>(R.id.textView)
        textView.text = msg.toString()

        Toast.makeText(this,msg.toString(),Toast.LENGTH_SHORT).show()
    }
}