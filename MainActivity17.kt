package com.alikhan.i210766

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity17 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main17)


        val sendimageview15_H=findViewById<ImageView>(R.id.imageView15_Back)
        sendimageview15_H.setOnClickListener {
            val fifteenth_intent = Intent(this,MainActivity15::class.java)
            startActivity(fifteenth_intent)
        }

        val eighteen_text = findViewById<TextView>(R.id.textView18)
        eighteen_text.setOnClickListener{
            val eighteen_intent = Intent(this, MainActivity18::class.java)
            startActivity(eighteen_intent)

        }


    }
}