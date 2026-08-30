package com.atik.coffeeshop.navigation.nav_graph

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.atik.coffeeshop.features.auth.presentation.LoginViewModel.Companion.AUTH_TAG
import com.atik.coffeeshop.features.onboarding.presentation.OnboardingScreen
import com.atik.coffeeshop.navigation.AUTH_GRAPH_ROUTE
import com.atik.coffeeshop.navigation.CoffeeShopAppNavigation
import com.atik.coffeeshop.navigation.HOME_GRAPH_ROUTE
import com.atik.coffeeshop.navigation.Routes
import com.atik.coffeeshop.navigation.SplashViewModel
import com.atik.coffeeshop.navigation.StartDestination
import com.atik.coffeeshop.ui.components.AppLoadingIndicator
import org.koin.androidx.compose.koinViewModel

private const val SPLASH_ROOT_ROUTE = "splash_root"
@Composable
fun SplashNavHost(
    splashViewModel: SplashViewModel = koinViewModel()
) {
    val startDestination by splashViewModel.startDestination.collectAsStateWithLifecycle()
    var resolvedStart by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(startDestination) {
        if (resolvedStart == null && startDestination != StartDestination.Loading) {
            resolvedStart = when (startDestination) {
                StartDestination.Onboarding -> Routes.Onboarding.route
                StartDestination.Login -> AUTH_GRAPH_ROUTE
                StartDestination.Home -> HOME_GRAPH_ROUTE
                StartDestination.Loading -> Routes.Onboarding.route //
            }
            Log.d(
                AUTH_TAG,
                "SplashNavHost: recomposed with destination=$startDestination, actualStart=$resolvedStart"
            )
        }
    }
    val currentResolveStart = resolvedStart

    if (currentResolveStart == null) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            AppLoadingIndicator()
        }
    } else {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = currentResolveStart,
            route = SPLASH_ROOT_ROUTE
        ) {
            composable(Routes.Onboarding.route) {
                OnboardingScreen(
                    onGetStarted = {
                        navController.navigate(Routes.Login.route) {
                            popUpTo(Routes.Onboarding.route) { inclusive = true }
                        }
                    }
                )
            }

            authNavGraph(navController = navController)

            composable(HOME_GRAPH_ROUTE) {
                CoffeeShopAppNavigation()
            }


        }
    }

}