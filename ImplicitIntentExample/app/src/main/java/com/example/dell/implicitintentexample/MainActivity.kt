package com.example.dell.implicitintentexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.widget.EditText
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = this.findViewById<Button>(R.id.btn)
        btn.setOnClickListener{
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.type="text/plain"
            val data = this.findViewById<EditText>(R.id.editText).text.toString()
            intent.putExtra(Intent.EXTRA_TEXT,data)
            this.startActivity(Intent.createChooser(intent,"Choose from these apps"))

        }
    }
}
