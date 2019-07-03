package com.upsa.mimo.placesfinder.ui.settings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.upsa.mimo.placesfinder.R
import com.upsa.mimo.placesfinder.app.injector

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val repository = injector.repositoryInjector.providesRepository()
        
    }
}
