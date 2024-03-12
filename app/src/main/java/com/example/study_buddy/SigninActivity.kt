package com.example.study_buddy

import android.accounts.Account
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.study_buddy.databinding.ActivitySigninBinding
import com.example.study_buddy.databinding.ActivityStartBinding
import com.example.study_buddy.model.UserModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database

class SigninActivity : AppCompatActivity() {


    private lateinit var username: String
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference
    private val binding: ActivitySigninBinding by lazy {
        ActivitySigninBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = Firebase.auth
        database = Firebase.database.reference


        binding.createAccountButton.setOnClickListener {
            email = binding.signUpEmail.text.toString().trim()
            password = binding.signUpPassword.text.toString().trim()
            username = binding.signUpUsername.text.toString().trim()

            if(username.isBlank() || email.isBlank() || password.isBlank()){
                Toast.makeText(this, "Please fill all details.", Toast.LENGTH_SHORT).show()
            }else{
                createAccount(email,password)
            }


        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.alreadyhavebutton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email,password  ).addOnCompleteListener { task ->
            if(task.isSuccessful){
                Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT).show()
                saveUserData()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(this, "Account creation failed.", Toast.LENGTH_SHORT).show()
                Log.d("Account", "createAccount: Failure",task.exception)
            }
        }
    }
//save data into database
    private fun saveUserData() {
        email = binding.signUpEmail.text.toString().trim()
        password = binding.signUpPassword.text.toString().trim()
        username = binding.signUpUsername.text.toString().trim()
        val user =UserModel(email,password,username)
        val UserId = FirebaseAuth.getInstance().currentUser!!.uid
    //saving into firebase database
        database.child("user").child(UserId).setValue(user)

    }
}