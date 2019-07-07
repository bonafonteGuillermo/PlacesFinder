package com.upsa.mimo.placesfinder.app

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.upsa.mimo.placesfinder.R
import com.upsa.mimo.placesfinder.ui.settings.SettingsActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 *
 * Created by Guillermo Bonafonte Criado on 16/05/2019.
 */
class BaseActivity : AppCompatActivity() {

    private val navController: NavController by lazy { findNavController(R.id.main_nav_host_fragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        bottom_nav_view.setUpBottomNavigationView()
    }

    private fun BottomNavigationView.setUpBottomNavigationView() {
        setupWithNavController(navController)
        setOnNavigationItemReselectedListener {}
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> navigateToSettings()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun navigateToSettings() {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }
}