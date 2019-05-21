package com.upsa.mimo.placesfinder.repository

import android.location.Location
import com.upsa.mimo.placesfinder.BuildConfig
import com.upsa.mimo.placesfinder.database.AppDatabase
import com.upsa.mimo.placesfinder.model.Place
import com.upsa.mimo.placesfinder.model.Status
import com.upsa.mimo.placesfinder.repository.api.Api
import com.upsa.mimo.placesfinder.repository.preferences.SharedPrefs
import com.upsa.mimo.placesfinder.utils.getLocationQueryParam
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

/**
 *
 * Created by Guillermo Bonafonte Criado on 16/05/2019.
 */
class Repository(
    private val api: Api,
    private val localStorage: AppDatabase,
    private val prefs: SharedPrefs
) : IRepository {
    override fun getNearByPlaces(location: Location): Observable<List<Place>> {
        val publisher = PublishSubject.create<List<Place>>()
        val results =
            api.getPlaces(location.getLocationQueryParam(), "1500", "restaurants", BuildConfig.GoogleSecAPIKEY)

        val disposable = results.subscribe(
            {
                if (it.status == Status.OK) {
                    publisher.onNext(it.results)
                } else {
                    publisher.onError(Throwable(it.status.toString()))
                }
            },
            {
                publisher.onError(it)
            }
        )
        return publisher
    }

}