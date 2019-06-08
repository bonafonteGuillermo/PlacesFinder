package com.upsa.mimo.placesfinder.data.repository

import android.location.Location
import com.upsa.mimo.placesfinder.BuildConfig
import com.upsa.mimo.placesfinder.data.database.AppDatabase
import com.upsa.mimo.placesfinder.model.Place
import com.upsa.mimo.placesfinder.model.Status
import com.upsa.mimo.placesfinder.data.api.Api
import com.upsa.mimo.placesfinder.data.preferences.SharedPrefs
import com.upsa.mimo.placesfinder.rx.AppSchedulers
import com.upsa.mimo.placesfinder.utils.getLocationQueryParam
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.subjects.SingleSubject

/**
 *
 * Created by Guillermo Bonafonte Criado on 16/05/2019.
 */
class Repository private constructor(
    private val api: Api,
    private val localStorage: AppDatabase,
    private val prefs: SharedPrefs,
    private val schedulers: AppSchedulers
) : IRepository {

    companion object {
        @Volatile
        private var INSTANCE: Repository? = null

        operator fun invoke(
            api: Api,
            localStorage: AppDatabase,
            prefs: SharedPrefs,
            schedulers: AppSchedulers
        ): IRepository =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: Repository(
                        api,
                        localStorage,
                        prefs,
                        schedulers
                    ).also { INSTANCE = it }
            }
    }

    override fun getNearByPlaces(location: Location): Single<List<Place>> {
        val publisher = SingleSubject.create<List<Place>>()
        val results =
            api.getPlaces(location.getLocationQueryParam(), "1500", "restaurants", BuildConfig.GoogleSecAPIKEY)

        val disposable = results.subscribe(
            {
                if (it.status == Status.OK) {
                    publisher.onSuccess(it.results)
                } else {
                    publisher.onError(Throwable(it.status.toString()))
                }
            },
            { publisher.onError(it) }
        )
        return publisher
    }

    override fun addPlaceToLocalStorage(place: Place): Completable {
        return Completable.fromCallable {
            localStorage.placesDao().insertPlace(place)
        }
            .subscribeOn(schedulers.backgroundThread())
            .observeOn(schedulers.uiThread())
    }

    override fun getPlaceFromLocalStorage(placeId: String): Single<Place?> {
        return Single.fromCallable {
            localStorage.placesDao().getPlace(placeId)

        }
            .subscribeOn(schedulers.backgroundThread())
            .observeOn(schedulers.uiThread())
            .doOnError {  }
    }

    override fun removePlaceFromLocalStorage(place: Place) : Single<Int> {
        return Single.fromCallable {
            localStorage.placesDao().deletePlace(place)
        }
            .subscribeOn(schedulers.backgroundThread())
            .observeOn(schedulers.uiThread())
    }
}