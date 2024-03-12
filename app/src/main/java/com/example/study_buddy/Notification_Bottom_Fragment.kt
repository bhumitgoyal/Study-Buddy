package com.example.study_buddy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.study_buddy.adapter.NotificationAdapter
import com.example.study_buddy.adapter.PopularAdapter
import com.example.study_buddy.databinding.FragmentMenuBottomSheetBinding
import com.example.study_buddy.databinding.FragmentNotificationBottomBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class Notification_Bottom_Fragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentNotificationBottomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNotificationBottomBinding.inflate(layoutInflater,container,false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val notifications = listOf("Studying alone?", "Your request has been accepted!", "Your request has been denied!")
        val notificationImages = listOf(R.drawable.sademoji,R.drawable.illustration)
        val adapter = NotificationAdapter(
            ArrayList(notifications),
            ArrayList(notificationImages)
        )
        binding.notificationRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.notificationRecyclerview.adapter = adapter
    }

    companion object {

    }
}