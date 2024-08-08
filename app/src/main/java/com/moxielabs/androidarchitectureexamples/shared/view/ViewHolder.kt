package com.moxielabs.androidarchitectureexamples.shared.view

import com.moxielabs.androidarchitectureexamples.R
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val text: TextView? = view.findViewById(R.id.text)
}