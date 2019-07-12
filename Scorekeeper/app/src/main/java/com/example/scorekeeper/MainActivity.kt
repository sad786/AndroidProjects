package com.example.scorekeeper

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var score1 = 0
    private var score2 = 0
    private var score1Text:TextView? = null
    private var score2Text:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        score1Text = findViewById(R.id.score1)
        score2Text = findViewById(R.id.score2)
    }

    fun onClick(view:View?)
    {
       when(view?.id) {
           R.id.incButton -> score1 += 1
           R.id.incButton2 -> score2 += 1
           R.id.decButton -> score1 -= 1
           R.id.decButton2 -> score2 -= 1
       }
        score1Text?.text = "$score1"
        score2Text?.text = "$score2"
    }
    override fun onSaveInstanceState(out:Bundle)
    {
        super.onSaveInstanceState(out)
        out.putInt("score1",score1)
        out.putInt("score2",score2)
    }

    override fun onRestoreInstanceState(out: Bundle) {
        super.onRestoreInstanceState(out)

        score1 = out.getInt("score1")
        score2 = out.getInt("score2")

        score1Text?.text = "$score1"
        score2Text?.text = "$score2"

    }

}
