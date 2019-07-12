package com.example.tabexperiment

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
        this.setSupportActionBar(toolBar)

        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        tabLayout.addTab(tabLayout.newTab().setText("Top Stories"))
        tabLayout.addTab(tabLayout.newTab().setText("Tech News"))
        tabLayout.addTab(tabLayout.newTab().setText("Cooking Tips"))

        tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        //set Pager Adapter
        val pager = findViewById<ViewPager>(R.id.view_pager)

        val pagerAdapter = PagerAdapter(supportFragmentManager,tabLayout.tabCount)
        pager.adapter = pagerAdapter

        pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
    }
}
