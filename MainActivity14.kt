package com.alikhan.i210766

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity14 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main14)



        val sendbutton15=findViewById<Button>(R.id.btn_send15)
        sendbutton15.setOnClickListener {
            val fifteen_intent = Intent(this,MainActivity15::class.java)
            startActivity(fifteen_intent)
        }



        val sendimageview13=findViewById<ImageView>(R.id.imageView13_Back)
        sendimageview13.setOnClickListener {
            val thirteenth_intent = Intent(this,MainActivity13::class.java)
            startActivity(thirteenth_intent)
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