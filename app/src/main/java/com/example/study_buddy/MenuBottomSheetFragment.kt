package com.example.study_buddy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.study_buddy.adapter.PopularAdapter
import com.example.study_buddy.databinding.FragmentMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MenuBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentMenuBottomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMenuBottomSheetBinding.inflate(inflater,container,false)
        val SearchsubjectCode = listOf("34567", "23BBS0189","behcfrfr")
        val SearchTimeBox = listOf("9:00 to 5:00","9:00 to 5:00", "5:00 to 9:00")
        val adapter = PopularAdapter(SearchsubjectCode, SearchTimeBox)
        binding.MenuRecycler.layoutManager= LinearLayoutManager(requireContext())
        binding.MenuRecycler.adapter = adapter

        return binding.root
    }

    companion object {

    }
}