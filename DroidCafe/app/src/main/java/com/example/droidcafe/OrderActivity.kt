package com.example.droidcafe
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.TextView
import android.widget.Spinner
import android.widget.ArrayAdapter
import android.widget.AdapterView
import kotlinx.android.synthetic.main.activity_order.*

class OrderActivity:AppCompatActivity(),AdapterView.OnItemSelectedListener
{
    override fun onCreate(savedInstance:Bundle?)
    {
        super.onCreate(savedInstance)
        setContentView(R.layout.activity_order)

        val con = intent.extras?.getString("content")
        val text = findViewById<TextView>(R.id.orderText)
        text.text = if(con!!.isEmpty())"Nothing is Selected " else con

        val adapter = ArrayAdapter.createFromResource(this,
                                R.array.spinner_label,
                                android.R.layout.select_dialog_item)

        val spin = findViewById<Spinner>(R.id.spinner)
        spin.adapter = adapter
        spin.setSelection(0)
        spin.onItemSelectedListener = this
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
       Toast.makeText(this,this.spinner.selectedItem.toString(),Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?){}
    fun radioClicked(view:View?)
    {
        val str  = when(view?.id)
        {
            R.id.same ->"Some day"
            R.id.next -> "Next day"
            R.id.pick->"Pick up"
            else ->""
        }

        Toast.makeText(this,str,Toast.LENGTH_SHORT).show()
    }

}