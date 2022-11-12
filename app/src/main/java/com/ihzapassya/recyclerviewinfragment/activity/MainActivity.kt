package com.ihzapassya.recyclerviewinfragment.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ihzapassya.recyclerviewinfragment.R
import com.ihzapassya.recyclerviewinfragment.databinding.ActivityMainBinding
import com.ihzapassya.recyclerviewinfragment.fragment.CallFragment
import com.ihzapassya.recyclerviewinfragment.fragment.FoodFragment

class MainActivity : AppCompatActivity() {
    companion object {
        const val SELECTED_MENU = "selected_menu"
    }

    private val navView: BottomNavigationView
        get() = findViewById(R.id.nav_view)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        if (savedInstanceState != null) {
            savedInstanceState.getInt(SELECTED_MENU)
        } else {
            navView.selectedItemId = R.id.action_home
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(SELECTED_MENU, navView.selectedItemId)
    }

    private val mOnNavigationItemSelectedListener =
        object : BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.action_home -> {
                        loadFragment(FoodFragment())
                        return true
                    }
                    R.id.action_call -> {
                        loadFragment(CallFragment())
                        return true
                    }
                }
                return false
            }
        }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .replace(R.id.fr_main_container, fragment, fragment::class.java.simpleName)
            .commit()
    }
}