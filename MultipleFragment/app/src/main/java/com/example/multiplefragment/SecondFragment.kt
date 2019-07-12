package com.example.multiplefragment
import android.support.v4.app.Fragment
import android.view.ViewGroup
import android.view.View
import android.os.Bundle
import android.view.LayoutInflater
class SecondFragment:Fragment()
{
    override fun onCreateView(inflater:LayoutInflater,container:ViewGroup?,bundle:Bundle?):View
    {
        return inflater.inflate(R.layout.fragment_second,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        println("I am created ${this.javaClass.simpleName}")
    }
}