package com.example.dell.retainer
import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import android.widget.TextView
import java.io.*
class Content:Activity()
{
    override fun onCreate(savedInstance:Bundle?)
    {
        super.onCreate(savedInstance)
        this.setContentView(R.layout.activity_content)
        val textView = this.findViewById<TextView>(R.id.data)
        try {
            val file = File("file:///AndroidProjects/Retainer/info.txt")
            if(file.exists())
            {
                val fin = FileReader(file)
                textView.text = fin.readText()
                fin.close()
            }
            else
                textView.text = "No Data Available"
        }catch(e:IOException){Toast.makeText(this,e.message,Toast.LENGTH_LONG).show()}
    }
}