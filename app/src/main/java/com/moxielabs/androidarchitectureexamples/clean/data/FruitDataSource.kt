package com.moxielabs.androidarchitectureexamples.clean.data

import com.moxielabs.androidarchitectureexamples.shared.model.Fruit

interface FruitDataSource {
    suspend fun getFruits(): List<Fruit>
}
