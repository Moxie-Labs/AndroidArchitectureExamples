package com.moxielabs.androidarchitectureexamples.mvi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moxielabs.androidarchitectureexamples.mvi.intent.FruitIntent
import com.moxielabs.androidarchitectureexamples.mvi.state.FruitState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MviViewModel : ViewModel() {

    private val fruitRepository = com.moxielabs.androidarchitectureexamples.shared.network.FruitRepository
    private val _state = MutableLiveData<FruitState>()
    val state: LiveData<FruitState> get() = _state

    fun processIntent(intent: FruitIntent) {
        when (intent) {
            is FruitIntent.LoadFruits -> fetchFruits()
        }
    }

    private fun fetchFruits() {
        viewModelScope.launch {
            _state.value = FruitState.Loading
            val fruits = withContext(Dispatchers.IO) {
                fruitRepository.getFruits()
            }
            _state.value = FruitState.Loaded(fruits)
        }
    }
}
