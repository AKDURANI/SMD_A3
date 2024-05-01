package com.alikhan.i210766

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity13 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main13)

        val sendimageview10=findViewById<ImageView>(R.id.imageView10_Back)
        sendimageview10.setOnClickListener {
            val tenth_intent = Intent(this,MainActivity10::class.java)
            startActivity(tenth_intent)
        }

        val sendbutton13=findViewById<Button>(R.id.btn_send13)
        sendbutton13.setOnClickListener {
            val thirteehn_intent = Intent(this,MainActivity13::class.java)
            startActivity(thirteehn_intent)
        }

    }
}