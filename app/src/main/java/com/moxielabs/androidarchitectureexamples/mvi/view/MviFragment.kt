package com.moxielabs.androidarchitectureexamples.mvi.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.moxielabs.androidarchitectureexamples.R
import com.moxielabs.androidarchitectureexamples.mvi.intent.FruitIntent
import com.moxielabs.androidarchitectureexamples.mvi.model.getDisplayText
import com.moxielabs.androidarchitectureexamples.mvi.state.FruitState
import com.moxielabs.androidarchitectureexamples.mvi.viewmodel.MviViewModel
import com.moxielabs.androidarchitectureexamples.mvp.view.ViewHolder

class MviFragment : Fragment() {

    private lateinit var viewModel: MviViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_architecture, container, false)

        viewModel = ViewModelProvider(requireActivity())[MviViewModel::class.java]

        viewModel.state.observe(viewLifecycleOwner) { state ->
            render(state, view)
        }

        view.findViewById<RecyclerView>(R.id.recycler_view)?.apply {
            layoutManager = LinearLayoutManager(this.context)
        }

        viewModel.processIntent(FruitIntent.LoadFruits)

        return view
    }

    private fun render(state: FruitState, view: View) {
        if (state is FruitState.Loaded) {
            view.findViewById<RecyclerView>(R.id.recycler_view)?.adapter = object : RecyclerView.Adapter<ViewHolder>() {
                override fun getItemCount(): Int = state.fruits.size

                override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
                    return ViewHolder(
                        LayoutInflater.from(parent.context)
                            .inflate(R.layout.shared_list_item, parent, false)
                    )
                }

                override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                    holder.text?.text = state.fruits[position].getDisplayText()
                }
            }
        }
    }
}
