package com.upsa.mimo.placesfinder.di

import android.content.Context
import com.upsa.mimo.placesfinder.rx.AppSchedulers
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

object NetworkInjector {
    fun provideHttpClient(logger: HttpLoggingInterceptor, cache: Cache): OkHttpClient {
        return OkHttpClient().newBuilder()
            .addInterceptor(logger)
            .cache(cache)
            .build()
    }

    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    fun provideCache(file: File): Cache {
        return Cache(file, (10 * 10 * 1000).toLong())
    }

    fun provideCacheFile(context: Context): File {
        return context.filesDir
    }

    fun provideRxAdapter(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.createWithScheduler(AppSchedulers().internetSchedulers)
    }


    fun provideGsonClient(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }
}