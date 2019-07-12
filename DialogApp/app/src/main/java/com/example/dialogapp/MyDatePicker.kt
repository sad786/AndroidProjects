package com.example.dialogapp

import android.app.DatePickerDialog
import android.app.Dialog
import android.support.v4.app.DialogFragment
import android.widget.DatePicker
import android.os.Bundle
import android.widget.Toast
import java.util.Calendar

class MyDatePicker:DialogFragment(),DatePickerDialog.OnDateSetListener
{
    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int)
    {
        Toast.makeText(context,"You selected Date $dayOfMonth $month $year Date",Toast.LENGTH_SHORT).show()
    }

    override fun onCreateDialog(savedInstance:Bundle?):Dialog
    {

        val date = Calendar.getInstance()
        val year = date.get(Calendar.YEAR)
        val month = date.get(Calendar.MONTH)
        val day = date.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(activity,this,year,month,day)
    }
}