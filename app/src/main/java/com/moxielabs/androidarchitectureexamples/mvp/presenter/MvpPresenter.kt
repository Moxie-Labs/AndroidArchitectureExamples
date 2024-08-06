package com.moxielabs.androidarchitectureexamples.mvp.presenter

import com.moxielabs.androidarchitectureexamples.mvp.MvpContract
import com.moxielabs.androidarchitectureexamples.mvp.model.FruitRepository

class MvpPresenter(override val view: MvpContract.View) : MvpContract.Presenter {
    override fun fetchList() {
        view.displayList(FruitRepository.getFruits())
    }
}