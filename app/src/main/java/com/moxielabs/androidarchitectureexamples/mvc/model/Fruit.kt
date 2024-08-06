package com.moxielabs.androidarchitectureexamples.mvc.model

data class Fruit(
    val name: String,
    val color: String,
    val taste: String
) {
    fun displayText(): String {
        return "${this.taste} ${this.color} ${this.name}"
    }
}