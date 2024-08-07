package com.moxielabs.androidarchitectureexamples.clean.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.moxielabs.androidarchitectureexamples.clean.domain.GetFruitsUseCase
import com.moxielabs.androidarchitectureexamples.clean.presentation.FruitViewModel

class FruitViewModelFactory(private val getFruitsUseCase: GetFruitsUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FruitViewModel::class.java)) {
            return FruitViewModel(getFruitsUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
