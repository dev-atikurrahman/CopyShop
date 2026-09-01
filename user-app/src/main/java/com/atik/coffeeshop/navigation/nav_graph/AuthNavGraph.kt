package com.atik.coffeeshop.navigation.nav_graph

import android.util.Log
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.atik.coffeeshop.core.defaultEnterTransition
import com.atik.coffeeshop.core.defaultExitTransition
import com.atik.coffeeshop.features.auth.presentation.login.LoginScreen
import com.atik.coffeeshop.features.auth.presentation.login.LoginViewModel.Companion.AUTH_TAG
import com.atik.coffeeshop.features.auth.presentation.register.RegisterScreen
import com.atik.coffeeshop.navigation.AUTH_GRAPH_ROUTE
import com.atik.coffeeshop.navigation.HOME_GRAPH_ROUTE
import com.atik.coffeeshop.navigation.Routes



fun NavGraphBuilder.authNavGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = Routes.Login.route,
        route = AUTH_GRAPH_ROUTE
    ) {
        composable(
            Routes.Login.route,
            enterTransition = defaultEnterTransition,
            exitTransition = defaultExitTransition,
            popEnterTransition = defaultEnterTransition,
            popExitTransition = defaultExitTransition
        ) {
            LoginScreen(
                onLoginSuccess = {
                    Log.d(AUTH_TAG, "onLoginSuccess: navigating to HOME_GRAPH_ROUTE, current backstack=${navController.currentBackStackEntry?.destination?.route}")
                    navController.navigate(HOME_GRAPH_ROUTE) {
                        popUpTo(AUTH_GRAPH_ROUTE) { inclusive = true }
                        launchSingleTop = true
                    }
                    Log.d(AUTH_TAG, "onLoginSuccess: navigate() call returned, new current=${navController.currentDestination?.route}")
                },
                onNavigateToRegister = {
                    navController.navigate(Routes.Register.route) {
                        launchSingleTop = true
                    }
                }
            )
        }

        composable(
            Routes.Register.route,
            enterTransition = defaultEnterTransition,
            exitTransition = defaultExitTransition,
            popEnterTransition = defaultEnterTransition,
            popExitTransition = defaultExitTransition
        ) {
            RegisterScreen(
                onRegisterSuccess = {
                    navController.navigate(HOME_GRAPH_ROUTE) {
                        popUpTo(AUTH_GRAPH_ROUTE) { inclusive = true }
                        launchSingleTop = true
                    }
                },
                onNavigateToLogin = {
                    navController.navigate(Routes.Login.route) {
                        launchSingleTop = true
                        popUpTo(Routes.Login.route) { inclusive = true }
                    }
                }
            )
        }

    }
}
