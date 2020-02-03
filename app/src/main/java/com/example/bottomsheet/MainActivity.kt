package com.example.bottomsheet

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.bottomsheet.ui.dashboard.DashboardFragment
import com.example.bottomsheet.ui.home.HomeFragment
import com.example.bottomsheet.ui.notifications.NotificationsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
var currentFrag=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navigation = findViewById<BottomNavigationView>(R.id.nav_view)
        val mOnNavigationItemSelectedListener =
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.navigation_home -> {
                        currentFrag = 0
                        loadFrag(HomeFragment())
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.navigation_dashboard -> {
                        currentFrag = 1

                        loadFrag(DashboardFragment())
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.navigation_notifications -> {
                        currentFrag = 2

                        loadFrag(NotificationsFragment())
                        return@OnNavigationItemSelectedListener true
                    }

                }
                false
            }
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        loadFrag(HomeFragment())

    }

    fun loadFrag(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.enter, R.anim.exit)
            .replace(R.id.nav_host_fragment, fragment!!)
            .commit()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (currentFrag != null)
            outState.putInt("FragmentID", currentFrag!!)
        Log.e("currentFrag", currentFrag!!.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val fragID=savedInstanceState.getInt("FragmentID")
        when(fragID){
            0->loadFrag(HomeFragment())
            1->loadFrag(DashboardFragment())
            2->loadFrag(NotificationsFragment())
        }
    }

}
