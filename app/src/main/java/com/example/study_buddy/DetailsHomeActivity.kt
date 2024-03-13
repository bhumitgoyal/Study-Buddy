package com.example.study_buddy

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.study_buddy.databinding.ActivityDetailsHomeBinding

class DetailsHomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val courseCode = intent.getStringExtra("menuItems")
        val courseChapter = intent.getStringExtra("menuItemChapter")
        val courseTimings = intent.getStringExtra("menuItemTime")
        val Name = intent.getStringExtra("menuItemName")
        val courseRoom = intent.getStringExtra("menuItemRoom")
        val coursePhone = intent.getStringExtra("menuItemPhone")

        binding.detailsCourseCode.text=courseCode
        binding.detailsChapter.text=courseChapter
        binding.detailsName.text=Name
        binding.detailsRoomNo.text=courseRoom
        binding.detailsTimings.text=courseTimings
        binding.detailsPhoneNo.text=coursePhone

        binding.backButtonDetails.setOnClickListener {
            finish()
        }

    }
}