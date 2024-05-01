package com.alikhan.i210766

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale
import androidx.appcompat.widget.SearchView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity8 : AppCompatActivity() {


    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<DataClass>
    lateinit var imageList:Array<Int>
    lateinit var titleList:Array<String>
    lateinit var descList: Array<String>
    lateinit var detailImageList: Array<Int>
    private lateinit var myAdapter: AdapterClass
    private lateinit var searchView: SearchView
    private lateinit var searchList: ArrayList<DataClass>
    private lateinit var database: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main8)

        database = FirebaseDatabase.getInstance().reference.child("Users")

        fetchMentorInfo()
//.............................

        imageList = arrayOf(
            R.drawable.ic_list,
            R.drawable.ic_checkbox,
            R.drawable.ic_image,
            R.drawable.ic_toggle,
            R.drawable.ic_date,
            R.drawable.ic_rating,
            R.drawable.ic_time,
            R.drawable.ic_text,
            R.drawable.ic_edit,
            R.drawable.ic_camera)
        titleList = arrayOf(
            "ali",
            "saad",
            "shaheer",
            "hamza",
            "suleman",
            "hartmann",
            "rizwan",
            "ahmed",
            "huzi",
            "kashif")
        descList = arrayOf(
            getString(R.string.listview),
            getString(R.string.checkbox),
            getString(R.string.imageview),
            getString(R.string.toggle),
            getString(R.string.date),
            getString(R.string.rating),
            getString(R.string.time),
            getString(R.string.textview),
            getString(R.string.edit),
            getString(R.string.camera))
        detailImageList = arrayOf(
            R.drawable.list_detail,
            R.drawable.check_detail,
            R.drawable.image_detail,
            R.drawable.toggle_detail,
            R.drawable.date_detail,
            R.drawable.rating_detail,
            R.drawable.time_detail,
            R.drawable.text_detail,
            R.drawable.edit_detail,
            R.drawable.camera_detail)
        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.search)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        dataList = arrayListOf<DataClass>()
        searchList = arrayListOf<DataClass>()
        getData()
        searchView.clearFocus()
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.clearFocus()
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                searchList.clear()
                val searchText = newText!!.toLowerCase(Locale.getDefault())
                if (searchText.isNotEmpty()){
                    dataList.forEach{
                        if (it.dataTitle.toLowerCase(Locale.getDefault()).contains(searchText)) {
                            searchList.add(it)
                        }
                    }
                    recyclerView.adapter!!.notifyDataSetChanged()
                } else {
                    searchList.clear()
                    searchList.addAll(dataList)
                    recyclerView.adapter!!.notifyDataSetChanged()
                }
                return false
            }
        })

        myAdapter = AdapterClass(searchList)
        recyclerView.adapter = myAdapter
        myAdapter.onItemClick = {
            val intent = Intent(this, MainActivity10::class.java)
            intent.putExtra("android", it)
            startActivity(intent)
        }

//.............................
        val sendimageview7=findViewById<ImageView>(R.id.imageView7)
        sendimageview7.setOnClickListener {
            val seventh_intent = Intent(this,MainActivity7::class.java)
            startActivity(seventh_intent)
        }





        val sendimageview8=findViewById<ImageView>(R.id.imageView8)
        sendimageview8.setOnClickListener {
            val eighth_intent = Intent(this,MainActivity8::class.java)
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

    private fun getData(){
        for (i in imageList.indices){
            val dataClass = DataClass(imageList[i], titleList[i], descList[i], detailImageList[i])
            dataList.add(dataClass)
        }
        searchList.addAll(dataList)
        recyclerView.adapter = AdapterClass(searchList)
    }

    private fun updateArray(mentorInfoList: List<String>) {
        // Convert mentorInfoList to match the format of your array
        titleList = mentorInfoList.toTypedArray()
        println(titleList.joinToString())

        // Now you can use descList as needed
    }

    private fun fetchMentorInfo() {
        val mentorInfoList: MutableList<String> = mutableListOf()

        database.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (userSnapshot in dataSnapshot.children) {
                    for (mentorSnapshot in userSnapshot.child("mentor_info").children) {
                        val mentorName = mentorSnapshot.child("name").value.toString()
                        val mentorDescription = mentorSnapshot.child("description").value.toString()
                        mentorInfoList.add("$mentorName: $mentorDescription")
                    }
                }
                // Once all mentor info is fetched, you can use mentorInfoList as needed
                // For example, you can update your array here
                updateArray(mentorInfoList)
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }





}