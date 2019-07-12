package com.example.layoutapp
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.widget.Toast
class StandaloneTollBar:AppCompatActivity()
{
    override fun onCreate(savedInstance:Bundle?)
    {
        super.onCreate(savedInstance)
        setContentView(R.layout.tollbar_activity)

        println()
        val toolBar = findViewById<Toolbar>(R.id.toolBar)
        /*toolBar.title= "Standalone ToolBar"
        toolBar.subtitle = "By Saddam Ahmed"
        toolBar.inflateMenu(R.menu.menu)
        toolBar.setOnMenuItemClickListener {
            val title = it.title
            Toast.makeText(this,"Selected $title",Toast.LENGTH_SHORT).show()
            true

        }
        */
    }
}