package com.upsa.mimo.placesfinder.di

import com.upsa.mimo.placesfinder.data.api.Api
import com.upsa.mimo.placesfinder.utils.Configuration
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiClientInjector {
    fun providesApiClient(client: OkHttpClient, gson: GsonConverterFactory, rxAdapter: RxJava2CallAdapterFactory): Api {
        return Retrofit.Builder()
            .client(client)
            .baseUrl(Configuration().baseUrl)
            .addConverterFactory(gson)
            .addCallAdapterFactory(rxAdapter)
            .build()
            .create(Api::class.java)
    }
}