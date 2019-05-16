package com.upsa.mimo.placesfinder.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.upsa.mimo.placesfinder.R

/**
 *
 * Created by Guillermo Bonafonte Criado on 16/05/2019.
 */
class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}