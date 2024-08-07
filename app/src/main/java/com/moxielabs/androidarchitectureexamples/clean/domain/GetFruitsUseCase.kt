package com.moxielabs.androidarchitectureexamples.clean.domain

import com.moxielabs.androidarchitectureexamples.shared.model.Fruit
import com.moxielabs.androidarchitectureexamples.shared.network.FruitRepository

class GetFruitsUseCase(private val fruitRepository: FruitRepository) {
    suspend operator fun invoke(): List<Fruit> {
        return fruitRepository.getFruits()
    }
}
