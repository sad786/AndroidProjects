package com.example.whowrotethis
import android.os.AsyncTask
import org.json.*
import android.widget.TextView
import java.lang.ref.WeakReference

class MyTask(resultView:TextView):AsyncTask<String,Void,String>()
{
    var textView:WeakReference<TextView>? = WeakReference(resultView)
    var tit:String?=null

    override fun doInBackground(vararg query:String):String?
    {
        tit = query[0]
        return NetworkUtils.getBookInfo(query[0])
    }

    override fun onPostExecute(res:String?){

        var author:String?=null
        var title:String? = null

        try
        {
            val jsonObject = JSONObject(res)
            val array = jsonObject.getJSONArray("items")
            var i  = 0
            while(i<array.length()&&(author==null&&title==null))
            {
                val book = array.getJSONObject(i)
                val volumeInfo = book.getJSONObject("volumeInfo")
                try{
                        author = volumeInfo.getString("authors")

                        title = volumeInfo.getString("title")
                }catch(ex:Exception){println(ex.message)}

                i +=1
            }

            textView?.get()!!.text = author?:"So Sorry, Some Error Occurred"
        }catch(js:JSONException){println(js.message)}
    }
}