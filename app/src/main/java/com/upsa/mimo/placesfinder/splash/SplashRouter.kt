package com.upsa.mimo.placesfinder.splash

import androidx.navigation.NavController
import com.upsa.mimo.placesfinder.R

class SplashRouter(private val navController: NavController) {

    fun navigateToMainScreen() {
        navController.navigate(R.id.action_splashFragment_to_baseActivity)
    }
}
