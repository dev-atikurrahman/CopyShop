package com.atik.coffeeshop.navigation.bottom_bar

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination

fun NavController.navigateToBottomBar(
    route: String
) {
    navigate(route) {

        popUpTo(
            graph.findStartDestination().id
        ) {
            saveState = true
        }

        launchSingleTop = true
        restoreState = true
    }
}