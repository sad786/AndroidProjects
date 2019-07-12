package com.example.activities
import android.os.Bundle
import android.app.Activity
import android.widget.TextView
import android.util.Log
class SecondActivity:Activity()
{
    val TAG = SecondActivity::class.java.simpleName
    override fun onCreate(saved:Bundle?)
    {
        super.onCreate(saved)
        setContentView(R.layout.activity_second)

        Log.d(TAG,"=>1.onCreate()")

        val bundle = intent?.extras

        val msg = bundle?.getString("code")
        val textView = findViewById<TextView>(R.id.textView)

        if(msg.equals("one"))
            textView.text = getString(R.string.text_one)
        else if (msg.equals("two"))
            textView.text = getString(R.string.text_two)
        else if(msg.equals("three"))
            textView.text = getString(R.string.text_three)
        else
            textView.text = bundle?.getString("msg")
    }

    override fun onStart()
    {
        super.onStart()

        Log.d(TAG,"=>2.onStart()")
    }

    override fun onResume()
    {
        super.onResume()

        Log.d(TAG,"=>3.onResume()")
    }

    override fun onPause()
    {
        super.onPause()

        Log.d(TAG,"=>4.onPause()")
    }

    override fun onStop()
    {
        super.onStop()

        Log.d(TAG,"=>5.onStop()")
    }

    override fun onDestroy()
    {
        super.onDestroy()

        Log.d(TAG,"6.onDestroy()")
    }

    override fun onSaveInstanceState(saved:Bundle?)
    {
        super.onSaveInstanceState(saved)

        Log.d(TAG,"onSaveInstanceState()")
    }

    override fun onRestoreInstanceState(saved:Bundle?)
    {
        super.onRestoreInstanceState(saved)

        Log.d(TAG,"onRestoreInstanceState()")
    }

}