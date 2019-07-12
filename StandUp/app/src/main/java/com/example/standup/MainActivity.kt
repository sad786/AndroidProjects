package com.example.standup

import android.app.AlarmManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.content.Intent
import android.widget.ToggleButton
import android.app.NotificationChannel
import android.app.PendingIntent
import android.app.NotificationManager
import android.graphics.Color
import android.os.SystemClock

class MainActivity : AppCompatActivity() {

    private var manager:NotificationManager?=null
    private val CHANNEL_ID="MY_ALARM"
    private val NOTIFICATION_ID=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val notifyIntent = Intent(this,MyBroadcast::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this,NOTIFICATION_ID,
                                                                    notifyIntent,
                                                                    PendingIntent.FLAG_CANCEL_CURRENT)

        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

        val alarmButton = findViewById<ToggleButton>(R.id.alarmToggle)

        alarmButton.setOnCheckedChangeListener { _, isChecked ->

            if(isChecked) {

                val repeatInterval:Long = 10000
                val triggerTime = SystemClock.elapsedRealtime()+ repeatInterval
                alarmManager.setInexactRepeating(
                    AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    triggerTime,
                    repeatInterval, pendingIntent
                )
            }else
                alarmManager.cancel(pendingIntent)
        }

        this.setNotification()
    }

    private fun setNotification()
    {
        manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        if(android.os.Build.VERSION.SDK_INT>=android.os.Build.VERSION_CODES.O)
        {
            val channel = NotificationChannel(CHANNEL_ID,"Alarm Channel",NotificationManager.IMPORTANCE_HIGH)
            channel.enableVibration(true)
            channel.enableLights(true)
            channel.lightColor = Color.MAGENTA
            channel.description = "Hey! you have alarm notification"
            manager!!.createNotificationChannel(channel)
        }
    }

}
