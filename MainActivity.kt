package com.alikhan.i210766

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_MESSAGE = "com.example.intent.MESSAGE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sendbutton=findViewById<Button>(R.id.btn_send1)

        sendbutton.setOnClickListener {
            val second_intent = Intent(this,MainActivity2::class.java)
            val msg = "Hello SMD"
            second_intent.putExtra(EXTRA_MESSAGE,msg)
            startActivity(second_intent)
        }

        val set_text = findViewById<TextView>(R.id.head_tv)
        set_text.setOnClickListener{
            val fifth_intent = Intent(this, MainActivity5::class.java)
            val msg = "Hello SMD"
            fifth_intent.putExtra(EXTRA_MESSAGE, msg)
            startActivity(fifth_intent)

        }












    }
}