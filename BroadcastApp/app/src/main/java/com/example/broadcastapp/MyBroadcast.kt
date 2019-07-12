package com.example.broadcastapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
class MyBroadcast : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        Toast.makeText(context,"My Custom Broadcast",Toast.LENGTH_LONG).show()

        println(intent.action)
    }
}
