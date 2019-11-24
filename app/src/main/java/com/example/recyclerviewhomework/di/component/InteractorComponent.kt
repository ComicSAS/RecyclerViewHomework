package com.example.recyclerviewhomework.di.component

import com.example.recyclerviewhomework.di.module.InteractorModule
import com.example.recyclerviewhomework.di.scope.InteractorScope
import com.example.recyclerviewhomework.usecases.Interactor
import dagger.Component

@InteractorScope
@Component(modules = [InteractorModule::class], dependencies = [RepositoryComponent::class])
interface InteractorComponent {
    val interactor: Interactor
}