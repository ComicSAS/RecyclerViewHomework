package com.example.recyclerviewhomework.presentation.detail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.recyclerviewhomework.R;

import java.util.Objects;

public class Detail extends AppCompatActivity {

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

    }
}
