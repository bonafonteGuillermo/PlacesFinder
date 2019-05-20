package com.upsa.mimo.placesfinder.repository

import com.upsa.mimo.placesfinder.database.AppDatabase
import com.upsa.mimo.placesfinder.repository.api.Api
import com.upsa.mimo.placesfinder.repository.preferences.SharedPrefs

/**
 *
 * Created by Guillermo Bonafonte Criado on 16/05/2019.
 */
class Repository(
    private val api: Api,
    private val localStorage : AppDatabase,
    private val prefs: SharedPrefs
) : IRepository {

}