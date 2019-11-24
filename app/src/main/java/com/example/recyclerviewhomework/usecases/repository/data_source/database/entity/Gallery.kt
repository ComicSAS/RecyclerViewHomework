package com.example.recyclerviewhomework.usecases.repository.data_source.database.entity

import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "gallery")
data class Gallery(
        @PrimaryKey(autoGenerate = true)
        @SerializedName("id")
        val id: Int,
        @SerializedName("picture")
        val picture: Uri)
