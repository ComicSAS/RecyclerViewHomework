package com.example.recyclerviewhomework.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewhomework.databinding.ItemBinding
import com.example.recyclerviewhomework.model.User
import com.example.recyclerviewhomework.presentation.IClickListener


class UserViewHolder(var binding: ItemBinding, private val onItemClick: IClickListener<User>) : RecyclerView.ViewHolder(binding.root) {

    fun bindData(user: User) {
        itemView.setOnClickListener { onItemClick.onItemClick(user) }
        binding.user = user
        binding.executePendingBindings()
    }
}
