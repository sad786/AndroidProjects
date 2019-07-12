package com.example.simpleasynctask
import android.os.AsyncTask
import android.widget.TextView
import java.lang.ref.WeakReference

class MyTask(view:TextView,up:TextView):AsyncTask<Void,Int,String>()
{
    var textView:WeakReference<TextView>? = null
    var update:WeakReference<TextView>? = null
    init {
        textView = WeakReference(view)
        update = WeakReference(up)
    }
    override fun doInBackground(vararg arg:Void):String
    {
        val milli = (Math.random()*10000).toLong()
        try {
            Thread.sleep(milli)
        }catch(e:InterruptedException){println(e.message)}

        return "Awake at last after sleeping $milli milli seconds"
    }

    override fun onProgressUpdate(vararg values: Int?)
    {
        for( i in values) {
            update?.get()!!.text = "$i"
        }
    }
    override fun onPostExecute(msg:String){textView?.get()!!.text = msg}

}