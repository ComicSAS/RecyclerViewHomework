package com.example.recyclerviewhomework.adapter;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recyclerviewhomework.R;
import com.example.recyclerviewhomework.model.Gallery;

public class GallaryViewHolder extends RecyclerView.ViewHolder {

    public ImageView ivPicture;

    public GallaryViewHolder(@NonNull View itemView) {
        super(itemView);
        ivPicture = itemView.findViewById(R.id.ivPicture);
    }

    public void bindPicture(Gallery gallery){
        Glide.with(itemView.getContext())
                .load(gallery.getPicture()).dontAnimate().into(ivPicture);
    }
}
