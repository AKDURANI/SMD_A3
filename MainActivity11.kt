package com.alikhan.i210766

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.StorageReference

class MainActivity11 : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var firebaseDatabase: FirebaseDatabase

    private lateinit var databaseReference: DatabaseReference
    private lateinit var valueEventListener: ValueEventListener
    private lateinit var storageReference: StorageReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main11)
        firebaseAuth = FirebaseAuth.getInstance()
        firebaseDatabase = FirebaseDatabase.getInstance()


        val sendbutton11=findViewById<Button>(R.id.btn_send11)
        sendbutton11.setOnClickListener {

            val m_review = findViewById<EditText>(R.id.review)
            val review = m_review.text.toString()

            val user = firebaseAuth.currentUser
            val userId = user?.uid

            // Get reference to the specific user node
            val userRef = firebaseDatabase.getReference("Users").child(userId!!)

            // Create a HashMap to hold user info data
            val userData = HashMap<String, String>()


            userData["review"] = review
            userRef.child("mentor_info").setValue(userData)
                .addOnSuccessListener {
                    Toast.makeText(this, "mentor successfully", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { exception ->
                    Toast.makeText(this, "Failed to add mentor: ${exception.message}", Toast.LENGTH_SHORT).show()
                }



        }


        val sendimageview10=findViewById<ImageView>(R.id.imageView10_Back)
        sendimageview10.setOnClickListener {
            val tenth_intent = Intent(this,MainActivity10::class.java)
            startActivity(tenth_intent)
        }

    }
}