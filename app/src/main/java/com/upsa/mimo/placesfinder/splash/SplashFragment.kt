package com.upsa.mimo.placesfinder.splash

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.upsa.mimo.placesfinder.R

class SplashFragment: Fragment() {

    private val router : SplashRouter by lazy { SplashRouter(findNavController()) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_splash, container, false)

    override fun onStart() {
        super.onStart()

        Handler().postDelayed({ router.navigateToMainScreen() }, 1500)
    }
}