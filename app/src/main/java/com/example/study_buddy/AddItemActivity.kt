package com.example.study_buddy

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.study_buddy.databinding.ActivityAddItemBinding

class AddItemActivity : AppCompatActivity() {

    private val binding : ActivityAddItemBinding by lazy{
        ActivityAddItemBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {

        binding.backButton.setOnClickListener {
            finish()
        }

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
}