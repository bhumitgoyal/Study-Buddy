package com.example.study_buddy.adapter


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.study_buddy.DetailsHomeActivity
import com.example.study_buddy.databinding.MenuItemBinding

class MenuAdapter(private val menuItems: List<String>, private val menuItemTime:MutableList<String>,private val menuItemRoom:MutableList<String>,private val menuItemPhone:MutableList<String>,private val menuItemName:MutableList<String>,private val menuItemChapter:MutableList<String>,private val requireContext: Context): RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {
private val itemClickListener: OnClickListener ?= null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MenuViewHolder(binding)
    }



    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }
    override fun getItemCount(): Int = menuItems.size
    inner class MenuViewHolder(private val binding : MenuItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position!=RecyclerView.NO_POSITION){
                    itemClickListener?.onItemClick(position)
            }
                //set on click listener to open details
                val intent = Intent(requireContext,DetailsHomeActivity::class.java)
                intent.putExtra("menuItemChapter",menuItemChapter.get(position))
                intent.putExtra("menuItemName",menuItemName.get(position))
                intent.putExtra("menuItemRoom",menuItemRoom.get(position))
                intent.putExtra("menuItemPhone",menuItemPhone.get(position))
                intent.putExtra("menuItemTime",menuItemTime.get(position))
                intent.putExtra("menuItems",menuItems.get(position))
                requireContext.startActivity(intent)
            }
        }

        fun bind(position: Int) {
            binding.apply {
                SearchsubjectCode.text = menuItems[position]
                SearchTimeBox.text = menuItemTime[position]
                SearchroomNo.text=menuItemRoom[position]



            }
        }

    }
    interface OnClickListener{
        fun onItemClick(position: Int)

    }


}

