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
    var nextFrag = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navigation = findViewById<BottomNavigationView>(R.id.nav_view)

        val navListener = setListeners()

        navigation.setOnNavigationItemSelectedListener(navListener)

        loadFrag(HomeFragment(), nextFrag, R.id.navigation_home)
    }


    fun loadFrag(fragment: Fragment, nextFrag: Int, currentFrag: Int?) {

        when (nextFrag) {
            0 -> loadAnim(fragment!!, R.anim.enter_from_right, R.anim.exit_from_right)

            1 ->
                if (currentFrag == R.id.navigation_home) {
                    loadAnim(fragment, R.anim.enter_from_left, R.anim.exit_from_left)

                } else if (currentFrag == R.id.navigation_notifications) {

                    loadAnim(fragment, R.anim.enter_from_right, R.anim.exit_from_right)
                }
            2 -> loadAnim(fragment, R.anim.enter_from_left, R.anim.exit_from_left)

        }


    }

    fun loadAnim(fragment: Fragment, enterAnim: Int, exitAnim: Int) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(enterAnim, exitAnim)
            .replace(R.id.nav_host_fragment, fragment!!)
            .commit()
    }

    fun setListeners(): BottomNavigationView.OnNavigationItemSelectedListener {
        val mOnNavigationItemSelectedListener =
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.navigation_home -> {
                        loadFrag(HomeFragment(), nextFrag, R.id.navigation_home)
                        nextFrag = 0

                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.navigation_dashboard -> {

                        loadFrag(DashboardFragment(), nextFrag, R.id.navigation_dashboard)
                        nextFrag = 1
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.navigation_notifications -> {


                        loadFrag(NotificationsFragment(), nextFrag, R.id.navigation_notifications)
                        nextFrag = 2
                        return@OnNavigationItemSelectedListener true
                    }

                }
                false
            }
        return mOnNavigationItemSelectedListener
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (nextFrag != null)
            outState.putInt("FragmentID", nextFrag!!)
        Log.e("currentFrag", nextFrag!!.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val fragID = savedInstanceState.getInt("FragmentID")
        when (fragID) {
            0 -> loadFrag(HomeFragment(), nextFrag, null)
            1 -> loadFrag(DashboardFragment(), nextFrag, null)
            2 -> loadFrag(NotificationsFragment(), nextFrag, null)
        }
    }

}
