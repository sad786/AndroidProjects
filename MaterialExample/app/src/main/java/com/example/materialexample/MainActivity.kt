package com.example.materialexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.support.design.widget.FloatingActionButton
import java.util.Collections

class MainActivity : AppCompatActivity() {
    private var recyclerView:RecyclerView?=null
    private var adapter:SportAdapter? = null
    private val sportList:ArrayList<Sports> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rec_view)
        adapter = SportAdapter(sportList,applicationContext)
        recyclerView?.adapter = adapter
        recyclerView?.layoutManager = LinearLayoutManager(this)

        initializeData()

        val itemChange = ItemTouchHelper(MyCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT))
        itemChange.attachToRecyclerView(recyclerView)

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener{
            initializeData()
        }
    }
    inner class MyCallback(dragDirs:Int,swipeDirs:Int):ItemTouchHelper.SimpleCallback(dragDirs,swipeDirs)
    {
        override fun onMove(p0: RecyclerView, p1: RecyclerView.ViewHolder, p2: RecyclerView.ViewHolder): Boolean {
            val org = p1.adapterPosition
            val target = p2.adapterPosition
            Collections.swap(sportList,org,target)
            adapter?.notifyItemMoved(org,target)
            return true
        }

        override fun onSwiped(p0: RecyclerView.ViewHolder, p1: Int) {
            sportList.removeAt(p0.adapterPosition)
            adapter?.notifyItemRemoved(p0.adapterPosition)
        }
    }

    override fun onSaveInstanceState(out:Bundle?)
    {
        super.onSaveInstanceState(out)
        //out?.putParcelableArrayList("sportList",)
        val i =0

    }

    override fun onRestoreInstanceState(out:Bundle?)
    {
        super.onRestoreInstanceState(out)

    }

    private fun initializeData()
    {
        val image = resources.obtainTypedArray(R.array.image_array)
        val info = resources.getStringArray(R.array.info)
        val title = resources.getStringArray(R.array.title)
        sportList.clear()
        for(i in 0 until title.size)
        {
            sportList.add(Sports(title[i],info[i],image.getResourceId(i,0)))
        }
        image.recycle()
        adapter?.notifyDataSetChanged()
    }
}
