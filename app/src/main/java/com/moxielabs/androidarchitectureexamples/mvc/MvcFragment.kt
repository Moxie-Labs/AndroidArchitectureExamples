package com.moxielabs.androidarchitectureexamples.mvc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.moxielabs.androidarchitectureexamples.R
import com.moxielabs.androidarchitectureexamples.shared.model.getDisplayText
import com.moxielabs.androidarchitectureexamples.shared.network.FruitRepository
import com.moxielabs.androidarchitectureexamples.shared.view.Adapter
import kotlin.apply

class MvcFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.recycler_view)?.apply {
            layoutManager = LinearLayoutManager(this.context)

            adapter = Adapter(
                FruitRepository.getFruits().map { it.getDisplayText() }
            )
        }
    }
}