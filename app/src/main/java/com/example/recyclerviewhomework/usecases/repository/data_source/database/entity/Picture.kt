package com.example.recyclerviewhomework.usecases.repository.data_source.database.entity

import android.net.Uri
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "picture")
data class Picture(
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        val picture: String) : Parcelable