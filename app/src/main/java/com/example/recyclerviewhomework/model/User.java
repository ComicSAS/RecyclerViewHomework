package com.example.recyclerviewhomework.model;

import android.net.Uri;

public class User {

        private String name;
        private String birthDate;
        private String description;
        private Uri image;

    public User(String name, String birthDate, String description, Uri image){
        this.name = name;
        this.birthDate = birthDate;
        this.description = description;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Uri getImage() {
        return image;
    }

    public void setImage(Uri image) {
        this.image = image;
    }

}
