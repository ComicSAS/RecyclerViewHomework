package com.example.recyclerviewhomework.adapter

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.recyclerviewhomework.R
import com.example.recyclerviewhomework.model.User
import com.example.recyclerviewhomework.presentation.detail.Detail

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    private val tvName: TextView
    private val tvDescription: TextView
    private val tvBirthDate: TextView
    private val ivItem: ImageView

    private var intent: Intent? = null

    init {
        itemView.setOnClickListener(this)
        tvName = itemView.findViewById(R.id.tvName)
        tvBirthDate = itemView.findViewById(R.id.tvBirthDate)
        tvDescription = itemView.findViewById(R.id.tvDescription)
        ivItem = itemView.findViewById(R.id.ivItem)
    }

    override fun onClick(v: View) {
        itemView.context.startActivity(intent)
    }

    fun bindData(user: User) {
        //to do set onclick   
        tvName.text = user.name
        tvDescription.text = user.description
        tvBirthDate.text = user.birthDate
        Glide.with(itemView.context).load(user.image).circleCrop()
                .apply(RequestOptions.circleCropTransform()).dontAnimate().into(ivItem)

        intent = Intent(itemView.context, Detail::class.java)
        intent!!.putExtra("name", user.name)
        intent!!.putExtra("description", user.description)
        intent!!.putExtra("birthDate", user.birthDate)
        intent!!.data = user.image
    }
}
