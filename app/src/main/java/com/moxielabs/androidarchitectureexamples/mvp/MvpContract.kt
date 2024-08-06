package com.moxielabs.androidarchitectureexamples.mvp

import com.moxielabs.androidarchitectureexamples.mvp.model.Fruit

interface MvpContract {
    interface View {
        val presenter: Presenter
        fun displayList(list: List<Fruit>)
    }

    interface Presenter {
        val view: View
        fun fetchList()
    }
}