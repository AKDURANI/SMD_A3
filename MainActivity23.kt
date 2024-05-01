package com.alikhan.i210766

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity23 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main23)

        val sendimageview21=findViewById<ImageView>(R.id.imageView21_Back)
        sendimageview21.setOnClickListener {
            val rwentyonme_intent = Intent(this,MainActivity21::class.java)
            startActivity(rwentyonme_intent)
        }


    }
}