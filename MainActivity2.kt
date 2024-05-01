package com.alikhan.i210766

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity2 : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        auth = FirebaseAuth.getInstance()

        val loginButton = findViewById<Button>(R.id.btn_send7)
        loginButton.setOnClickListener {
            loginUser()
        }

        val signUpTextView = findViewById<TextView>(R.id.text_send3)
        signUpTextView.setOnClickListener {
            val signUpIntent = Intent(this, MainActivity3::class.java)
            startActivity(signUpIntent)
        }

        val forgotPasswordTextView = findViewById<TextView>(R.id.text_send5)
        forgotPasswordTextView.setOnClickListener {
            // Implement Forgot Password functionality here if needed
            val fifth_intent = Intent(this, MainActivity5::class.java)
            val msg = "Hello SMD"
            fifth_intent.putExtra(MainActivity.EXTRA_MESSAGE, msg)
            startActivity(fifth_intent)


        }
    }

    private fun loginUser() {
        val emailEditText = findViewById<EditText>(R.id.edit_send_email)
        val passwordEditText = findViewById<EditText>(R.id.edit_send_pass)

        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Login successful, navigate to the next activity
                    val intent = Intent(this, MainActivity7::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // Login failed, display a message to the user
                    Toast.makeText(this, "Authentication failed. ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}
