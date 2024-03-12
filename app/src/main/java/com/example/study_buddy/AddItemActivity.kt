package com.example.study_buddy

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.study_buddy.databinding.ActivityAddItemBinding
import com.example.study_buddy.model.AllMenu
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class AddItemActivity : AppCompatActivity() {

    private lateinit var subjectCodebox :String
    private lateinit var chapterbox :String
    private lateinit var timingsbox :String
    private lateinit var namebox :String
    private lateinit var roomnobox :String

    //firebase
    private lateinit var auth:FirebaseAuth
    private lateinit var database: FirebaseDatabase

    private val binding : ActivityAddItemBinding by lazy{
        ActivityAddItemBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()

        binding.addRequestButton.setOnClickListener {
            //get data from fields
            subjectCodebox = binding.enterCode.text.toString().trim()
            roomnobox = binding.enterHostel.text.toString().trim()
            timingsbox = binding.enterTime.text.toString().trim()
            chapterbox = binding.enterChapter.text.toString().trim()
            namebox = binding.enterName.text.toString().trim()
            if(!(subjectCodebox.isBlank()||roomnobox.isBlank()||timingsbox.isBlank()||chapterbox.isBlank()||namebox.isBlank())){
                uploadData()
                Toast.makeText(this, "Request added successfully", Toast.LENGTH_SHORT).show()
                finish()
            }else{
                Toast.makeText(this, "Fill all the details", Toast.LENGTH_SHORT).show()
            }
        }


        binding.backButton.setOnClickListener {
            finish()
        }



    }

    private fun uploadData() {

        val reqRef=database.getReference("requests")
        val newReqKey=reqRef.push().key

        val newItem = AllMenu(
            subjectCodebox = subjectCodebox,
            chapterbox=chapterbox,
            timingsbox=timingsbox,
            namebox=namebox,
            roomnobox=roomnobox
        )
        newReqKey?.let {
            key ->
            reqRef.child(key).setValue(newItem).addOnSuccessListener {
                Toast.makeText(this, "Data Uploaded Successfully", Toast.LENGTH_SHORT).show()
            }
                .addOnFailureListener {
                    Toast.makeText(this, "Data Upload Failed", Toast.LENGTH_SHORT).show()
                }
        }


    }

}