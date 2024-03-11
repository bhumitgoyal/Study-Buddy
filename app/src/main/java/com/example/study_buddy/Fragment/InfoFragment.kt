package com.example.study_buddy.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.study_buddy.adapter.PendingRequestAdapter
import com.example.study_buddy.databinding.FragmentInfoBinding


class InfoFragment : Fragment() {
    private lateinit var binding: FragmentInfoBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentInfoBinding.inflate(inflater,container,false)
        return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val courseCode = listOf("23BCI0137","23BCI0139","23BCI0223","23BCI0989")
        val timeBox = listOf("9:00AM to 10:00 AM","9:00AM to 10:00 AM","9:00AM to 10:00 AM","9:00AM to 10:00 AM")
        val roomNo = listOf("Q-1210","L-513","Q-1210","L-513")
        val nameBox = listOf("Bhumit Goyal","Sarthak Miglani","Pravesh Narang","Aman (Jaat)")
        val adapter = PendingRequestAdapter(courseCode,timeBox,roomNo,nameBox)
        binding.pendingRequestsRecyclerView.layoutManager=LinearLayoutManager(requireContext())
        binding.pendingRequestsRecyclerView.adapter=adapter
    }

    companion object {
    }
}