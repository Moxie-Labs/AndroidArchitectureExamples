package com.moxielabs.androidarchitectureexamples.clean.data

import com.moxielabs.androidarchitectureexamples.shared.model.Fruit

class RemoteFruitDataSource : FruitDataSource {
    override suspend fun getFruits(): List<Fruit> {
        // Simulate a network call or database fetch
        return listOf(
            Fruit("Sweet", "Red", "Apple"),
            Fruit("Sour", "Yellow", "Lemon")
        )
    }
}
