package com.example.recyclerviewhomework.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewhomework.R
import com.example.recyclerviewhomework.databinding.ItemBinding
import com.example.recyclerviewhomework.usecases.repository.data_source.database.entity.User
import com.example.recyclerviewhomework.presentation.item.IClickListener
import com.example.recyclerviewhomework.presentation.item.UserViewHolder
import java.util.*

class UserArrayAdapter(private val onItemClick: IClickListener<User>) : RecyclerView.Adapter<UserViewHolder>() {

    private val userList: ArrayList<User>?

    init {
        this.userList = ArrayList()
    }

    // specify the row layout file and click for each row
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
        val binding: ItemBinding = DataBindingUtil.inflate(view, R.layout.item, parent, false)
        return UserViewHolder(binding, onItemClick)
    }

    // load data in each row element
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList!![position]
        holder.bindData(user)
    }

    override fun getItemCount(): Int {
        return userList?.size ?: 0
    }

    fun addItems(users: MutableList<User>?) {
        if (users == null)
            return
        else if (users.isEmpty())
            return
        else {
            userList!!.addAll(users)
            //update state of list inside Adapter
            notifyDataSetChanged()
        }
    }
}
