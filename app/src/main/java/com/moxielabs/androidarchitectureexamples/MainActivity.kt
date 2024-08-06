package com.moxielabs.androidarchitectureexamples

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.moxielabs.androidarchitectureexamples.mvc.controller.MvcFragment
import com.moxielabs.androidarchitectureexamples.mvc.controller.MvpFragment
import kotlin.let

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentContainer: FragmentContainerView? = findViewById(R.id.fragment_container)
        //set up initial view for container
        fragmentContainer?.id?.let {
            supportFragmentManager.beginTransaction()
                .replace(it, MvcFragment())
                .commit()

        }

        findViewById<BottomNavigationView>(R.id.bottom_navigation)?.setOnItemSelectedListener(object : NavigationBarView.OnItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                // TODO: add relevant fragment to container on nav item click
                when (item.itemId) {
                    R.id.mvc -> {
                        fragmentContainer?.id?.let {
                            supportFragmentManager.beginTransaction()
                                .replace(it, MvcFragment())
                                .commit()
                        }
                    }
                    R.id.mvp -> {
                        fragmentContainer?.id?.let {
                            supportFragmentManager.beginTransaction()
                                .replace(it, MvpFragment())
                                .commit()
                        }
                    }
                    R.id.mvvm -> {}
                    R.id.mvi -> {}
                }
                return true
            }
        })
    }
}