package com.example.snackbarexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.transition.Slide
import android.view.Gravity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val slide = Slide()
        slide.slideEdge = Gravity.LEFT
        slide.duration = 1000

        this.window.reenterTransition = slide
        //this.window.exitTransition = slide
        this.window.allowReturnTransitionOverlap = false
        this.window.allowEnterTransitionOverlap = false
    }

    fun showRipple(view:View?)
    {
        val intent = Intent(this,RippleActivity::class.java)
        startActivity(intent)
    }

    fun java(view:View?)
    {

    }
    fun xml(view:View?)
    {

    }
}
