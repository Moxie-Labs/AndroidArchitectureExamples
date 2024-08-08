package com.moxielabs.androidarchitectureexamples

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.moxielabs.androidarchitectureexamples.mvc.MvcFragment
import com.moxielabs.androidarchitectureexamples.mvi.view.MviFragment
import com.moxielabs.androidarchitectureexamples.mvp.view.MvpFragment
import kotlin.let
import com.moxielabs.androidarchitectureexamples.mvvm.view.MvvmFragment

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

        findViewById<BottomNavigationView>(R.id.bottom_navigation)?.setOnItemSelectedListener(
            object : NavigationBarView.OnItemSelectedListener {
                override fun onNavigationItemSelected(item: MenuItem): Boolean {
                    fragmentContainer?.id?.let { fragmentContainerId ->
                        supportFragmentManager.beginTransaction().apply {
                            when (item.itemId) {
                                R.id.mvc -> {
                                    replace(fragmentContainerId, MvcFragment())
                                }

                                R.id.mvp -> {
                                    replace(fragmentContainerId, MvpFragment())
                                }

                                R.id.mvvm -> {
                                    replace(fragmentContainerId, MvvmFragment())
                                }

                                R.id.mvi -> {
                                    replace(fragmentContainerId, MviFragment())
                                }
                            }
                        }.commit()
                    }
                    return true
                }
            }
        )
    }
}