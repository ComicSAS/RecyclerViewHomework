package com.example.recyclerviewhomework.di.component

import com.example.recyclerviewhomework.di.module.ViewModelModule
import com.example.recyclerviewhomework.di.scope.ViewModelScope
import com.example.recyclerviewhomework.presentation.activities.detail.Detail
import com.example.recyclerviewhomework.presentation.activities.main.MainActivity
import dagger.Component

@ViewModelScope
@Component(modules = [ViewModelModule::class], dependencies = [InteractorComponent::class])
interface ViewModelComponent {
    fun inject(activity: MainActivity)
//    fun inject(activity: Detail)
}