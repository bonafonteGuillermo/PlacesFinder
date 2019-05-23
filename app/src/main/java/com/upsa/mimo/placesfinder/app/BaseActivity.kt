package com.upsa.mimo.placesfinder.app

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.upsa.mimo.placesfinder.R
import kotlinx.android.synthetic.main.activity_main.*

/**
 *
 * Created by Guillermo Bonafonte Criado on 16/05/2019.
 */
class BaseActivity : AppCompatActivity() {

    private val navController : NavController by lazy { findNavController(R.id.main_nav_host_fragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_nav_view.setupWithNavController(navController)

        Log.d("->", "BaseActivity_onCreate")
    }
}