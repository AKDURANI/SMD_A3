package com.alikhan.i210766

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.bumptech.glide.Glide
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener

class MainActivity21 : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference
    private lateinit var valueEventListener: ValueEventListener

    private val PICK_IMAGE_REQUEST = 1
    private lateinit var uploadButton: Button
    private lateinit var imageView: ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main21)

        uploadButton = findViewById(R.id.uploadButton)
        imageView = findViewById(R.id.imageView)
        uploadButton.setOnClickListener {
            openFileChooser()
        }

        firebaseAuth = FirebaseAuth.getInstance()
        firebaseDatabase = FirebaseDatabase.getInstance()
        databaseReference = firebaseDatabase.reference.child("users").child(firebaseAuth.currentUser!!.uid)

        loadProfileImage()




        val sendimageview7_Back=findViewById<ImageView>(R.id.imageView7_Back)
        sendimageview7_Back.setOnClickListener {
            val seventh_H_intent = Intent(this,MainActivity7::class.java)
            startActivity(seventh_H_intent)
        }


        val sendimageview22=findViewById<ImageView>(R.id.imageView22)
        sendimageview22.setOnClickListener {
            val rwentytwo_intent = Intent(this,MainActivity22::class.java)
            startActivity(rwentytwo_intent)
        }

        val sendbutton23=findViewById<Button>(R.id.btn_send23)
        sendbutton23.setOnClickListener {
            val twentythree_intent = Intent(this,MainActivity23::class.java)
            startActivity(twentythree_intent)
        }

        val sendimageview7=findViewById<ImageView>(R.id.imageView7)
        sendimageview7.setOnClickListener {
            val seventh_intent = Intent(this,MainActivity7::class.java)
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



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.data != null) {
            val imageUri = data.data
            Glide.with(this)
                .load(imageUri)
                .circleCrop()
                .into(imageView)

            val currentUser = firebaseAuth.currentUser
            currentUser?.let { user ->
                firebaseDatabase.reference
                    .child("users")
                    .child(user.uid)
                    .child("profileImageUrl")
                    .setValue(imageUri.toString())
            }

        }

        fun onDestroy() {
            super.onDestroy()
            databaseReference.removeEventListener(valueEventListener)
        }

    }


    private fun loadProfileImage() {
        valueEventListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    val profileImageUrl = dataSnapshot.child("profileImageUrl").getValue(String::class.java)
                    profileImageUrl?.let {
                        // Load the profile image into the circular ImageView
                        Glide.with(this@MainActivity21)
                            .load(profileImageUrl)
                            .circleCrop()
                            .into(imageView)
                    }
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {
                // Handle errors
            }
        }

        databaseReference.addValueEventListener(valueEventListener)
    }





    private fun openFileChooser() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST)
    }

}