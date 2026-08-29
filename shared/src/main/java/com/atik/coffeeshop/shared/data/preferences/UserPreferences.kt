package com.atik.coffeeshop.shared.data.preferences

import kotlinx.coroutines.flow.Flow

interface UserPreferences {
    val isOnboardingCompleted: Flow<Boolean>
    suspend fun setOnboardingCompleted(completed: Boolean)
    val isLoggedIn: Flow<Boolean>
    suspend fun setLoggedIn(loggedIn: Boolean)
    suspend fun clearSession()
}