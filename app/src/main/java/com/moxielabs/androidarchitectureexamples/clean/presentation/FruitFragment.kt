package com.moxielabs.androidarchitectureexamples.clean.presentation

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
import com.moxielabs.androidarchitectureexamples.clean.data.FruitState
import com.moxielabs.androidarchitectureexamples.clean.extensions.getDisplayText

class FruitFragment : Fragment() {

    private lateinit var viewModel: FruitViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_architecture, container, false)

        viewModel = ViewModelProvider(requireActivity())[FruitViewModel::class.java]

        viewModel.fruitState.observe(viewLifecycleOwner, Observer { state ->
            render(state, view)
        })

        view.findViewById<RecyclerView>(R.id.recycler_view)?.apply {
            layoutManager = LinearLayoutManager(this.context)
        }

        viewModel.loadFruits()

        return view
    }

    private fun render(state: FruitState, view: View) {
        if (state is FruitState.Loaded) {
            view.findViewById<RecyclerView>(R.id.recycler_view)?.adapter = object : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
                override fun getItemCount(): Int = state.fruits.size

                override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
                    return RecyclerView.ViewHolder(
                        LayoutInflater.from(parent.context)
                            .inflate(R.layout.shared_list_item, parent, false)
                    )
                }

                override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
                    holder.text?.text = state.fruits[position].getDisplayText()
                }
            }
        }
    }
}
