package com.doga.shoppingcardassignmentsystem.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.doga.shoppingcardassignmentsystem.R

import com.doga.shoppingcardassignmentsystem.common.viewBinding
import com.doga.shoppingcardassignmentsystem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        NavigationUI.setupWithNavController(binding.bottomNav, navHostFragment.navController)

        navHostFragment.navController.addOnDestinationChangedListener { _, destination_, _ ->

            when (destination_.id) {
                R.id.addProductFragment,
                R.id.editProductFragment,
                R.id.cardAssignmentFragment -> {
                    binding.bottomNav.isGone = false
                }

                else -> {
                    binding.bottomNav.isGone = true
                }
            }

        }
    }
}