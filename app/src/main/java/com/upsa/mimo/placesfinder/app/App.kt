package com.upsa.mimo.placesfinder.app

import android.app.Application
import androidx.fragment.app.FragmentActivity
import com.upsa.mimo.placesfinder.di.Injector

/**
 *
 * Created by Guillermo Bonafonte Criado on 16/05/2019.
 */
class App : Application(){
    val injector by lazy { Injector(this) }
}

val FragmentActivity.injector : Injector
get(){
    val app = application as? App ?: throw IllegalStateException("Application must implement App")
    return app.injector
}