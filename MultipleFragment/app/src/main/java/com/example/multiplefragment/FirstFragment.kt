package com.example.multiplefragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FirstFragment: Fragment()
{
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, bundle: Bundle?):View
    {
        return inflater.inflate(R.layout.fragment_first,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        println("I am created ${this.javaClass.simpleName}")
    }
}