package com.example.whowrotethis


import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val author = findViewById<TextView>(R.id.author)
        val search = findViewById<Button>(R.id.searchButton)
        val query =  findViewById<EditText>(R.id.query)

        search.setOnClickListener{
            if(!query.text.isEmpty())
            {
                val inputManager:InputMethodManager? = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputManager?.hideSoftInputFromWindow(it.windowToken,InputMethodManager.HIDE_NOT_ALWAYS)
                MyTask(author).execute(query.text.toString())

                author.text = "Loading...."
            }
        }

    }
}
