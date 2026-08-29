package com.atik.coffeeshop.features.auth.presentation

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
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    fun onContinueClick(onSuccess: () -> Unit) {
        viewModelScope.launch {
            _isLoading.value = true
            delay(600L.milliseconds)

            userPreferences.setOnboardingCompleted(true)
            userPreferences.setLoggedIn(true)

            _isLoading.value = false
            onSuccess()
        }
    }
}