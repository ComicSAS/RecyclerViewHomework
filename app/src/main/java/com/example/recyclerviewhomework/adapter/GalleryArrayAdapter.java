package com.example.recyclerviewhomework.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewhomework.R;
import com.example.recyclerviewhomework.model.Gallery;

import java.util.ArrayList;
import java.util.List;

public class GalleryArrayAdapter extends RecyclerView.Adapter<GallaryViewHolder> implements View.OnLongClickListener {

    private ArrayList<Gallery> galleryList;

    public GalleryArrayAdapter() {
        this.galleryList = new ArrayList<>();
    }

    @NonNull
    @Override
    public GallaryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gallery_item, parent, false);
        GallaryViewHolder holder = new GallaryViewHolder(view);
        holder.ivPicture.setOnLongClickListener(GalleryArrayAdapter.this);

        holder.ivPicture.setTag(holder);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull GallaryViewHolder holder, int position) {
        Gallery gallery = galleryList.get(position);
        holder.bindPicture(gallery);
    }

    @Override
    public int getItemCount() {
        return galleryList == null ? 0 : galleryList.size();
    }

    public void addItems(List<Gallery> gallery) {
        if (gallery == null)
            return;
        else if (gallery.isEmpty())
            return;
        else {
            galleryList.addAll(gallery);
            //update state of list inside Adapter
            notifyDataSetChanged();
        }
    }

    public void removeItem(int position) {
        galleryList.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public boolean onLongClick(View v) {
        GallaryViewHolder holder = (GallaryViewHolder) v.getTag();
        removeItem(holder.getPosition());
        return false;
    }
}
