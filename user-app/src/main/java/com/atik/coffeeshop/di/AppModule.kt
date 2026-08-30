package com.atik.coffeeshop.di

import com.atik.coffeeshop.features.auth.presentation.LoginViewModel
import com.atik.coffeeshop.features.home.explore.presentation.SharedViewModel
import com.atik.coffeeshop.navigation.SplashViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { LoginViewModel(userPreferences = get()) }
    viewModel { SplashViewModel(userPreferences = get()) }
    viewModel { SharedViewModel() }
}