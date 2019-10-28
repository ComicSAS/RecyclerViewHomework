package com.example.recyclerviewhomework.presentation.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewhomework.R;
import com.example.recyclerviewhomework.pagenation.PaginationListener;

import java.util.ArrayList;

import static com.example.recyclerviewhomework.model.DataClass.dateOfBirthArray;
import static com.example.recyclerviewhomework.model.DataClass.imageArray;
import static com.example.recyclerviewhomework.model.DataClass.nameArray;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    ArrayList itemList = new ArrayList<>();

    String[] names = nameArray, dateOfBirth = dateOfBirthArray, images = imageArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
    }

    protected void initRecyclerView() {
        recyclerView = findViewById(R.id.item_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        recyclerView.addOnScrollListener(new PaginationListener(layoutManager) {
            @Override
            protected void loadMoreItems() {
            }
        });
    }
}
