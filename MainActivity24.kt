package com.alikhan.i210766

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity24 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main24)

        val sendbutton24=findViewById<Button>(R.id.btn_send24)
        sendbutton24.setOnClickListener {
            val twentyfour_intent = Intent(this,MainActivity24::class.java)
            startActivity(twentyfour_intent)
        }

        val sendbutton7=findViewById<Button>(R.id.btn_send7)
        sendbutton7.setOnClickListener {
            val seven_intent = Intent(this,MainActivity7::class.java)
            startActivity(seven_intent)
        }

    }
}