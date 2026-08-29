package com.atik.coffeeshop.ui.theme

import androidx.compose.ui.graphics.Color
import com.atik.coffeeshop.ui.theme.Brand.lightCream
import com.atik.coffeeshop.ui.theme.UI.black100
import com.atik.coffeeshop.ui.theme.UI.white100


data class Colors(
    val isDark: Boolean,

    val mainBackground: Color,
    val mainBackgroundInverted: Color,
    val primaryBackground: Color


    )

val CoffeeShopLightColors = Colors(
    isDark = false,

    mainBackground = white100,
    mainBackgroundInverted = black100,
    primaryBackground = lightCream

)

val CoffeeShopDarkColors = Colors(
    isDark = true,

    mainBackground = black100,
    mainBackgroundInverted = white100,
    primaryBackground = lightCream

)
