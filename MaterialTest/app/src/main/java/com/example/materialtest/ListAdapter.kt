package com.example.materialtest
import android.support.v7.widget.RecyclerView
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.ImageView
import com.bumptech.glide.Glide
class ListAdapter(private val myContext:Context,private val dataList:ArrayList<Sports>):RecyclerView.Adapter<ListAdapter.ListHolder>()
{

    override fun onCreateViewHolder(parent:ViewGroup,type:Int):ListHolder
    {
        val view = LayoutInflater.from(myContext).inflate(R.layout.list_item,parent,false)
        return ListHolder(view,this)
    }

    override fun getItemCount() = dataList.size

    override fun onBindViewHolder(holder:ListHolder,index:Int)
    {
        holder.bindTo(dataList[index])
    }
    inner class ListHolder(itemView:View,private val adapter:ListAdapter):RecyclerView.ViewHolder(itemView)
    {
        val title = itemView.findViewById<TextView>(R.id.gameTitle)
        val image = itemView.findViewById<ImageView>(R.id.image)
        val subTitle = itemView.findViewById<TextView>(R.id.subTitle)
        val info = itemView.findViewById<TextView>(R.id.info)

        fun bindTo(currentSport:Sports)
        {
            Glide.with(myContext).load(currentSport.imgResource).into(image)
            title.text = currentSport.title
            subTitle.text = "News"
            info.text = currentSport.info
        }
    }
}