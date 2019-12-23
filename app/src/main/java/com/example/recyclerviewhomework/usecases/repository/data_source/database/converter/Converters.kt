package com.example.recyclerviewhomework.usecases.repository.data_source.database.converter

import android.net.Uri
import androidx.room.TypeConverter
import com.example.recyclerviewhomework.usecases.repository.data_source.database.entity.Gallery
import com.example.recyclerviewhomework.usecases.repository.data_source.database.entity.Picture
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    @TypeConverter
    fun fromGalleryToJson(gallery: Gallery): String = Gson().toJson(gallery)

    @TypeConverter
    fun fromJsonToGallery(json: String): Gallery = Gson().fromJson(json, object : TypeToken<Gallery>() {}.type)

    @TypeConverter
    fun fromListPictureToJson(pictures: MutableList<Picture>): String =
            Gson().toJson(pictures, object : TypeToken<MutableList<Picture>>() {}.type)

    @TypeConverter
    fun fromJsonToListPicture(json: String): MutableList<Picture> =
            Gson().fromJson(json, object : TypeToken<MutableList<Picture>>() {}.type)

    @TypeConverter
    fun fromUri(uri: Uri): String = uri.toString()

    @TypeConverter
    fun toUri(data: String): Uri = Uri.parse(data)
}