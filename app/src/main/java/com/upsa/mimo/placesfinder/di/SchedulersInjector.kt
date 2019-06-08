package com.upsa.mimo.placesfinder.di

import com.upsa.mimo.placesfinder.rx.AppSchedulers

object SchedulersInjector {
    fun providesSchedulers() = AppSchedulers()
}