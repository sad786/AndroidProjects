package com.example.broadcasttest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.IntentFilter
import android.content.Intent
import android.widget.Button
class MainActivity : AppCompatActivity() {

    private val myReceiver:Receiver = Receiver()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intentFilter = IntentFilter()
        //val myReceiver = Receiver()
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED)
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED)
        intentFilter.addAction("MY_INTENT_ACTION")

        this.registerReceiver(myReceiver,intentFilter)
        val sendButton = findViewById<Button>(R.id.sendButton)
        sendButton.setOnClickListener{
            val intent = Intent()
            intent.action = "MY_INTENT_ACTION"
            intent.putExtra("msg","I am Custom Broadcast ")
            this.sendBroadcast(intent)
        }
    }

    override fun onDestroy()
    {
        super.onDestroy()

        this.unregisterReceiver(myReceiver)
    }
}
