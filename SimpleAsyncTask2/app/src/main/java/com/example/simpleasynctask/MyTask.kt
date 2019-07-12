package com.example.simpleasynctask
import android.os.AsyncTask
import android.widget.TextView
import java.lang.ref.WeakReference
import java.util.Random
class MyTask(textView:TextView):AsyncTask<Void,Void,String>()
{
    val weakText = WeakReference(textView)
    override fun onPreExecute(){}
    override fun onPostExecute(result:String){
        weakText.get()?.text = result
    }
    override fun onProgressUpdate(vararg status:Void){
    }
    override fun doInBackground(vararg params: Void): String {

        val random = Random()
        val time = (random.nextInt(11)*2000).toLong()
        try{
            Thread.sleep(time)
        }catch(ie:InterruptedException){println(ie.message)}
        return "Awake After sleeping $time milli seconds on the bed"
    }
}