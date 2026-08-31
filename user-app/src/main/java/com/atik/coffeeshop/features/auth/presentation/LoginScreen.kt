package com.atik.coffeeshop.features.auth.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.atik.coffeeshop.core.VerticalSpacer
import com.atik.coffeeshop.features.auth.presentation.components.AppLogoSection
import com.atik.coffeeshop.features.auth.presentation.components.EmailTextField
import com.atik.coffeeshop.features.auth.presentation.components.PasswordTextField
import com.atik.coffeeshop.features.auth.presentation.components.RememberAndForgotSection
import com.atik.coffeeshop.features.auth.presentation.components.SocialSignInSection
import com.atik.coffeeshop.features.auth.presentation.components.TextSection
import com.atik.coffeeshop.ui.R
import com.atik.coffeeshop.ui.components.AuthButton
import com.atik.coffeeshop.ui.components.AuthSectionDivider
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
    var isRememberMeChecked by remember { mutableStateOf(false) }

    val whiteColor = colorResource(com.atik.coffeeshop.R.color.white)
    val gradient1 = colorResource(com.atik.coffeeshop.R.color.gradient1)
    val gradient2 = colorResource(com.atik.coffeeshop.R.color.gradient2)
    val topLeft = Color(0xFF8B00FF)
    val topLeft2 =   Color(0xFFB000FF).copy(alpha = 0.75f)
    val topCenter = Color(0xFFFF007A)
    val topCenter2 = Color(0xFFFF3D9A).copy(alpha = 0.65f)
    val topRight = Color(0xFFFF5A00)
    val topRight2 = Color(0xFFFFB300).copy(alpha = 0.7f)

    val topLeftColor = Brush.radialGradient(
        colors = listOf(
            topLeft,
            topLeft2,
            Color.Transparent,
        ),
        center = Offset(
            x = 0f,
            y = 0f
        ),
        radius = 900f
    )

    val topCenterColor = Brush.radialGradient(
        colors = listOf(
            topCenter,
            topCenter2,
            Color.Transparent,
        ),
        center = Offset(
            x = 500f,
            y = 0f
        ),
        radius = 850f
    )

    val topRightColor = Brush.radialGradient(
        colors = listOf(
            topRight,
            topRight2,
            Color.Transparent,
        ),
        center = Offset(
            x = 1000f,
            y = 50f
        ),
        radius = 800f
    )

    val authBackgroundGradient = Brush.verticalGradient(
        colors = listOf(
            topLeftColor,
            topCenterColor,
            topRightColor,
            whiteColor
        )
    )


    LoadingOverlay(
        isLoading = isLoading, message = "Loading your coffee shop..."
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = authBackgroundGradient)
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AppLogoSection()
            VerticalSpacer(size = 24.dp)

            TextSection()
            Spacer(modifier = Modifier.height(24.dp))

            EmailTextField()
            VerticalSpacer(size = 8.dp)

            PasswordTextField()
            VerticalSpacer(size = 8.dp)

            RememberAndForgotSection(
                checked = isRememberMeChecked,
                onCheckedChange = { isRememberMeChecked = it },
                onForgotPasswordClick = {})

            VerticalSpacer(size = 24.dp)
            AuthButton(
                text = if (isLoading) "..." else "Login",
                enabled = !isLoading,
                onClick = { viewModel.onContinueClick(onSuccess = onLoginSuccess) },
                containerColor = colorResource(R.color.green),
                contentColor = colorResource(R.color.white)
            )

            VerticalSpacer(size = 24.dp)
            AuthSectionDivider(modifier = Modifier.padding(horizontal = 34.dp))

            VerticalSpacer(size = 24.dp)
            SocialSignInSection(onFacebookClick = {}, onGoogleClick = {})

            TextButton(
                onClick = rememberDebouncedOnClick {
                    onNavigateToRegister()
                }) {
                Text("একাউন্ট নেই? Register")
            }
        }
    }
}


