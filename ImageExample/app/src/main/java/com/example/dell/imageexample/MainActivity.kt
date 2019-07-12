package com.example.dell.imageexample
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    val images = arrayOf(R.mipmap.appu,R.mipmap.gol,R.mipmap.ic_launcher)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
