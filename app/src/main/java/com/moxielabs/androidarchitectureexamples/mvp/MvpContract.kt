package com.moxielabs.androidarchitectureexamples.mvp

interface MvpContract {
    interface View {
        val presenter: Presenter
        fun displayList(list: List<String>)
    }

    interface Presenter {
        val view: View
        fun fetchList()
    }
}