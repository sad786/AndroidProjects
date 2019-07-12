package com.example.notifyme

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.app.NotificationManager
import android.app.NotificationChannel
import android.support.v4.app.NotificationCompat
import android.content.Context
import android.graphics.Color
import android.app.PendingIntent
import android.content.Intent

class MainActivity : AppCompatActivity() {

    private val CHANNEL_ID="MY_CHANNEL_ID"
    private val NOTIFICATION_ID:Int=0
    private var manager:NotificationManager?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val notify = findViewById<Button>(R.id.notify)
        notify.setOnClickListener{
            val builder = getNotificationBuilder()
            manager!!.notify(NOTIFICATION_ID,builder.build())
        }

        val update = findViewById<Button>(R.id.update)
        update.setOnClickListener{

        }

        val cancel = findViewById<Button>(R.id.cancel)
        cancel.setOnClickListener{
            manager!!.cancel(NOTIFICATION_ID)
        }

        this.createNotification()
    }

    private fun getNotificationBuilder():NotificationCompat.Builder
    {
        val content = Intent(this,MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this.applicationContext,NOTIFICATION_ID,content,PendingIntent.FLAG_UPDATE_CURRENT)

        val builder = NotificationCompat.Builder(this,CHANNEL_ID)
                                        .setContentTitle("You've been notified")
                                        .setContentText("You are the lucky person")
                                        .setSmallIcon(R.drawable.ic_android)
                                        .setContentIntent(pendingIntent)
                                        .setAutoCancel(true)
                                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                                        .setDefaults(NotificationCompat.DEFAULT_ALL)

        return builder
    }

    private fun createNotification()
    {
        manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if(android.os.Build.VERSION.SDK_INT>=android.os.Build.VERSION_CODES.O)
        {
            val channel = NotificationChannel(CHANNEL_ID,"Sensitive Notification",NotificationManager.IMPORTANCE_HIGH)

            channel.lightColor = Color.CYAN
            channel.description="Hey! You have a sensitive Notification"
            channel.enableVibration(true)
            channel.enableLights(true)

            manager!!.createNotificationChannel(channel)
        }
    }
}
