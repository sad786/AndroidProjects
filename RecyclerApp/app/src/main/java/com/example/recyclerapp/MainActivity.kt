package com.example.recyclerapp

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager

import kotlinx.android.synthetic.main.activity_main.*

import java.util.LinkedList

class MainActivity : AppCompatActivity() {
    private var recyclerView:RecyclerView? = null
    private var listSize = 30
    private var list:LinkedList<String>? = null
    private var adapter:WordListAdapter? = null
    private fun makeList():LinkedList<String>
    {
        val list = LinkedList<String>()

        for(i in 1..30)
            list.add("Word => $i")

        return list
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        list = makeList()

        recyclerView = findViewById(R.id.recycler_view)

        adapter = WordListAdapter(this,list!!)
        recyclerView!!.adapter = adapter
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        //recyclerView.layoutManager = GridLayoutManager(this,4)
            // recyclerView.layoutManager = StaggeredGridLayoutManager(4,3)

        //fab.setImageIcon(Icon.createWithResource(applicationContext,R.drawable.ic_add))

        fab.setOnClickListener{
            listSize +=1
            list!!.addLast("Word => $listSize")
            adapter!!.notifyItemChanged(listSize)
            recyclerView!!.smoothScrollToPosition(listSize)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        println("Hello World ")
        listSize = 30
        list = makeList()
        adapter = WordListAdapter(applicationContext,list!!)
        recyclerView!!.adapter = adapter
        return true
    }
}
