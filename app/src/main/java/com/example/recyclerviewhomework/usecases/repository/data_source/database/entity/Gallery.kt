package com.example.recyclerviewhomework.usecases.repository.data_source.database.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "gallery")
data class Gallery(
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        val gallery: MutableList<Picture>) : Parcelable
