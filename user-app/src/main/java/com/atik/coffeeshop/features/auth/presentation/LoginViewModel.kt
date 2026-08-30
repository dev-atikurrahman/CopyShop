package com.atik.coffeeshop.features.auth.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atik.coffeeshop.shared.data.preferences.UserPreferences
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

class LoginViewModel(
    private val userPreferences: UserPreferences
) : ViewModel() {
    companion object {
        const val AUTH_TAG = "AUTH_DEBUG"
    }
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    fun onContinueClick(onSuccess: () -> Unit) {
        viewModelScope.launch {
            Log.d(AUTH_TAG, "onContinueClick: START")
            _isLoading.value = true
            delay(600L.milliseconds)

            Log.d(AUTH_TAG, "onContinueClick: before setOnboardingCompleted")
            userPreferences.setOnboardingCompleted(true)
            Log.d(AUTH_TAG, "onContinueClick: before setLoggedIn (DataStore write done")
            userPreferences.setLoggedIn(true)

            _isLoading.value = false
            Log.d(AUTH_TAG, "onContinueClick: calling onSuccess()")
            onSuccess()
            Log.d(AUTH_TAG, "onContinueClick: calling onSuccess() returned")
        }
    }
}