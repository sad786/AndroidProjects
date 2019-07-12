package com.example.tabexample
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.app.FragmentManager
class PagerAdapter(fr:FragmentManager,p:Int): FragmentStatePagerAdapter(fr)
{
    private var tab = 0
    init{tab = p}
    override fun getCount() = tab

    override fun getItem(pos:Int) = when(pos){
        0 -> FirstFragment()
        1 -> SecondFragment()
        2 -> ThirdFragment()
        else -> null
    }
}