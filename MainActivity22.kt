package com.alikhan.i210766

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class MainActivity22 : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main22)





        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()


        val sendimageview21=findViewById<ImageView>(R.id.imageView21_Back)
        sendimageview21.setOnClickListener {
            val rwentyonme_intent = Intent(this,MainActivity21::class.java)
            startActivity(rwentyonme_intent)
        }


        val updateProfileButton = findViewById<Button>(R.id.btn_send22)
        updateProfileButton.setOnClickListener {
            updateProfileData()
        }


    }





    private fun updateProfileData() {
        val user = auth.currentUser
        val userId = user?.uid

        val reference = database.reference.child("Users").child(userId!!)


        val newName = findViewById<EditText>(R.id.edit_enter_name)
        val newEmail = findViewById<EditText>(R.id.edit_enter_email)
        val newContactNo = findViewById<EditText>(R.id.edit_enter_cnumber)
        val newCountry = findViewById<EditText>(R.id.edit_enter_country)
        val newCity = findViewById<EditText>(R.id.edit_enter_city)

        val updatedData = HashMap<String, Any>()
        updatedData["name"] = newName
        updatedData["email"] = newEmail
        updatedData["contactNo"] = newContactNo
        updatedData["country"] = newCountry
        updatedData["city"] = newCity

        reference.updateChildren(updatedData)
            .addOnSuccessListener {
                Toast.makeText(this, "updated successfully", Toast.LENGTH_SHORT).show()

            }
            .addOnFailureListener { exception ->

                Toast.makeText(this, "updation failed: ${exception.message}", Toast.LENGTH_SHORT).show()
            }
    }

}