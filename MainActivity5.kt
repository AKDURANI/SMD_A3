package com.alikhan.i210766

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        val sendimageview2=findViewById<ImageView>(R.id.imageView2)
        sendimageview2.setOnClickListener {
            val second_intent = Intent(this,MainActivity2::class.java)
            startActivity(second_intent)
        }



        val sendbutton6=findViewById<Button>(R.id.btn_send6)
        sendbutton6.setOnClickListener {
            val sixth_intent = Intent(this,MainActivity6::class.java)
            startActivity(sixth_intent)
        }



        val set_text2 = findViewById<TextView>(R.id.text_send2)
        set_text2.setOnClickListener{
            val second_intent = Intent(this, MainActivity2::class.java)
            val msg = "Hello SMD"
            second_intent.putExtra(MainActivity.EXTRA_MESSAGE, msg)
            startActivity(second_intent)

        }


    }
}