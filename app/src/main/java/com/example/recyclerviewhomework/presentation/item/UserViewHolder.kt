package com.example.recyclerviewhomework.presentation.item

import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewhomework.databinding.ItemBinding
import com.example.recyclerviewhomework.usecases.repository.data_source.database.entity.User
import com.example.recyclerviewhomework.presentation.item.IClickListener


class UserViewHolder(var binding: ItemBinding, private val onItemClick: IClickListener<User>) : RecyclerView.ViewHolder(binding.root) {

    fun bindData(user: User) {
        itemView.setOnClickListener { onItemClick.onItemClick(user) }
        binding.user = user
        binding.executePendingBindings()
    }
}
