package com.alikhan.i210766

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val sendbutton7=findViewById<Button>(R.id.btn_send7)
        sendbutton7.setOnClickListener {
            val seventh_intent = Intent(this,MainActivity7::class.java)
            startActivity(seventh_intent)
        }



        val sendimageview3=findViewById<ImageView>(R.id.imageView3)
        sendimageview3.setOnClickListener {
            val third_intent = Intent(this,MainActivity3::class.java)
            startActivity(third_intent)
        }


    }

}