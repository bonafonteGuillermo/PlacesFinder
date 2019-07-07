package com.upsa.mimo.placesfinder.ui.splash

import androidx.navigation.NavController

class SplashRouter(private val navController: NavController) {

    fun navigateToBaseActivity() {
        val action = SplashFragmentDirections.actionSplashFragmentToBaseActivity()
        navController.navigate(action)
    }
}