package com.example.recyclerviewhomework.di.module

import android.app.Application
import com.example.recyclerviewhomework.App
import com.example.recyclerviewhomework.di.scope.ViewModelScope
import com.example.recyclerviewhomework.domain.AllUserViewModel
import com.example.recyclerviewhomework.usecases.Interactor
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule(app: App) {

    internal var app: Application = app

    @Provides
    @ViewModelScope
    internal fun provideAllUserViewModel(interactor: Interactor)
            : AllUserViewModel = AllUserViewModel(app, interactor)


}