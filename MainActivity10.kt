package com.alikhan.i210766

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity10 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main10)

        val sendimageview9=findViewById<ImageView>(R.id.imageView9_Back)
        sendimageview9.setOnClickListener {
            val nineth_intent = Intent(this,MainActivity9::class.java)
            startActivity(nineth_intent)
        }

        val sendbutton11=findViewById<Button>(R.id.btn_send11)
        sendbutton11.setOnClickListener {
            val eleventh_intent = Intent(this,MainActivity11::class.java)
            startActivity(eleventh_intent)
        }

        val sendbutton13=findViewById<Button>(R.id.btn_send13)
        sendbutton13.setOnClickListener {
            val thirteenth_intent = Intent(this,MainActivity13::class.java)
            startActivity(thirteenth_intent)
        }

        val sendbutton16=findViewById<Button>(R.id.btn_send16)
        sendbutton16.setOnClickListener {
            val sixteenth_intent = Intent(this,MainActivity16::class.java)
            startActivity(sixteenth_intent)
        }


    }






}