package com.example.testapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.provider.ContactsContract
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.list_view)

        /*
        val items = arrayOf(
            "Saddam", "Dilshad", "Akash", "Rohit", "Manoj",
            "Saddam", "Dilshad", "Akash", "Rohit", "Manoj",
            "Saddam", "Dilshad", "Akash", "Rohit", "Manoj",
            "Saddam", "Dilshad", "Akash", "Rohit", "Manoj",
            "Saddam", "Dilshad", "Akash", "Rohit", "Manoj",
            "Saddam", "Dilshad", "Akash", "Rohit", "Manoj",
            "Saddam", "Dilshad", "Akash", "Rohit", "Manoj"
        )

        val adapter = ArrayAdapter(this, R.layout.content_list, R.id.myText, items)
        listView.adapter = adapter
        listView.onItemClickListener =
        AdapterView.OnItemClickListener { parent, view, position, id ->
            val msg = "Parent = ${parent.javaClass.simpleName}\n View = ${view.javaClass.simpleName}"
            Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
        }

        */
        /*
            * here wer are creating our own layout with contact details
            * using Simple Cursor List View


        val contact = arrayOf(ContactsContract.Data.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER)
        println(contact.size)

        val toViews = arrayOf(R.id.myName,R.id.myNumber)
        */
    }

    /*
        class MyAdapter(context:Context,parent:Int,array:ArrayList<String>)
                            :ArrayAdapter<String>(context,parent,array)
        {

            override fun get
        }
   */
}
