package com.upsa.mimo.placesfinder.splash

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.upsa.mimo.placesfinder.R
import kotlinx.android.synthetic.main.fragment_splash.*

class SplashFragment: Fragment() {

    private val router : SplashRouter by lazy { SplashRouter(findNavController()) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_splash, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler().postDelayed({ router.navigateToBaseActivity() }, 5000)
        loading.animate().apply {
            duration = 500
        }
    }

}