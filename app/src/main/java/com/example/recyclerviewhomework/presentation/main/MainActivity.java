package com.example.recyclerviewhomework.presentation.main;

import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewhomework.R;
import com.example.recyclerviewhomework.adapter.UserArrayAdapter;
import com.example.recyclerviewhomework.model.User;
import com.example.recyclerviewhomework.pagenation.PaginationListener;

import java.util.ArrayList;

import static com.example.recyclerviewhomework.model.DataClass.dateOfBirthArray;
import static com.example.recyclerviewhomework.model.DataClass.imageArray;
import static com.example.recyclerviewhomework.model.DataClass.nameArray;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    ArrayList userList = new ArrayList<>();

    String[] names = nameArray, birthDates = dateOfBirthArray, images = imageArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
    }

    private void initData() {
        // Populating list items
        for (int i = 0; i < 25; i++) {
            String name = names[i];
            String dateOfBirth = birthDates[i];
            Uri uri = Uri.parse(images[i]);
            userList.add(new User(name, dateOfBirth,
                    "Description " + i + "\nCool Person"
                            + "\nGreat Guy!", uri));
        }
    }

    protected void initRecyclerView() {
        final UserArrayAdapter userArrayAdapter = new UserArrayAdapter();
        recyclerView = findViewById(R.id.item_list);
        // use a linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(userArrayAdapter);
        initData();
        userArrayAdapter.addItems(userList);

        recyclerView.addOnScrollListener(new PaginationListener(layoutManager) {
            @Override
            protected void loadMoreItems() {
                userArrayAdapter.addItems(userList);
            }
        });
    }
}
