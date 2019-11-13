package com.example.recyclerviewhomework.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.recyclerviewhomework.R
import com.example.recyclerviewhomework.model.User
import com.example.recyclerviewhomework.presentation.IClickListener

class UserViewHolder(itemView: View, private val onItemClick: IClickListener<User>) : RecyclerView.ViewHolder(itemView) {

    private val tvName: TextView
    private val tvDescription: TextView
    private val tvBirthDate: TextView
    private val ivItem: ImageView

    init {
        tvName = itemView.findViewById(R.id.tvName)
        tvBirthDate = itemView.findViewById(R.id.tvBirthDate)
        tvDescription = itemView.findViewById(R.id.tvDescription)
        ivItem = itemView.findViewById(R.id.ivItem)
    }

    fun bindData(user: User) {
        itemView.setOnClickListener { onItemClick.onItemClick(user) }
        tvName.text = user.name
        tvDescription.text = user.description
        tvBirthDate.text = user.birthDate
        Glide.with(itemView.context).load(user.image).circleCrop()
                .apply(RequestOptions.circleCropTransform()).dontAnimate().into(ivItem)

    }
}
