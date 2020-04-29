package com.example.lab3onkt.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab3onkt.R


import android.os.PersistableBundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.lab3onkt.fragment.FragmentPost

import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main)
    }
    private val fragmentPage: FragmentPost? = FragmentPost.newInstance(true)
    private val fragmentLike: FragmentPost? = FragmentPost.newInstance(false)
    private var fm: FragmentManager? = null
    var active: Fragment = fragmentPage as Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fm = supportFragmentManager
        fm!!.beginTransaction().add(R.id.fragment_container, fragmentLike as Fragment, "2").hide(fragmentLike).commit()
        fm!!.beginTransaction().add(R.id.fragment_container, fragmentPage as Fragment, "1").commit()
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.nav_bar)
        bottomNavigationView.setOnNavigationItemSelectedListener(object : BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.action_list -> {
                        fm!!.beginTransaction().hide(active).show(fragmentPage).commit()
                        active = fragmentPage
                        return true
                    }
                    R.id.action_favorite -> {
                        fm!!.beginTransaction().hide(active).show(fragmentLike).commit()
                        active = fragmentLike
                        return true
                    }
                }
                return false
            }
        })
        if (savedInstanceState == null) {
            bottomNavigationView.setSelectedItemId(R.id.action_list)
        }
    }

    fun onPostLike() {
        fragmentPage?.updatePage()
        fragmentLike?.updateLike()
    }

}