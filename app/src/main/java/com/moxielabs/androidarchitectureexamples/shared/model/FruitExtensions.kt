package com.moxielabs.androidarchitectureexamples.shared.model

/**
 * We use an Extension function here for MVI to keep the Fruit class focused on representing the data model without adding utility or formatting logic.
 * This adheres to the Single Responsibility Principle.
 */
fun Fruit.getDisplayText(): String {
    return "$taste $color $name"
}
