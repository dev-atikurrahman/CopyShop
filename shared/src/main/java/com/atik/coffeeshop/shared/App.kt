package com.atik.coffeeshop.shared

import androidx.compose.runtime.Composable
import com.atik.coffeeshop.shared.di.AppGraph

@Composable
fun App(
    appGraph: AppGraph,
    onThemeChane: ((isDarkTheme: Boolean) -> Unit)? = null
) {
}