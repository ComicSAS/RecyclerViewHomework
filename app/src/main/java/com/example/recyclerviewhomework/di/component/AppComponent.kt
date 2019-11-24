package com.example.recyclerviewhomework.di.component

import com.example.recyclerviewhomework.di.module.AppModule
import com.example.recyclerviewhomework.di.scope.AppScope
import com.google.gson.Gson
import dagger.Component

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {
    val gson: Gson
}