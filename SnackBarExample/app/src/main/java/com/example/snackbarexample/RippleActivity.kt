package com.example.snackbarexample
import android.app.Activity
import android.os.Bundle
import android.transition.Explode
import android.view.Gravity
import android.view.View
import android.widget.TextView
class RippleActivity:Activity()
{
    override fun onCreate(savedInstance:Bundle?)
    {
        super.onCreate(savedInstance)
        setContentView(R.layout.ripple_activity)
        showTrans()
    }

    fun showTrans()
    {
        val slide = Explode()
        slide.duration = 1000

        this.window.reenterTransition = slide
        this.window.exitTransition = slide
        this.window.allowReturnTransitionOverlap = false
        this.window.allowEnterTransitionOverlap = false
    }
    fun dummyClick(view:View?)
    {
        val t = findViewById<TextView>(R.id.boundRip)
    }
}