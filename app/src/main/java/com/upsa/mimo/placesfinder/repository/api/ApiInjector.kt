package com.upsa.mimo.placesfinder.repository.api

import com.upsa.mimo.placesfinder.utils.Configuration
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiInjector {
    fun providesApi(client: OkHttpClient, gson: GsonConverterFactory, rxAdapter: RxJava2CallAdapterFactory): Api {
        return Retrofit.Builder()
            .client(client)
            .baseUrl(Configuration().baseUrl)
            .addConverterFactory(gson)
            .addCallAdapterFactory(rxAdapter)
            .build()
            .create(Api::class.java)
    }
}