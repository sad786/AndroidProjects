package com.example.notificationapp
import android.content.BroadcastReceiver
import android.content.Intent
import android.content.Context

class NotifyReceiver():BroadcastReceiver()
{
    override fun onReceive(context:Context,intent:Intent)
    {
        val act = context as MainActivity
        when(intent.action)
        {
            "MESSAGE_REPLIED" -> act.getMessage(intent)
            "CANCEL_UPDATE" -> act.canceled()
        }
    }
}