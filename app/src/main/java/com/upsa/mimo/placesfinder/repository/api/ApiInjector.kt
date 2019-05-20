package com.upsa.mimo.placesfinder.repository.api

import com.upsa.mimo.placesfinder.utils.Configuration
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiInjector {
    fun providesApi(): Api = Retrofit.Builder().client(OkHttpClient())
        .baseUrl(Configuration().baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(Api::class.java)
}