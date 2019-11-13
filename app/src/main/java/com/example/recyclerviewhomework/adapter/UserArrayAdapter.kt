package com.example.recyclerviewhomework.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewhomework.R
import com.example.recyclerviewhomework.model.User
import com.example.recyclerviewhomework.presentation.IClickListener
import java.util.*

class UserArrayAdapter(private val onItemClick: IClickListener<User>) : RecyclerView.Adapter<UserViewHolder>() {

    private val userList: ArrayList<User>?

    init {
        this.userList = ArrayList()
    }

    // specify the row layout file and click for each row
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item, parent, false)
        return UserViewHolder(view, onItemClick)
    }

    // load data in each row element
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList!![position]
        holder.bindData(user)
    }

    override fun getItemCount(): Int {
        return userList?.size ?: 0
    }

    fun addItems(users: List<User>?) {
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
