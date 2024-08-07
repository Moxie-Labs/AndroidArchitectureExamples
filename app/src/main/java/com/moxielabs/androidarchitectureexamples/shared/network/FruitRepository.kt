package com.moxielabs.androidarchitectureexamples.shared.network

import com.moxielabs.androidarchitectureexamples.shared.model.Fruit

object FruitRepository {

    fun getFruits(): List<Fruit> {
        return listOf(
            Fruit(name = "Apple", color = "Red", taste = "Sweet"),
            Fruit(name = "Banana", color = "Yellow", taste = "Sweet"),
            Fruit(name = "Orange", color = "Orange", taste = "Citrus"),
            Fruit(name = "Lemon", color = "Yellow", taste = "Sour"),
            Fruit(name = "Grapes", color = "Purple", taste = "Sweet")
        )
    }
}