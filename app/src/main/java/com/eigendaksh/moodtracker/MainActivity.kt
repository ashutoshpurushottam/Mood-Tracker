package com.eigendaksh.moodtracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpNavigation()
    }

    private fun setUpNavigation() {
        findNavController(R.id.navHostFragment).setGraph(R.navigation.nav_main, intent?.extras)
    }
}
