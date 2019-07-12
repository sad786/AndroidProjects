package com.example.multiplefragment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.widget.Button
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.net.Uri
import android.provider.ContactsContract
import android.widget.Toast
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        val fragManager:FragmentManager = supportFragmentManager
        val fragTrans = fragManager.beginTransaction()

        fragTrans.add(R.id.parent,FirstFragment())
        fragTrans.add(R.id.parent,SecondFragment())
        fragTrans.commit()

        try {
            Thread.sleep(5000)
        }catch(ex:InterruptedException){println(ex.message)}

        fragManager.popBackStack()
        */
        val btn = findViewById<Button>(R.id.btn)
        /*
        * sending telephone number to the phone app directly using implicit intent
        * Uri make this number as resource data and phone app will use it
        */
        /*btn.setOnClickListener {
            val intent = Uri.parse("tel:846287").let { number ->
                Intent(Intent.ACTION_DIAL, number)
            }
            this.startActivity(intent)
        }
        */
        /*
            * opening web browswer using implicti intent
            * here we are using Uri class to wrap a resource into address
         */
        /*btn.setOnClickListener{
            val intent = Uri.parse("https://mysirg.com/").let{
                url -> Intent(Intent.ACTION_VIEW,url)
            }
            val activityList:List<ResolveInfo> = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)
            if(activityList.isNotEmpty())
                this.startActivity(intent)
        }

           */

        /*
            * getting the contact list from phone app
            * using implicit intent
         */

        btn.setOnClickListener{
            Intent(Intent.ACTION_PICK,Uri.parse("content://contacts")).also{
                pick -> pick.type = ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE
                startActivityForResult(pick,6)
            }
        }
    }

    override fun onActivityResult(req:Int,res:Int,data:Intent?)
    {
        super.onActivityResult(req,res,data)
        if(res==RESULT_OK && req==6)
        {
            val cont = data?.data
            cont?.queryParameterNames
            Toast.makeText().show()
        }
    }
}