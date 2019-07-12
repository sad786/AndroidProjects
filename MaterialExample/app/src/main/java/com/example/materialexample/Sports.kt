package com.example.materialexample

class Sports(private val title:String,private val info:String, private val imageResource:Int)
{
    fun getResource() = imageResource
    fun getTitle() = title
    fun getInfo() = info
}