package com.upsa.mimo.placesfinder.rx

import com.upsa.mimo.placesfinder.app.Injector

class RxInjector {
    fun providesRx() = AppSchedulers()
}