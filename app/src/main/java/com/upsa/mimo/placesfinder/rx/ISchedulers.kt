package com.upsa.mimo.placesfinder.rx

import io.reactivex.Scheduler

/**
 *
 * Created by Guillermo Bonafonte Criado on 20/05/2019.
 */
interface ISchedulers {
    fun backgroundThread() : Scheduler
    fun uiThread() : Scheduler
    fun internet() : Scheduler
}