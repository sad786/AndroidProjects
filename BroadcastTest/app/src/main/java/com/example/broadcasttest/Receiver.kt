package com.example.broadcasttest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class Receiver:BroadcastReceiver()
{
    override fun onReceive(context: Context?, intent: Intent?) {

        var msg = ""
        if(intent?.action==Intent.ACTION_POWER_CONNECTED)
            msg = "Power is Connected"
        else if (intent?.action==Intent.ACTION_POWER_DISCONNECTED)
            msg = "Power is Disconnected"
        else if (intent?.action=="MY_INTENT_ACTION")
            msg = intent.getStringExtra("msg")
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show()
    }
}