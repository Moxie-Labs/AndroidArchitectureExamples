package com.moxielabs.androidarchitectureexamples.mvp.view

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.moxielabs.androidarchitectureexamples.R
import com.moxielabs.androidarchitectureexamples.mvp.MvpContract
import com.moxielabs.androidarchitectureexamples.mvp.presenter.MvpPresenter
import com.moxielabs.androidarchitectureexamples.shared.view.Adapter

class MvpFragment : Fragment(), MvpContract.View {

    override val presenter: MvpContract.Presenter = MvpPresenter(this)

    private var recyclerView: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //change background color to show that we are changing screens
        view.findViewById<View>(R.id.background)?.setBackgroundColor(Color.LTGRAY)

        recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView?.layoutManager = LinearLayoutManager(this.context)

        presenter.fetchList()
    }

    override fun displayList(list: List<String>) {
        recyclerView?.adapter = Adapter(list)
    }
}