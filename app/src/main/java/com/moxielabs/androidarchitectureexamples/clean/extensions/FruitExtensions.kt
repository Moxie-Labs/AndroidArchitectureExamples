package com.moxielabs.androidarchitectureexamples.clean.extensions

import com.moxielabs.androidarchitectureexamples.shared.model.Fruit

fun Fruit.getDisplayText(): String {
    return "$taste $color $name"
}
