package com.example.android4lesson1.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.android4lesson1.R
import com.example.android4lesson1.data.local.preferences.PreferencesHelper
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    @Inject
   lateinit var preferencesHelper: PreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigation()
    }

    private fun setupNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
         navController = navHostFragment.navController
        setStartDestination()
    }

    private fun setStartDestination(){
        val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)
        when{
            !preferencesHelper.isAuthorize -> {
                navGraph.setStartDestination(R.id.singFlowFragment)
            }
            else -> {
                navGraph.setStartDestination(R.id.homeFlowFragment)
            }
        }
        navController.graph = navGraph
    }
}