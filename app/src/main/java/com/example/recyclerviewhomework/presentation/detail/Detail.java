package com.example.recyclerviewhomework.presentation.detail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.recyclerviewhomework.R;
import com.example.recyclerviewhomework.adapter.GalleryArrayAdapter;
import com.example.recyclerviewhomework.model.Gallery;

import java.util.ArrayList;
import java.util.Objects;

import static com.example.recyclerviewhomework.model.DataClass.imageArray;

public class Detail extends AppCompatActivity {

    String[] pictures = imageArray;

    ArrayList galleryList = new ArrayList<>();

    final GalleryArrayAdapter galleryArrayAdapter = new GalleryArrayAdapter();

    Intent intent;

    TextView tvDescription, tvBirthDate;

    ImageView ivAvatar;

    RecyclerView recyclerView;

    String name, birthDate, description;

    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        setUI();
    }

    private void initGallery() {
        for (int i = 0; i < 12; i++) {
            Uri uri = Uri.parse(pictures[i]);
            galleryList.add(new Gallery(uri));
        }
    }

    private void setUI() {
        intent = getIntent();
        uri = intent.getData();
        name = intent.getStringExtra("name");
        birthDate = intent.getStringExtra("birthDate");
        description = intent.getStringExtra("description");

        tvDescription = findViewById(R.id.tvDetailDescription);
        tvBirthDate = findViewById(R.id.tvDetailBirthDate);
        ivAvatar = findViewById(R.id.ivDetailAvatar);
        recyclerView = findViewById(R.id.rvDetail);

        Objects.requireNonNull(getSupportActionBar()).setTitle(name);
        Glide.with(this).load(uri).circleCrop()
                .apply(RequestOptions.circleCropTransform()).dontAnimate().into(ivAvatar);
        tvBirthDate.setText(birthDate);
        tvDescription.setText(description);

        int columnCount = 3;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, columnCount);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(galleryArrayAdapter);

        initGallery();
        galleryArrayAdapter.addItems(galleryList);
    }
}
