package com.example.materialtest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.support.design.widget.FloatingActionButton

import java.util.Collections

class MainActivity : AppCompatActivity() {

    private val infoList = ArrayList<Sports>()
    private var adapter:ListAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.rec_view)
        adapter = ListAdapter(this,infoList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val itemTouch = ItemTouchHelper(TouchImplement(ItemTouchHelper.UP or ItemTouchHelper.DOWN,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT))
        itemTouch.attachToRecyclerView(recyclerView)
        initializeList()

        recyclerView.setOnClickListener{
            println(it.javaClass.simpleName)
        }

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener{
            initializeList()
        }

    }

    inner class TouchImplement(moveDir:Int,swipeDir:Int): ItemTouchHelper.SimpleCallback(moveDir,swipeDir)
    {
        override fun onMove(p0: RecyclerView, p1: RecyclerView.ViewHolder, p2: RecyclerView.ViewHolder): Boolean {

            val source  = p1.adapterPosition
            val target = p2.adapterPosition

            Collections.swap(infoList,source,target)
            adapter?.notifyItemMoved(source,target)
            return true
        }

        override fun onSwiped(holder:RecyclerView.ViewHolder,ind:Int)
        {
            infoList.removeAt(holder.adapterPosition)
            adapter?.notifyItemRemoved(holder.adapterPosition)
        }
    }

    private fun initializeList()
    {
        val imageList = resources.obtainTypedArray(R.array.image_array)
        val titleList = resources.getStringArray(R.array.title)
        val info = resources.getStringArray(R.array.myInfo)

        infoList.clear()

        for( i in 0 until imageList.length())
        {
            infoList.add(Sports(titleList[i],info[i],imageList.getResourceId(i,0)))
        }
        imageList.recycle()
        adapter?.notifyDataSetChanged()
    }
}
