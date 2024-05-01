package com.alikhan.i210766

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity9 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main9)


        val sendbutton10=findViewById<Button>(R.id.btn_send10)
        sendbutton10.setOnClickListener {
            val tenth_intent = Intent(this,MainActivity10::class.java)
            startActivity(tenth_intent)
        }

        val sendimageview7=findViewById<ImageView>(R.id.imageView8_Back)
        sendimageview7.setOnClickListener {
            val seventh_intent = Intent(this,MainActivity8::class.java)
            startActivity(seventh_intent)
        }


        val sendimageview8=findViewById<ImageView>(R.id.imageView9)
        sendimageview8.setOnClickListener {
            val eighth_intent = Intent(this,MainActivity9::class.java)
            startActivity(eighth_intent)
        }

        val sendimageview14=findViewById<ImageView>(R.id.imageView14)
        sendimageview14.setOnClickListener {
            val fourteenth_intent = Intent(this,MainActivity14::class.java)
            startActivity(fourteenth_intent)
        }

        val sendimageview21=findViewById<ImageView>(R.id.imageView21)
        sendimageview21.setOnClickListener {
            val twenty_first_intent = Intent(this,MainActivity21::class.java)
            startActivity(twenty_first_intent)
        }

        val sendimageview7_H=findViewById<ImageView>(R.id.imageView7_H)
        sendimageview7_H.setOnClickListener {
            val seventh_H_intent = Intent(this,MainActivity7::class.java)
            startActivity(seventh_H_intent)
        }

        val sendimageview12=findViewById<ImageView>(R.id.imageView12)
        sendimageview12.setOnClickListener {
            val twelth_intent = Intent(this,MainActivity12::class.java)
            startActivity(twelth_intent)
        }
    }
}