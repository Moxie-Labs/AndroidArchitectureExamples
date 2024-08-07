package com.moxielabs.androidarchitectureexamples.clean.data

import com.moxielabs.androidarchitectureexamples.shared.model.Fruit
import com.moxielabs.androidarchitectureexamples.clean.domain.FruitRepository

class FruitRepositoryImpl(private val fruitDataSource: FruitDataSource) : FruitRepository {
    override suspend fun getFruits(): List<Fruit> {
        return fruitDataSource.getFruits()
    }
}
