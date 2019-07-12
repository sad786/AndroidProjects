package com.example.dell.retainer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.EditText
import android.widget.Toast
import android.widget.Button
import java.io.*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val saveBtn = this.findViewById<Button>(R.id.saveBtn)
        val showBtn = this.findViewById<Button>(R.id.showBtn)

        saveBtn.setOnClickListener{
            val locField = this.findViewById<EditText>(R.id.locField)
            val ledRent = this.findViewById<EditText>(R.id.ledText)
            val lightRentFree = this.findViewById<EditText>(R.id.lightsText)
            val lightsRent = this.findViewById<EditText>(R.id.rentText)
            val otherInfo = this.findViewById<EditText>(R.id.ohterText)
            val loc = locField.text.toString()
            if(loc!="")
            {
                var read:FileReader?=null
                var fout:PrintWriter
                try {
                    //var read:FileReader?=null
                    val file = File("file:///D://AndroidProjects/Retainer/info.txt")
                    if(file.exists())
                        read = FileReader(file)
                    fout = PrintWriter(file)
                    val rent = lightsRent.text.toString()
                    val rentFree = lightRentFree.text.toString()
                    val rentLed = ledRent.text.toString()
                    val other = otherInfo.text.toString()
                    if(read!=null) {
                        val text = read.readText()
                        fout.println(text)
                        fout.println()
                        fout.println()
                        fout.println()
                    }
                    if (rent != "") {
                        fout.println("Lights On Rent =>$rent")
                    }
                    if (rentFree != "") {
                        fout.println("Lights On Rent Free =>$rentFree")
                    }
                    if (rentLed != "") {
                        fout.println("LED On Rent => $rentLed")
                    }
                    if (other != "") {
                        fout.println("Other Information => $other")
                    }
                    fout.flush()
                    fout.close()

                }catch(e:IOException){Toast.makeText(this,e.message,Toast.LENGTH_LONG)}
                finally {
                    if(read!=null)
                        read.close()
                }
            }else
            {
                Toast.makeText(this,"Location cannot be Empty",Toast.LENGTH_LONG)
            }
        }
        showBtn.setOnClickListener{
            val intent = Intent(this,Content::class.java)
            this.startActivity(intent)
        }
    }
}
