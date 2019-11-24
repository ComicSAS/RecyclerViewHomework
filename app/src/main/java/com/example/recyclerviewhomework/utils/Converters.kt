package com.example.recyclerviewhomework.utils

import android.net.Uri
import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun fromUri(uri: Uri): String = uri.toString()

    @TypeConverter
    fun toUri(data: String): Uri = Uri.parse(data)
}