package com.example.scorekeepertest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var oneScore = 0
    private var twoScore = 0
    private var teamOneScore:TextView? = null
    private var teamTwoScore:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        teamOneScore = findViewById<TextView>(R.id.team_one_score)
        teamTwoScore = findViewById<TextView>(R.id.team_two_score)

        val oneIncButton = findViewById<ImageButton>(R.id.inc_one)
        val oneDecButton = findViewById<ImageButton>(R.id.dec_one)
        val twoIncButton = findViewById<ImageButton>(R.id.inc_two)
        val twoDecButton = findViewById<ImageButton>(R.id.dec_two)

        oneIncButton.setOnClickListener{
            oneScore +=1
            teamOneScore?.text = "$oneScore"
        }
        oneDecButton.setOnClickListener{
            oneScore -=1
            teamOneScore?.text = "$oneScore"
        }

        twoIncButton.setOnClickListener{
            twoScore +=1
            teamTwoScore?.text = "$twoScore"
        }

        twoDecButton.setOnClickListener{
            twoScore -=1
            teamTwoScore?.text = "$twoScore"
        }

    }

    override fun onSaveInstanceState(out:Bundle?)
    {
        super.onSaveInstanceState(out)
        out?.putInt("score1",oneScore)
        out?.putInt("score2",twoScore)
    }

    override fun onRestoreInstanceState(out:Bundle?)
    {
        super.onRestoreInstanceState(out)

        oneScore= out?.getInt("score1") as Int
        twoScore = out?.getInt("score2")

        teamOneScore?.text = "$oneScore"
        teamTwoScore?.text = "$twoScore"

    }
}
