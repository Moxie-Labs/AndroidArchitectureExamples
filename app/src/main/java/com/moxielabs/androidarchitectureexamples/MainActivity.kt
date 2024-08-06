package com.moxielabs.androidarchitectureexamples

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentContainer: FragmentContainerView? = findViewById(R.id.fragment_container)
        findViewById<BottomNavigationView>(R.id.bottom_navigation)?.setOnItemSelectedListener( object : NavigationBarView.OnItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                // TODO: add relevant fragment to container on nav item click
                when (item.itemId) {
                    R.id.mvc -> {}
                    R.id.mvp -> {}
                    R.id.mvvm -> {}
                    R.id.mvi -> {}
                }
                return true
            }
        })
    }
}