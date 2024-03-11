package com.example.study_buddy.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.study_buddy.databinding.MenuItemBinding

class MenuAdapter(private val menuItems: List<String>, private val menuItemTime:MutableList<String>): RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MenuViewHolder(binding)
    }



    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }
    override fun getItemCount(): Int = menuItems.size
    inner class MenuViewHolder(private val binding : MenuItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                SearchsubjectCode.text = menuItems[position]
                SearchTimeBox.text = menuItemTime[position]
            }
        }

    }

}