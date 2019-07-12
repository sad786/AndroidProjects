package com.example.recyclertest
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.View
import android.view.LayoutInflater
import android.widget.TextView

import java.util.LinkedList
class WordListAdapter(context:Context,list:LinkedList<String>):
    RecyclerView.Adapter<WordListAdapter.WordViewHolder>()
{

    private val inflater:LayoutInflater  = LayoutInflater.from(context)
    private val itemList:LinkedList<String>
    init{
        this.itemList = list
    }

    override fun onBindViewHolder(p0: WordViewHolder, p1: Int) {
        val data = itemList[p1]
        p0.textView.text = data
    }

    override fun onCreateViewHolder(parent:ViewGroup,viewType:Int):WordViewHolder{
        val view:View = inflater.inflate(R.layout.list_view,parent,false)
       // view.setOnClickListener(this)
        return WordViewHolder(view,this)
    }

    override fun getItemCount() = itemList.size
    class WordViewHolder(itemView:View,adapter:WordListAdapter):RecyclerView.ViewHolder(itemView)
    {
        val textView = itemView.findViewById<TextView>(R.id.text_view)
        val myAdapter = adapter
    }
}