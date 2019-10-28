package com.example.recyclerviewhomework.adapter;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewhomework.R;
import com.example.recyclerviewhomework.model.User;
import com.example.recyclerviewhomework.presentation.detail.Detail;

public class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView tvName, tvDescription, tvBirthDate;
    public ImageView ivItem;

    Intent intent;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        tvName = itemView.findViewById(R.id.tvName);
        tvBirthDate = itemView.findViewById(R.id.tvBirthDate);
        tvDescription = itemView.findViewById(R.id.tvDescription);
        ivItem = itemView.findViewById(R.id.ivItem);
    }

    @Override
    public void onClick(View v) {
        itemView.getContext().startActivity(intent);
    }

    public void bindData(User user) {


        intent = new Intent(itemView.getContext(), Detail.class);
//        TODO intent.putExtra(); by Andrew
    }
}
