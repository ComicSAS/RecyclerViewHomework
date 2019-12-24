package com.example.recyclerviewhomework.usecases.repository.data_source.database.entity

import android.net.Uri
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "users")
data class User(
        @PrimaryKey(autoGenerate = true)
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("birthDate")
        val birthDate: String,
        @SerializedName("description")
        val description: String,
        @SerializedName("image")
        val image: String,
        val gallery: Gallery):Parcelable
