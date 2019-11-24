package com.example.recyclerviewhomework.di.component

import com.example.recyclerviewhomework.di.module.RepositoryModule
import com.example.recyclerviewhomework.di.scope.RepositoryScope
import com.example.recyclerviewhomework.usecases.repository.AppRepository
import dagger.Component

@RepositoryScope
@Component(modules = [RepositoryModule::class], dependencies = [ApiComponent::class, DataBaseComponent::class])
interface RepositoryComponent {
    val repository: AppRepository
}