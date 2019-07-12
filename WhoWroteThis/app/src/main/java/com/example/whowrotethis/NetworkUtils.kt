package com.example.whowrotethis
import java.net.*
import android.net.Uri
import java.io.BufferedReader
import java.io.InputStreamReader

class NetworkUtils
{
    companion object {
        fun getBookInfo(query:String):String?
        {
            var Base_Url = "https://www.googleapis.com/books/v1/volumes?"
            var query_Param = "q"
            var max_res = "maxResults"
            var printType = "printType"

            val uri:Uri = Uri.parse(Base_Url).buildUpon()
                            .appendQueryParameter(query_Param,query)
                            .appendQueryParameter(max_res,"5")
                            .appendQueryParameter(printType,"books")
                            .build()

            val url = URL(uri.toString())
            var urlConnection:HttpURLConnection? = null
            var reader:BufferedReader? = null
            try{
                urlConnection = url.openConnection() as HttpURLConnection
                urlConnection.requestMethod = "GET"
                urlConnection.connect()

                val inputStream = urlConnection.inputStream
                reader = BufferedReader(InputStreamReader(inputStream))

                val builder = StringBuffer()
                var line:String? =reader.readLine()
                while(line!=null)
                {
                    builder.append(line)
                    builder.append("\n")

                    line = reader.readLine()
                }

                if(builder.isEmpty())
                    return null

                return builder.toString()
            }catch(m:MalformedURLException){println(m.message)}
            finally {
                reader?.close()
                urlConnection?.disconnect()
            }

            return null
        }
    }
}