package com.moxielabs.androidarchitectureexamples.clean.data

import com.moxielabs.androidarchitectureexamples.shared.model.Fruit

sealed class FruitState {
    object Loading : FruitState()
    data class Loaded(val fruits: List<Fruit>) : FruitState()
}