package com.example.navigationapp
import android.os.Bundle
import android.app.Activity
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
class NewActivity:Activity() {
    var counter = 1
    override fun onCreate(savedInstance:Bundle?)
    {
        super.onCreate(savedInstance)
        setContentView(R.layout.activity_new)

        val btn = findViewById<Button>(R.id.addButton)
        val editText = findViewById<EditText>(R.id.editText)
        val layout = findViewById<LinearLayout>(R.id.linearLayout)

        btn.setOnClickListener{
            if(!editText.text.isEmpty()) {
                val newButton = Button(this)
                newButton.text = "${editText.text} Button"
                newButton.width = 400
                newButton.height = 50
                layout.addView(newButton)
               // newButton.background = R.color.colorPrimaryDark as Drawable
            }
        }
    }

    override fun onSaveInstanceState(bundle:Bundle?)
    {
        super.onSaveInstanceState(bundle)
        bundle?.putInt("counter",counter)
    }

    override fun onRestoreInstanceState(bundle:Bundle?)
    {
        super.onRestoreInstanceState(bundle)
        counter = bundle?.getInt("counter") as Int
    }
}