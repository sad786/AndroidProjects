package com.example.bookssearchapp
import android.os.AsyncTask
import android.widget.TextView
import org.json.JSONException
import org.json.JSONObject
import java.lang.ref.WeakReference
class FetchBooks(bookText:TextView):AsyncTask<String,Void,String>()
{
    private val bookDetails = WeakReference<TextView>(bookText)

    override fun doInBackground(vararg param:String):String{

        return GetBook.getBookInfo(param[0])
    }

    override fun onPostExecute(result:String)
    {
        super.onPostExecute(result)

        var title = ""
        var author = ""
        try{
            val jsonArray = JSONObject()
            val array = jsonArray.getJSONArray("items")
            var i =0
            while(i<array.length()&&(title==""&&author==""))
            {
                val obj = array.getJSONObject(i)
                val info = obj.getJSONObject("volumeInfo")

                title = info.getString("title")
                author = info.getString("authors")

                i +=1
            }
        }catch(ex:JSONException){
            title = "No Data Found"
            println(ex.message)
        }
        if(title!=""&&author!="")
            bookDetails.get()?.text = " Title = $title \n Author = $author"
        else
            bookDetails.get()?.text ="No Data Found"
    }
}