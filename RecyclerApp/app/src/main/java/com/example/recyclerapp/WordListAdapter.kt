package com.example.recyclerapp
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.View
import android.view.LayoutInflater
import android.content.Context
import android.widget.TextView
import java.util.LinkedList

class WordListAdapter(context:Context,list:LinkedList<String>):RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {
    private val mWordList = list
    private val layoutInflater:LayoutInflater = LayoutInflater.from(context)
    override fun getItemCount() = mWordList.size

    override fun onBindViewHolder(p0: WordViewHolder, p1: Int) {
        val current = mWordList[p1]
        p0.text.text = current
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int):WordViewHolder {
        val view:View = layoutInflater.inflate(R.layout.word_layout,p0,false)

        return WordViewHolder(view,this)
    }

    class WordViewHolder(itemView:View,adapter:WordListAdapter):RecyclerView.ViewHolder(itemView),View.OnClickListener{

        val text:TextView = itemView.findViewById(R.id.word)
        private val adapt:WordListAdapter = adapter

        init{
            text.setOnClickListener(this)
        }
        override fun onClick(v:View?)
        {
            val pos = layoutPosition

            val newWord = adapt.mWordList.get(pos)
            adapt.mWordList[pos] = "Clicked $newWord"

            adapt.notifyDataSetChanged()
        }
    }
}