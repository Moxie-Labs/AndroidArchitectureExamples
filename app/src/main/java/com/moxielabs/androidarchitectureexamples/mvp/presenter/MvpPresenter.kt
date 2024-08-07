package com.moxielabs.androidarchitectureexamples.mvp.presenter

import com.moxielabs.androidarchitectureexamples.mvp.MvpContract
import com.moxielabs.androidarchitectureexamples.shared.model.Fruit
import com.moxielabs.androidarchitectureexamples.shared.network.FruitRepository

class MvpPresenter(override val view: MvpContract.View) : MvpContract.Presenter {
    override fun fetchList() {
        view.displayList(FruitRepository.getFruits().map { it.displayText() })
    }

    fun Fruit.displayText(): String {
        return "${this.taste} ${this.color} ${this.name}"
    }
}