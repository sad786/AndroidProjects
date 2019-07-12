package com.example.standup

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Intent
import android.content.Context
import android.support.v4.app.NotificationCompat

class MyBroadcast:BroadcastReceiver()
{
    private var manager: NotificationManager?=null
    private val CHANNEL_ID="MY_ALARM"
    private val NOTIFICATION_ID=0
    override fun onReceive(context:Context,intent:Intent)
    {
        manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        deliverNotification(context)
    }


    private fun deliverNotification(context:Context)
    {
        val contentIntent = Intent(context,MainActivity::class.java).apply{
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_NO_USER_ACTION
        }

        val pendingIntent = PendingIntent.getActivity(context,NOTIFICATION_ID,
            contentIntent, PendingIntent.FLAG_UPDATE_CURRENT)
        val builder = getNotificationBuilder(context)
        builder.setContentIntent(pendingIntent)

        manager!!.notify(NOTIFICATION_ID,builder.build())
    }

    private fun getNotificationBuilder(context:Context): NotificationCompat.Builder
    {
        val builder = NotificationCompat.Builder(context,CHANNEL_ID)
            .setContentTitle("Alarm Notification")
            .setContentText("you have to walk around every 15 minutes")
            .setSmallIcon(R.drawable.ic_walk)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)
            .setStyle(NotificationCompat.BigTextStyle().bigText("Hello My Name is Saddam Ahmed what is your name please tell me your name and address where do you live and what is your country name also tell me your phone number"))

        return builder
    }
}