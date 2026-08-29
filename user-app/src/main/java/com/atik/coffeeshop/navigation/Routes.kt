package com.atik.coffeeshop.navigation

const val ROOT_GRAPH_ROUTE = "root_graph"
const val AUTH_GRAPH_ROUTE = "auth_graph"
const val HOME_GRAPH_ROUTE = "home_graph"

sealed class Routes(val route: String) {

    // --- Pre-auth flow ---
    data object Onboarding : Routes(route = "onboarding_screen")

    // --- Home graph ---
    data object Explore : Routes(route = "explore_screen")
    data object Cart : Routes(route = "cart_screen")
    data object Favorite : Routes(route = "favorite_screen")
    data object Profile : Routes(route = "profile_screen")
    data object Details : Routes(route = "details_screen")

    // ---- Auth graph ----
    data object Login : Routes(route = "login_screen")
    data object Register : Routes(route = "signup_screen")
}