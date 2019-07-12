package com.example.mytab

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.widget.Toolbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolBar = findViewById<Toolbar>(R.id.toolBar)
        setSupportActionBar(toolBar)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = findViewById<ViewPager>(R.id.view_pager)
        viewPager.adapter = MyPager(supportFragmentManager,3)
        tabLayout.addTab(tabLayout.newTab().setText("First Tab"))
        tabLayout.addTab(tabLayout.newTab().setText("Second Tab"))
        tabLayout.addTab(tabLayout.newTab().setText("Third Tab"))

        val pageListener = TabLayout.TabLayoutOnPageChangeListener(tabLayout)
        viewPager.addOnPageChangeListener(pageListener)

        tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        class MyTabListener:TabLayout.OnTabSelectedListener{

            override fun onTabReselected(p:TabLayout.Tab?){}
            override fun onTabUnselected(P:TabLayout.Tab){}
            override fun onTabSelected(tab:TabLayout.Tab)
            {
                viewPager.currentItem = tab.position
            }
        }

        tabLayout.addOnTabSelectedListener(MyTabListener())


    }

}
