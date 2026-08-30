package com.atik.coffeeshop.features.auth.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.atik.coffeeshop.ui.R
import com.atik.coffeeshop.ui.components.AuthButton
import com.atik.coffeeshop.ui.components.HeadingText
import com.atik.coffeeshop.ui.components.LoadingOverlay
import com.atik.coffeeshop.ui.utils.rememberDebouncedOnClick
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    onNavigateToRegister: () -> Unit,
    viewModel: LoginViewModel = koinViewModel()
) {
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()

    LoadingOverlay(
        isLoading = isLoading,
        message = "Loading your coffee shop..."
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(R.color.lightCream))
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HeadingText(text = "Login")
            Spacer(modifier = Modifier.height(18.dp))

            AuthButton(
                text = if (isLoading) "..." else "Login",
                enabled = !isLoading,
                onClick = { viewModel.onContinueClick(onSuccess = onLoginSuccess) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                containerColor = colorResource(R.color.green),
                contentColor = colorResource(R.color.white)
            )

            Spacer(modifier = Modifier.height(18.dp))
            TextButton(
                onClick = rememberDebouncedOnClick {
                    onNavigateToRegister()
                }
            )
            {
                Text("একাউন্ট নেই? Register")
            }
        }
    }
}


