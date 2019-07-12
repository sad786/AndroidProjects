package com.example.dialogapp

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.widget.Toast
import android.view.View
import android.support.v7.app.AlertDialog
import android.widget.DatePicker
import java.util.*
import java.time.LocalTime
import android.widget.Button

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val timeButton = findViewById<Button>(R.id.timeButton)
        timeButton.setOnClickListener {
            val cal = Calendar.getInstance()
            val hour = cal.get(Calendar.HOUR_OF_DAY)
            val minute = cal.get(Calendar.MINUTE)
            val timePicker = TimePickerDialog(this,{
                _,hour,minute ->
                Toast.makeText(this,"you choose time is $hour-12::$minute",Toast.LENGTH_SHORT).show()
            },hour,minute,false)

            timePicker.show()
        }
    }
    fun onShowDate(view:View?)
    {
        /*
        val dialog: DialogFragment = MyDatePicker()
        dialog.show(supportFragmentManager,"Date Picker")
        */

        val date = Calendar.getInstance()
        val year = date.get(Calendar.YEAR)
        val month = date.get(Calendar.MONTH)
        val day = date.get(Calendar.DAY_OF_MONTH)
        val datePicker =DatePickerDialog(this,{
            _,year,month,day ->
            Toast.makeText(this,"New Date is $day-${month+1}-$year",Toast.LENGTH_SHORT).show()

        },year,month,day)
        datePicker.show()
    }

    fun onShowAlert(view:View?)
    {
        var flag = false
        val dialog = AlertDialog.Builder(this)
        dialog.setPositiveButton("OK")
        {
                _,_ ->
                Toast.makeText(applicationContext,"You selected Ok",Toast.LENGTH_SHORT).show()
            flag = true
        }
        dialog.setNegativeButton("Cancel"){
                _,_  ->
            Toast.makeText(applicationContext,"You selected Cancel",Toast.LENGTH_SHORT).show()
           // println("Hello I am Cancel Button")
            flag = true
        }
        dialog.setOnDismissListener {
            if(!flag){
                Toast.makeText(applicationContext,"Nothing is selected",Toast.LENGTH_SHORT).show()
            }
        }
        dialog.setTitle("Alert!")
        dialog.setMessage("Choose Ok to proceed further and cancel to go Back!")
        dialog.show()
    }
}
