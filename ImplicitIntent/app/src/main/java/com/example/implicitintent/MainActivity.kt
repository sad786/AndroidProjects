package com.example.implicitintent

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.content.Intent
import android.support.v4.app.ShareCompat
import android.net.Uri

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val website_btn = findViewById<Button>(R.id.browser_btn)
        val location_btn = findViewById<Button>(R.id.location_btn)
        val share_btn = findViewById<Button>(R.id.data_btn)
        val act_btn = findViewById<Button>(R.id.activity_btn)

        val web_edit = findViewById<EditText>(R.id.website_edit)
        val loc_edit = findViewById<EditText>(R.id.location_edit)
        val data = findViewById<EditText>(R.id.data_text)

        website_btn.setOnClickListener{
            val webPage = Uri.parse(web_edit.text.toString())

            val web_intent = Intent(Intent.ACTION_VIEW,webPage)
            this.startActivity(web_intent)
        }

        location_btn.setOnClickListener{
            val location = Uri.parse("geo:0,0?q=${ loc_edit.text}")
            val loc_intent = Intent(Intent.ACTION_VIEW,location)
            this.startActivity(loc_intent)
        }

        share_btn.setOnClickListener{
            ShareCompat.IntentBuilder
                .from(this)
                .setType("plain/text")
                .setText(data.text.toString())
                .setChooserTitle("Share this data")
                .startChooser()
        }

        act_btn.setOnClickListener{
            val intent = Intent(applicationContext,SecondActivity::class.java)
            this.startActivity(intent)
        }
    }
}
