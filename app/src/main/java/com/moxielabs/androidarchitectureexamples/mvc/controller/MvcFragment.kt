package com.moxielabs.androidarchitectureexamples.mvc.controller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.moxielabs.androidarchitectureexamples.R
import com.moxielabs.androidarchitectureexamples.mvc.model.FruitRepository
import kotlin.apply

class MvcFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mvc, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fruits = FruitRepository.getFruits()

        view.findViewById<RecyclerView>(R.id.recycler_view)?.apply {
            layoutManager = LinearLayoutManager(this.context)

            adapter = object : RecyclerView.Adapter<ViewHolder>() {
                override fun getItemCount(): Int = fruits.size

                override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
                    return ViewHolder(
                        LayoutInflater.from(parent.context)
                            .inflate(R.layout.mvc_list_item, parent, false)
                    )
                }

                override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                    holder.text.text = fruits[position].displayText()
                }
            }
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val text: TextView = view.findViewById(R.id.text)
    }
}