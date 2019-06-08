package com.upsa.mimo.placesfinder.rx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class AppSchedulers : ISchedulers{

    var internetExecutor : Executor = Executors.newCachedThreadPool()
    var internetSchedulers = io.reactivex.schedulers.Schedulers.from(internetExecutor)

    override fun backgroundThread(): Scheduler = io.reactivex.schedulers.Schedulers.io()
    override fun uiThread(): Scheduler = AndroidSchedulers.mainThread()
    override fun internet(): Scheduler = internetSchedulers
}