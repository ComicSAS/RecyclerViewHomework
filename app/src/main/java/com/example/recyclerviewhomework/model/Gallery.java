package com.example.recyclerviewhomework.model;

import android.net.Uri;

public class Gallery {

    private Uri picture;

    public Uri getPicture() {
        return picture;
    }

    public void setPicture(Uri picture) {
        this.picture = picture;
    }

    public Gallery(Uri picture) {
        this.picture = picture;
    }
}
