package com.moxielabs.androidarchitectureexamples.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moxielabs.androidarchitectureexamples.shared.models.Fruit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {

    private val fruitRepository =
        com.moxielabs.androidarchitectureexamples.shared.network.FruitRepository
    private val _fruits = MutableLiveData<List<Fruit>>()
    val fruits: LiveData<List<Fruit>> get() = _fruits

    init {
        fetchFruits()
    }

    fun getFruitDisplayText(position: Int): String {
        val fruit = fruits.value?.get(position)
        return "${fruit?.taste} ${fruit?.color} ${fruit?.name}"
    }

    private fun fetchFruits() {
        viewModelScope.launch {
            val fruitsList = withContext(Dispatchers.IO) {
                fruitRepository.getFruits()
            }
            _fruits.value = fruitsList
        }
    }
}