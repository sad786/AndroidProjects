package com.example.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.util.Log
class MainActivity : AppCompatActivity() {

    val TAG = MainActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG,"=> 1.onCreate()")

        val send_btn = findViewById<Button>(R.id.send_btn)
        val edit_text = findViewById<EditText>(R.id.editText)

        send_btn.setOnClickListener{

            val intent = Intent(this,SecondActivity::class.java)

            var msg = edit_text.text.toString()
            intent.putExtra("msg",msg)
            this.startActivity(intent)
        }

        val one_btn = findViewById<Button>(R.id.one_btn)
        val two_btn = findViewById<Button>(R.id.two_btn)
        val three_btn = findViewById<Button>(R.id.three_btn)

        one_btn.setOnClickListener{
            val one_intent = Intent(this,SecondActivity::class.java)
            one_intent.putExtra("code","one")
            this.startActivity(one_intent)
        }
        two_btn.setOnClickListener{
            val two_intent = Intent(this,SecondActivity::class.java)
            two_intent.putExtra("code","two")
            this.startActivity(two_intent)
        }
        three_btn.setOnClickListener{
            val three_intent = Intent(this,SecondActivity::class.java)
            three_intent.putExtra("code","three")
            this.startActivity(three_intent)
        }
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
        Log.d(TAG,"=>6.onDestroy()")
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
