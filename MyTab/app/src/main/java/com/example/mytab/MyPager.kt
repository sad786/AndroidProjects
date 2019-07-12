package com.example.mytab
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class MyPager(manger:FragmentManager,totalTab:Int):FragmentStatePagerAdapter(manger)
{
    val tabCount = totalTab
    override fun getCount() = tabCount

    override fun getItem(pos:Int) = when(pos){
        0 -> FirstTab()
        1 -> SecondTab()
        2 -> ThirdTab()
        else -> null
    }
}