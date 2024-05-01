package com.alikhan.i210766

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.StorageReference

class MainActivity12 : AppCompatActivity()
{
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var firebaseDatabase: FirebaseDatabase

    private lateinit var databaseReference: DatabaseReference
    private lateinit var valueEventListener: ValueEventListener
    private lateinit var storageReference: StorageReference

    private val PICK_VIDEO_REQUEST = 2
    private val PICK_IMAGE_REQUEST = 1
    private lateinit var uploadButton: Button
    private lateinit var imageView: ImageView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main12)
        val uploadButtonimage = findViewById<Button>(R.id.btn_send12_image)


            uploadButtonimage.setOnClickListener {
                openFileChooser()


            firebaseAuth = FirebaseAuth.getInstance()
            firebaseDatabase = FirebaseDatabase.getInstance()


            databaseReference = firebaseDatabase.reference.child("users").child(firebaseAuth.currentUser!!.uid)



        }


        val uploadButtonvideo = findViewById<Button>(R.id.btn_send12_video)


        uploadButtonvideo.setOnClickListener {
            openFileChooser_video()


            firebaseAuth = FirebaseAuth.getInstance()
            firebaseDatabase = FirebaseDatabase.getInstance()


            databaseReference = firebaseDatabase.reference.child("users").child(firebaseAuth.currentUser!!.uid)



        }





        val sendimageview7=findViewById<ImageView>(R.id.imageView7_Back)
        sendimageview7.setOnClickListener {
            val seventh_intent = Intent(this,MainActivity7::class.java)
            startActivity(seventh_intent)
        }
        val sendbutton12=findViewById<Button>(R.id.btn_send12)
        sendbutton12.setOnClickListener {

            val nameEditText = findViewById<EditText>(R.id.edit_enter_name)
            val descriptionEditText = findViewById<EditText>(R.id.edit_enter_description)
            val priceEditText = findViewById<EditText>(R.id.edit_enter_price)


            val name = nameEditText.text.toString()
            val description = descriptionEditText.text.toString()
            val price = priceEditText.text.toString()

            val user = firebaseAuth.currentUser
            val userId = user?.uid

            // Get reference to the specific user node
            val userRef = firebaseDatabase.getReference("Users").child(userId!!)

            // Create a HashMap to hold user info data
            val userData = HashMap<String, String>()
            userData["name"] = name
            userData["description"] = description
            userData["price"] = price


            // Set the value of user_info under the specific user node
            userRef.child("mentor_info").setValue(userData)
                .addOnSuccessListener {
                    Toast.makeText(this, "mentor successfully", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { exception ->
                    Toast.makeText(this, "Failed to add mentor: ${exception.message}", Toast.LENGTH_SHORT).show()
                }


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

            val currentUser = firebaseAuth.currentUser
            currentUser?.let { user ->
                firebaseDatabase.reference
                    .child("mentor_info")
                    .child(user.uid)
                    .child("profileImageUrl")
                    .setValue(imageUri.toString())
            }


        }
        if (requestCode == PICK_VIDEO_REQUEST && resultCode == RESULT_OK && data != null && data.data != null) {
            val videoUri = data.data

            val currentUser = firebaseAuth.currentUser
            currentUser?.let { user ->
                firebaseDatabase.reference
                    .child("mentor_info")
                    .child(user.uid)
                    .child("profileVideoUrl")
                    .setValue(videoUri.toString())
            }

        }

        fun onDestroy() {
            super.onDestroy()
            databaseReference.removeEventListener(valueEventListener)
        }

    }




    private fun openFileChooser() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST)
    }

    private fun openFileChooser_video() {
        val intent = Intent()
        intent.type = "video/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Video"), PICK_VIDEO_REQUEST)
    }


}