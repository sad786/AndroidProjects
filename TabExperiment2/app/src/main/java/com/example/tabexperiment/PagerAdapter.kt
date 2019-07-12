package com.example.tabexperiment
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.app.FragmentManager
class PagerAdapter(fr:FragmentManager, not:Int):FragmentStatePagerAdapter(fr)
{
    var noTabs = 0
    init{
        this.noTabs= not
    }
    override fun getItem(p:Int)= when(p) {
            0 -> TabFragment1()
            1 -> TabFragment2()
            2 -> TabFragment3()
            else -> null
    }

    override fun getCount()= noTabs
}