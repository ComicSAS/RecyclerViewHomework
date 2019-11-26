package com.example.recyclerviewhomework.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerviewhomework.App
import com.example.recyclerviewhomework.di.component.ViewModelComponent

abstract class BaseActivity : AppCompatActivity() {
    /**
     * @param component
     */
    abstract fun injectDependency(component: ViewModelComponent)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createDaggerDependencies()
    }

    private fun createDaggerDependencies() {
        injectDependency((application as App).getViewModelComponent())
    }
}