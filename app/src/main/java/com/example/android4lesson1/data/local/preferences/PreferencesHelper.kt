package com.example.android4lesson1.data.local.preferences

import android.content.Context
import android.content.SharedPreferences

class PreferencesHelper (context: Context){


        private val preferenceHelper: SharedPreferences =
            context.getSharedPreferences("userStatus", Context.MODE_PRIVATE)

        operator fun invoke() = preferenceHelper


    private val preferences : SharedPreferences =
        context.getSharedPreferences("rickandmorty.preferences", Context.MODE_PRIVATE)

    private fun remove(key : String) {
        preferences.edit().remove(key).apply()
    }

    var isAuthorize
    get() = preferences.getBoolean("authorize",false)
    set(value) = preferences.edit().putBoolean("authorize", value).apply()
}