package com.upsa.mimo.placesfinder.ui.splash

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.upsa.mimo.placesfinder.BuildConfig
import com.upsa.mimo.placesfinder.R
import kotlinx.android.synthetic.premium.fragment_splash.*

class SplashFragment: Fragment() {

    private val router : SplashRouter by lazy { SplashRouter(findNavController()) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_splash, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        splash__tv_app_name.text = BuildConfig.APP_NAME
        Handler().postDelayed({ router.navigateToBaseActivity() }, 2000)
        loading.animate().apply {
            duration = 1000
        }
    }
}