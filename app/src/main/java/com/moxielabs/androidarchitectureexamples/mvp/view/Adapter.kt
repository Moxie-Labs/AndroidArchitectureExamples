package com.moxielabs.androidarchitectureexamples.mvp.view

import android.view.LayoutInflater
import com.moxielabs.androidarchitectureexamples.R
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.moxielabs.androidarchitectureexamples.shared.models.Fruit

class Adapter(val list: List<Fruit>): RecyclerView.Adapter<ViewHolder>() {
    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.mvc_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text?.text = list[position].displayText()
    }
}