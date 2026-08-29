package com.atik.coffeeshop.shared.di

import com.atik.coffeeshop.shared.data.preferences.UserPreferences
import com.atik.coffeeshop.shared.data.preferences.UserPreferencesImpl
import com.atik.coffeeshop.shared.data.preferences.userPreferencesDataStore
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val preferencesModule = module {
    // DataStore<Preferences> instance - Koin
    single { androidContext().userPreferencesDataStore }

    // UserPreferences abstraction -> impl
    single<UserPreferences> { UserPreferencesImpl(dataStore = get()) }
}