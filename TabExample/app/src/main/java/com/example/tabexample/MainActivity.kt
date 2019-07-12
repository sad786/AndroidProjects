package com.example.tabexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolBar = findViewById<Toolbar>(R.id.tool_bar)
        setSupportActionBar(toolBar)

        val tabLayout = findViewById<TabLayout>(R.id.my_layout)
        println(tabLayout)
        tabLayout.addTab(tabLayout.newTab().setText("Top Stories"))
        tabLayout.addTab(tabLayout.newTab().setText("Entertainment"))
        tabLayout.addTab(tabLayout.newTab().setText("Business news"))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        val pagerAdapter = PagerAdapter(supportFragmentManager,3)
        val viewPager = findViewById<ViewPager>(R.id.view_pager)
        viewPager.adapter = pagerAdapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        class TabListener:TabLayout.OnTabSelectedListener
        {
            override fun onTabReselected(tab:TabLayout.Tab?){}

            override fun onTabSelected(tab:TabLayout.Tab){
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }
        }
        tabLayout.addOnTabSelectedListener(TabListener())
    }

}

