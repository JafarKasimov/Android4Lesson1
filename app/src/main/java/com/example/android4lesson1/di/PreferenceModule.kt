package com.example.android4lesson1.di

import android.content.Context
import com.example.android4lesson1.data.local.preferences.PreferencesHelper
import com.example.android4lesson1.data.local.preferences.UserPreferencesData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
object PreferenceModule {

    @Singleton
    @Provides
    fun providePreferenceHelper(@ApplicationContext context: Context) =
        PreferencesHelper(context)

    @Singleton
    @Provides
    fun provideUserPreferenceData(preferencesHelper: PreferencesHelper) =
        UserPreferencesData(preferencesHelper)
}