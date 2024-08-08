package com.moxielabs.androidarchitectureexamples.mvi.intent

sealed class FruitIntent {
    data object LoadFruits : FruitIntent()
}
