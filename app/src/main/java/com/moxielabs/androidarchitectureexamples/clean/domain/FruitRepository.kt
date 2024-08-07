package com.moxielabs.androidarchitectureexamples.clean.domain

import com.moxielabs.androidarchitectureexamples.shared.model.Fruit

interface FruitRepository {
    suspend fun getFruits(): List<Fruit>
}
