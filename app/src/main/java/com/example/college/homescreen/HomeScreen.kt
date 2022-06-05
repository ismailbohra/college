package com.example.college.homescreen

import android.os.Bundle
import android.provider.SyncStateContract.Helpers.update
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.example.college.Adapters.recyclerViewAdapter
import com.example.college.R
import com.example.college.testModel.Values
import com.example.college.testModel.test
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_news.*
import kotlinx.android.synthetic.main.home_screen.*
import kotlinx.android.synthetic.main.recycler_listview_layout.*

class HomeScreen : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_screen)
        setSupportActionBar(findViewById(R.id.toolBar))

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.fragmentHome, R.id.fragmentNews, R.id.fragmentClub, R.id.fragmentProfile),
            Navigationdrawer
        )
        val navBar  = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        navBar.getOrCreateBadge(R.id.fragmentNews).number = test.value?.int ?: 5


        setupActionBarWithNavController(navController, appBarConfiguration)

        bottomNavigationView.setupWithNavController(navController)
        nav_drawer.setupWithNavController(navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.fragmentHome -> {
                val navBar  = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
                navBar.removeBadge(R.id.fragmentHome)

            }
            R.id.fragmentNews -> {
                val navBar  = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
                navBar.removeBadge(R.id.fragmentNews)
            }
            R.id.fragmentClub -> {
                val navBar  = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
                navBar.removeBadge(R.id.fragmentClub)
            }

            R.id.fragmentProfile -> {
                val navBar  = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
                navBar.removeBadge(R.id.fragmentProfile)
            }
        }
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        MenuCompat.setGroupDividerEnabled(menu, true)



        return super.onCreateOptionsMenu(menu)
    }

}