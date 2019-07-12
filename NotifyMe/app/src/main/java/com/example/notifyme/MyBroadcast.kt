package com.example.notifyme

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
class MyBroadcast:BroadcastReceiver()
{
    override fun onReceive(context:Context,intent:Intent)
    {
       Toast.makeText(context,intent.extras.getString("data"),Toast.LENGTH_LONG).show()
    }
}