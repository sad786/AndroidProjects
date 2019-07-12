package com.example.bookssearchapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import android.widget.EditText
import android.content.Context
import android.net.ConnectivityManager
import android.view.inputmethod.InputMethodManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchButton = findViewById<Button>(R.id.searchBtn)
        val bookName = findViewById<EditText>(R.id.bookName)
        val bookTitle = findViewById<TextView>(R.id.bookTitle)


        searchButton.setOnClickListener{
            val inputManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(it.windowToken,InputMethodManager.HIDE_NOT_ALWAYS)
            val manager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = manager.activeNetworkInfo
            if(networkInfo!=null && networkInfo?.isConnected)
                FetchBooks(bookTitle).execute(bookName.text.toString())
        }
    }
}
