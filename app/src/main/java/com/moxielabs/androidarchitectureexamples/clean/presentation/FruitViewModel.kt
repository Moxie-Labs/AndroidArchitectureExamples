package com.moxielabs.androidarchitectureexamples.clean.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moxielabs.androidarchitectureexamples.clean.data.FruitState
import com.moxielabs.androidarchitectureexamples.clean.domain.GetFruitsUseCase
import kotlinx.coroutines.launch

class FruitViewModel(private val getFruitsUseCase: GetFruitsUseCase) : ViewModel() {

    private val _fruitState = MutableLiveData<FruitState>()
    val fruitState: LiveData<FruitState> get() = _fruitState

    fun loadFruits() {
        viewModelScope.launch {
            _fruitState.value = FruitState.Loading
            val fruits = getFruitsUseCase()
            _fruitState.value = FruitState.Loaded(fruits)
        }
    }
}
