package com.example.recyclerviewhomework.utils

import android.net.Uri
import androidx.room.TypeConverter

class PictrureConverter {
    companion object {
        @TypeConverter
        fun fromPictrure(uri: Uri): String = uri.toString()

        @TypeConverter
        fun toPictrure(data: String): Uri = Uri.parse(data)
    }
}