package com.alikhan.i210766

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        val sendbutton6=findViewById<Button>(R.id.btn_send7)
        sendbutton6.setOnClickListener {
            val sixth_intent = Intent(this,MainActivity7::class.java)
            startActivity(sixth_intent)
        }



        val set_text2 = findViewById<TextView>(R.id.text_send2)
        set_text2.setOnClickListener{
            val second_intent = Intent(this, MainActivity2::class.java)
            val msg = "Hello SMD"
            second_intent.putExtra(MainActivity.EXTRA_MESSAGE, msg)
            startActivity(second_intent)

        }

        val sendimageview5=findViewById<ImageView>(R.id.imageView5)
        sendimageview5.setOnClickListener {
            val fifth_intent = Intent(this,MainActivity5::class.java)
            startActivity(fifth_intent)
        }


    }
}