package com.example.notificationapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.content.IntentFilter
import android.app.PendingIntent
import android.widget.Button
import android.widget.Toast
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.support.v4.app.NotificationCompat
import android.support.v4.app.RemoteInput

class MainActivity : AppCompatActivity() {
    private lateinit var manager:NotificationManager
    private val CHANNEL_ID = "BEST_ID"
    private val NOTIFICATION_ID=121
    private lateinit var receiver:NotifyReceiver

    private lateinit var notifyButton:Button
    private lateinit var updateButton:Button
    private lateinit var cancelButton:Button


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notifyButton = findViewById(R.id.notify)
        updateButton = findViewById(R.id.update)
        cancelButton = findViewById(R.id.cancel)

        notifyButton.setOnClickListener{
            println("Notify Button clicked")
            sendNotification()
        }

        updateButton.setOnClickListener{

        }

        cancelButton.setOnClickListener{
            manager.cancel(NOTIFICATION_ID)
            setDisable(true, isUpdate = false, isCancel = false)
        }
        //setDisable(true, isUpdate = false, isCancel = false)
        createChannel()

        receiver = NotifyReceiver()
        val filter = IntentFilter("MY_ACTION")
        filter.addAction("CANCEL_UPDATE")
        this.registerReceiver(receiver,filter)
    }


    /*
        * this method will enable button if it is active or not
     */
    private fun setDisable(isNotify:Boolean,isUpdate:Boolean,isCancel:Boolean)
    {
        notifyButton.isEnabled = isNotify
        updateButton.isEnabled = isUpdate
        cancelButton.isEnabled = isCancel
    }


    /*
        * This method will send notification
        * to the system
     */
    fun sendNotification()
    {
        val builder = getBuilder()
        val notification = builder.build()
        manager.notify(NOTIFICATION_ID,notification)

        setDisable(false,true,true)
    }


    /*
        * This method will return the Builder object that
        * is required for associating a particular notification
        * to the channel
     */
    fun getBuilder():NotificationCompat.Builder =
        NotificationCompat.Builder(applicationContext,CHANNEL_ID).let{
            val intent = Intent(applicationContext,MainActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(this,NOTIFICATION_ID,intent,PendingIntent.FLAG_UPDATE_CURRENT)
            val updateIntent = Intent("MY_ACTION")
            val pendingUpdate = PendingIntent.getBroadcast(this,NOTIFICATION_ID,updateIntent,PendingIntent.FLAG_UPDATE_CURRENT)
            val cancelIntent = Intent("CANCEL_UPDATE")
            val pendingCancel  = PendingIntent.getBroadcast(this,NOTIFICATION_ID,cancelIntent,PendingIntent.FLAG_ONE_SHOT)

            val msgIntent = Intent(this,NotifyReceiver::class.java).apply{
                action = "MESSAGE_REPLIED"
            }
            val remoteInput = RemoteInput.Builder("MESSAGE_REPLIED").setLabel("Give Reply").build()
            val pendingMessage = PendingIntent.getBroadcast(this,NOTIFICATION_ID,msgIntent,PendingIntent.FLAG_UPDATE_CURRENT)

            it.setDeleteIntent(pendingCancel)
            it.setContentTitle("Walking Time")
            it.setContentText("Hey! Get up and go for a 15 mins walk!")
            val action:NotificationCompat.Action = NotificationCompat.Action.
                                                                    Builder(R.drawable.ic_notify,"Reply",pendingMessage)
                                                                    .addRemoteInput(remoteInput).build()
            //it.setStyle(NotificationCompat.BigPictureStyle().bigPicture().bigLargeIcon(null))
            it.addAction(action)
            it.setSmallIcon(R.drawable.ic_notify)
            it.setContentIntent(pendingIntent)
            it.setAutoCancel(true)
            it.priority = NotificationCompat.PRIORITY_HIGH
            it.setDefaults(NotificationCompat.DEFAULT_ALL)
        }


    fun getMessage(intent:Intent):CharSequence
    {
        println("getMessage()")
        return RemoteInput.getResultsFromIntent(intent).getCharSequence("MESSAGE_REPLIED")
    }

    /*
        * This method create channel if the running
        * device have the android version Oreao or higher
        *  and return the Notification Manager
     */
    private fun createChannel()
    {
        manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if(android.os.Build.VERSION.SDK_INT>=android.os.Build.VERSION_CODES.O)
        {
            val channel = NotificationChannel(CHANNEL_ID,"About Walk",
                                                NotificationManager.IMPORTANCE_HIGH).apply{
                enableLights(true)
                enableVibration(true)
                lightColor = Color.DKGRAY
                setShowBadge(true)
                description = "This is will remind about the walking time"
            }
            manager.createNotificationChannel(channel)
        }
    }
    fun canceled()
    {
        setDisable(true,false,false)
        Toast.makeText(this,"The notification is canceled by the user",Toast.LENGTH_SHORT).show()
    }
    override fun onDestroy()
    {
        super.onDestroy()
        this.unregisterReceiver(receiver)
    }
}
