package com.moxielabs.androidarchitectureexamples.mvvm.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.moxielabs.androidarchitectureexamples.R
import com.moxielabs.androidarchitectureexamples.mvvm.viewmodel.MainViewModel

class MvvmFragment: Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_mvvm, container, false)

        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]

        viewModel.fruits.observe(viewLifecycleOwner, Observer { fruits ->

        })

        return view
    }
}