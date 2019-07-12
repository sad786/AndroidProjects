package com.example.materialexample
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
class DetailActivity:AppCompatActivity()
{
    override fun onCreate(saved:Bundle?)
    {
        super.onCreate(saved)
        setContentView(R.layout.activity_detail)

        val newsData = intent?.getStringExtra("data")
        val imgResource = intent?.getIntExtra("resource",0)

        val newsTextView = findViewById<TextView>(R.id.detailText)
        val newsImage = findViewById<ImageView>(R.id.detailImage)

        Glide.with(this).load(imgResource).into(newsImage)
        newsTextView.text = newsData
    }
}