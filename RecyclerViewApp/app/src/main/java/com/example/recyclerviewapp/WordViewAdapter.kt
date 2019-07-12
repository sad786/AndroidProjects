package com.example.recyclerviewapp

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import android.view.ViewGroup
import android.content.Context
import android.view.LayoutInflater

import java.util.LinkedList

class WordViewAdapter(private val context:Context,private val list:LinkedList<String>):
    RecyclerView.Adapter<WordViewAdapter.WordViewHolder>()
{
    private val inflater:LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(viewGroup:ViewGroup,id:Int):WordViewHolder
    {
        val myView = inflater.inflate(R.layout.wordlist_item,viewGroup,false)
        return WordViewHolder(myView,this)
    }

    override fun onBindViewHolder(adapter:WordViewHolder,p1:Int){
        val msg = list[p1]
        adapter.textView.text= msg
    }

    override fun getItemCount():Int = list.size

    class WordViewHolder(private val view:View,val adapter:WordViewAdapter):RecyclerView.ViewHolder(view)
    {
        val textView = view.findViewById<TextView>(R.id.word)
    }
}