package com.example.study_buddy.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.study_buddy.adapter.MenuAdapter

import com.example.study_buddy.adapter.PopularAdapter
import com.example.study_buddy.databinding.FragmentHomeBinding



class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val subjectCode = listOf("123456", "23BBS0189","behcfrfr")
    private val time = listOf("9:00 to 5:00","9:00 to 5:00", "5:00 to 9:00")
    private val room = listOf("9:00 to 5:00","9:00 to 5:00", "5:00 to 9:00")
    private val chapter = listOf("9:00 to 5:00","9:00 to 5:00", "5:00 to 9:00")
    private val phone =listOf("9:00 to 5:00","9:00 to 5:00", "5:00 to 9:00")
    private val name = listOf("9:00 to 5:00","9:00 to 5:00", "5:00 to 9:00")

    private lateinit var adapter: MenuAdapter
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

    }

    private val filterMenuCode = mutableListOf<String>()
    private val filterMenuTime = mutableListOf<String>()
    private val filterMenuName = mutableListOf<String>()
    private val filterMenuChapter = mutableListOf<String>()
    private val filterMenuRoom = mutableListOf<String>()
    private val filterMenuPhone = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?



    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)

        adapter= MenuAdapter(filterMenuCode,filterMenuTime,filterMenuRoom,filterMenuPhone,filterMenuName,filterMenuChapter,requireContext())
        binding.PopulafrecyclerView.layoutManager=LinearLayoutManager(requireContext())
        binding.PopulafrecyclerView.adapter=adapter

        setupSearchView()
        showAllMenu()

        return binding.root

    }

    private fun showAllMenu() {
        filterMenuCode.clear()
        filterMenuTime.clear()
        filterMenuName.clear()
        filterMenuRoom.clear()
        filterMenuPhone.clear()
        filterMenuChapter.clear()

        filterMenuCode.addAll(subjectCode)
        filterMenuTime.addAll(time)
        filterMenuChapter.addAll(chapter)
        filterMenuName.addAll(name)
        filterMenuPhone.addAll(phone)
        filterMenuRoom.addAll(room)

        adapter.notifyDataSetChanged()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
    private fun setupSearchView(){
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }


        })
    }

    private fun filterMenuItems(query: String) {

        filterMenuCode.clear()
        filterMenuTime.clear()
        filterMenuName.clear()
        filterMenuRoom.clear()
        filterMenuPhone.clear()
        filterMenuChapter.clear()


        subjectCode.forEachIndexed { index, SubjectCode ->
            if(SubjectCode.contains(query, ignoreCase = true)){
                filterMenuCode.add(SubjectCode)
                filterMenuTime.add(time[index])
                filterMenuName.add(name[index])
                filterMenuPhone.add(phone[index])
                filterMenuChapter.add(chapter[index])
                filterMenuRoom.add(room[index])
            }
        }
        adapter.notifyDataSetChanged()
    }




    companion object {
    }
}