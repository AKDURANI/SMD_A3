package com.alikhan.i210766

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.tasks.await

class MainActivity3 : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()

        val signUpButton = findViewById<Button>(R.id.btn_send4)
        signUpButton.setOnClickListener {
            signUp()
        }

        val loginTextView = findViewById<TextView>(R.id.text_send2)
        loginTextView.setOnClickListener {
            val loginIntent = Intent(this, MainActivity2::class.java)
            startActivity(loginIntent)
        }
    }

    private fun signUp() {
        val nameEditText = findViewById<EditText>(R.id.edit_enter_name)
        val emailEditText = findViewById<EditText>(R.id.edit_enter_email)
        val contactNoEditText = findViewById<EditText>(R.id.edit_enter_contactno)
        val countryEditText = findViewById<EditText>(R.id.edit_enter_country)
        val cityEditText = findViewById<EditText>(R.id.edit_enter_city)
        val passwordEditText = findViewById<EditText>(R.id.edit_enter_password)

        val name = nameEditText.text.toString()
        val email = emailEditText.text.toString()
        val contactNo = contactNoEditText.text.toString()
        val country = countryEditText.text.toString()
        val city = cityEditText.text.toString()
        val password = passwordEditText.text.toString()

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    val userId = user?.uid

                    // Get reference to the specific user node
                    val userRef = database.getReference("Users").child(userId!!)

                    // Create a HashMap to hold user info data
                    val userData = HashMap<String, String>()
                    userData["name"] = name
                    userData["email"] = email
                    userData["contactNo"] = contactNo
                    userData["country"] = country
                    userData["city"] = city

                    // Set the value of user_info under the specific user node
                    userRef.child("user_info").setValue(userData)
                        .addOnSuccessListener {
                            Toast.makeText(this, "User registered successfully", Toast.LENGTH_SHORT).show()
                        }
                        .addOnFailureListener { exception ->
                            Toast.makeText(this, "Failed to register user: ${exception.message}", Toast.LENGTH_SHORT).show()
                        }
                } else {
                    Toast.makeText(baseContext, "Sign up failed. Please try again later.", Toast.LENGTH_SHORT).show()
                }
            }
    }

}
