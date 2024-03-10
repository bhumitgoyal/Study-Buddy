package com.example.study_buddy.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.study_buddy.databinding.PopulafItemsBinding

class PopularAdapter (private val items:List<String>,private val time:List<String>) : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(PopulafItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    }


    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val item = items[position]
        val time = time[position]
        holder.bind(item,time)
    }
    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class PopularViewHolder (private val binding : PopulafItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String, time: String) {
            binding.subjectCode.text = item
            binding.TimeBox.text = time
        }

    }
}