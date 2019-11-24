package com.example.recyclerviewhomework.di.module

import android.app.Application
import com.example.recyclerviewhomework.di.scope.AppScope
import com.google.gson.Gson
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val app: Application) {

    @Provides
    @AppScope
    fun provideApplication(): Application = app

    @Provides
    @AppScope
    fun provideGson(): Gson = Gson()
}