package com.moxielabs.androidarchitectureexamples.mvi.state

import com.moxielabs.androidarchitectureexamples.shared.model.Fruit

sealed class FruitState {
    data object Loading : FruitState()
    data class Loaded(val fruits: List<Fruit>) : FruitState()
}