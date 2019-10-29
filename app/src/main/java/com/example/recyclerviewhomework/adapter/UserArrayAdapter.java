package com.example.recyclerviewhomework.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewhomework.R;
import com.example.recyclerviewhomework.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserArrayAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private ArrayList<User> userList;

    public UserArrayAdapter() {
        this.userList = new ArrayList<>();
    }

    // specify the row layout file and click for each row
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new UserViewHolder(view);
    }

    // load data in each row element
    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.bindData(user);
    }

    @Override
    public int getItemCount() {
        return userList == null ? 0 : userList.size();
    }

    public void addItems(List<User> users) {
        if (users == null)
            return;
        else if (users.isEmpty())
            return;
        else {
            userList.addAll(users);
            //update state of list inside Adapter
            notifyDataSetChanged();
        }
    }
}
