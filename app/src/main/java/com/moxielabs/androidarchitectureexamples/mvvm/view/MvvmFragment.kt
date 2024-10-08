package com.moxielabs.androidarchitectureexamples.mvvm.view

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.moxielabs.androidarchitectureexamples.R
import com.moxielabs.androidarchitectureexamples.shared.view.ViewHolder
import com.moxielabs.androidarchitectureexamples.mvvm.viewmodel.MvvmViewModel

class MvvmFragment: Fragment() {

    private lateinit var viewModel: MvvmViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val recycler = view.findViewById<RecyclerView>(R.id.recycler_view)
        view.findViewById<View>(R.id.background)?.setBackgroundColor(Color.CYAN)

        viewModel = ViewModelProvider(requireActivity())[MvvmViewModel::class.java]

        viewModel.fruits.observe(viewLifecycleOwner) { fruits ->
            recycler?.apply {
                layoutManager = LinearLayoutManager(this.context)

                adapter = object : RecyclerView.Adapter<ViewHolder>() {
                    override fun getItemCount(): Int = fruits.size

                    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
                        return ViewHolder(
                            LayoutInflater.from(parent.context)
                                .inflate(R.layout.shared_list_item, parent, false)
                        )
                    }

                    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                        holder.text?.text = viewModel.getFruitDisplayText(position)
                    }
                }
            }
        }



        return view
    }
}