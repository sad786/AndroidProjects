package com.example.broadcastapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.BroadcastReceiver
import android.content.IntentFilter
import android.content.Intent
import android.support.v4.content.LocalBroadcastManager
import android.widget.Button
class MainActivity : AppCompatActivity() {

    private var reciever:MyBroadcast?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        reciever = MyBroadcast()

        val action = BuildConfig.APPLICATION_ID+".MY_ACTION"

        val btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener{
            LocalBroadcastManager.getInstance(this).sendBroadcast(Intent(action))
        }

        LocalBroadcastManager.getInstance(this)
            .registerReceiver(reciever!!,IntentFilter(action))

    }

    override fun onDestroy()
    {
        super.onDestroy()

        LocalBroadcastManager.getInstance(this).unregisterReceiver(reciever!!)
    }
}
