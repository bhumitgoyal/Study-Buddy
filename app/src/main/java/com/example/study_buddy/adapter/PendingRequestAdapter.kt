package com.example.study_buddy.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.study_buddy.databinding.PendingrequestsitemBinding

class PendingRequestAdapter (private val courseCode:List<String>,private val timeBox:List<String>,private val roomNo:List<String>,private val nameBox:List<String>) :RecyclerView.Adapter<PendingRequestAdapter.PendingRequestViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PendingRequestViewHolder {
       return PendingRequestViewHolder(PendingrequestsitemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }


    override fun onBindViewHolder(holder: PendingRequestViewHolder, position: Int) {
        val courseCode = courseCode[position]
        val time = timeBox[position]
        val room = roomNo[position]
        val name = nameBox[position]
        holder.bind(courseCode,time,room,name)
    }
    override fun getItemCount(): Int =nameBox.size
    class PendingRequestViewHolder (private val binding: PendingrequestsitemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(courseCode: String, time: String, room: String, name: String) {
            binding.InfosubjectCode.text = courseCode
            binding.InfoNameBox.text=name
            binding.InfoTimeBox.text=time
            binding.InforoomNo.text = room

        }

    }


}