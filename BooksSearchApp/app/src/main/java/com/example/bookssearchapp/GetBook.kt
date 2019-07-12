package com.example.bookssearchapp
import android.net.Uri
import java.net.HttpURLConnection
import java.net.URL
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.IOException
import java.io.InputStream

class GetBook
{
    companion object{
        private const val WEB_URL = "https://www.googleapis.com/books/v1/volumes?"
        const val QUERY = "q"
        const val MAX = "maxResults"
        const val PRINT_TYPE = "printType"
        fun getBookInfo(query:String):String{

            val uriBuilder:Uri = Uri.parse(WEB_URL).buildUpon().
                appendQueryParameter(QUERY,query).
                appendQueryParameter(MAX,"5").
                appendQueryParameter(PRINT_TYPE,"books").
                build()

            val builder = StringBuilder()
            var inputStream:InputStream? = null
            var reader:BufferedReader?=null

            try{

                val url = URL(uriBuilder.toString())
                println(url.toString())
                val connection = url.openConnection() as HttpURLConnection
                connection.requestMethod = "GET"

                connection.connect()

                inputStream = connection.inputStream
                reader = BufferedReader(InputStreamReader(inputStream))

                var line = reader.readLine()
                while(line!=null)
                {
                    builder.append(line)
                    line = reader.readLine()
                }
            }catch(io:IOException){

                reader?.close()
                inputStream?.close()
                println("=> ${io.message}")
            }

            return if(builder.isEmpty())"No Data Found" else builder.toString()
        }
    }
}