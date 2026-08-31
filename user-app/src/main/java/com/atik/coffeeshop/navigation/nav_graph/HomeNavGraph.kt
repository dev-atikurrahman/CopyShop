package com.atik.coffeeshop.navigation.nav_graph

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.atik.coffeeshop.core.defaultEnterTransition
import com.atik.coffeeshop.core.defaultExitTransition
import com.atik.coffeeshop.features.details.presentation.DetailsScreen
import com.atik.coffeeshop.features.home.cart.presentation.CartScreen
import com.atik.coffeeshop.features.home.explore.presentation.ExploreScreen
import com.atik.coffeeshop.features.home.explore.presentation.SharedViewModel
import com.atik.coffeeshop.features.home.favorite.presentation.FavoriteScreen
import com.atik.coffeeshop.features.home.profile.presentation.ProfileScreen
import com.atik.coffeeshop.navigation.HOME_GRAPH_ROUTE
import com.atik.coffeeshop.navigation.Routes

@OptIn(ExperimentalSharedTransitionApi::class)
fun NavGraphBuilder.homeNavGraph(
    navController: NavController,
    sharedViewModel: SharedViewModel,
    sharedTransitionScope: SharedTransitionScope
) {
    navigation(startDestination = Routes.Explore.route, route = HOME_GRAPH_ROUTE) {
        composable(
            route = Routes.Explore.route,
            enterTransition = { fadeIn(animationSpec = tween(250)) }
        ) {
            with(sharedTransitionScope) {
                ExploreScreen(
                    navController = navController,
                    onItemClick = { item ->
                        sharedViewModel.selectItem(item)
                        navController.navigate(Routes.Details.route)
                    }, animatedVisibilityScope = this@composable
                )
            }
        }

        composable(Routes.Cart.route) { CartScreen() }
        composable(Routes.Favorite.route) { FavoriteScreen() }
        composable(Routes.Profile.route) { ProfileScreen() }

        composable(
            route = Routes.Details.route,
            enterTransition = defaultEnterTransition,
            exitTransition = defaultExitTransition,
            popEnterTransition = defaultEnterTransition,
            popExitTransition = defaultExitTransition
        ) {
            val item = sharedViewModel.selectedItem

            if (item != null) {
                with(sharedTransitionScope) {
                    DetailsScreen(
                        item = item,
                        onBackClick = { navController.popBackStack() },
                        animatedVisibilityScope = this@composable
                    )
                }
            } else {
                LaunchedEffect(Unit) { navController.popBackStack() }
            }
        }
    }
}