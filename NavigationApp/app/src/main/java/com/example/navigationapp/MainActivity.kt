package com.example.navigationapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.view.View
import android.widget.Toast
import android.content.Intent
class MainActivity : AppCompatActivity() {
    var counter = 0
    var textView:TextView?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.countText)

        println("I am  onCreate() Executing....")
       // textView?.text = "$counter"
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putInt("counter",counter)
        println("I am onStore() Executing....")
    }
    override fun onRestoreInstanceState(outState:Bundle?)
    {
        super.onRestoreInstanceState(outState)
        counter = outState?.getInt("counter") as Int
        textView?.text = "$counter"
        println("I am onRestore() Executing.....")
    }
    fun showToast(view:View?){
        val intent = Intent(this,NewActivity::class.java)
        startActivity(intent)
    }

    fun count(view:View?)
    {
        counter +=1
        textView?.text = "$counter"
    }
}
