package com.example.materialexample
import android.support.v7.widget.RecyclerView
import android.content.Intent
import android.view.View
import android.view.LayoutInflater
import android.view.ViewGroup
import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class SportAdapter(list:ArrayList<Sports>, private val context:Context):RecyclerView.Adapter<SportAdapter.ListViewHolder>()
{
    private val itemList:ArrayList<Sports> = list
    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent:ViewGroup,ind:Int)=
                            ListViewHolder(layoutInflater.inflate(R.layout.item_list,
                                        parent,false),
                                        this)

    override fun onBindViewHolder(holder:ListViewHolder,ind:Int)
    {
        val anSport = itemList[ind]
        holder.bindTo(anSport)
    }
    override fun getItemCount() = itemList.size

    inner class ListViewHolder(itemView:View,private val adapter:SportAdapter):RecyclerView.ViewHolder(itemView),
                                                            View.OnClickListener
    {
        private val imageView:ImageView = itemView.findViewById(R.id.imageView)
        private val title = itemView.findViewById<TextView>(R.id.textTitle)
        private val info = itemView.findViewById<TextView>(R.id.subTitle)
        private val newsTitle = itemView.findViewById<TextView>(R.id.newsTitle)
        var resource:Int =0
        init{
            itemView.setOnClickListener(this)
        }
        fun bindTo(currentSport:Sports)
        {
            resource = currentSport.getResource()
            Glide.with(context).load(resource).into(imageView)
            title.text = currentSport.getTitle()
            info.text = currentSport.getInfo()
            newsTitle.text = "News"
        }

        override fun onClick(v:View?)
        {
            val sport  = itemList.get(adapterPosition)
            val intent = Intent(context,DetailActivity::class.java)
            intent.putExtra("data",sport.getInfo())
            intent.putExtra("resource",sport.getResource())
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }
}