package com.example.droidcafe

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import android.content.Intent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var selected:String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            val intent = Intent(this,OrderActivity::class.java)
            intent.putExtra("content",selected)
            startActivity(intent)

        }
    }
    fun order(view:View?)
    {
        val str:String = when(view?.id)
        {
            R.id.ice ->{"You ordered a Ice Cream with Circle"

            }
            R.id.donut ->{"You ordered a Donut Ice Cream"
                }
            R.id.froyo ->{ "You ordered a Froyo Ice Cream"
                }
            else ->""
        }

        Toast.makeText(this,selected,Toast.LENGTH_SHORT).show()
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val st:String = when(item.itemId)
        {
            R.id.action_about -> "About selected"
            R.id.action_status ->"Status selected"
            R.id.action_help ->"Help selected"
            R.id.action_contact ->"Contact selected"
            R.id.star ->"Rating selected"
            R.id.order ->"Order selected"
            else ->"Nothing is selected"
        }
        Toast.makeText(this,st,Toast.LENGTH_SHORT).show()
        return true
    }
}
