package com.atik.coffeeshop.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

fun Modifier.authGradientBackground(): Modifier {
    val topLeft = Color(0xFF8B00FF)
    val topLeft2 = Color(0xFFB000FF).copy(alpha = 0.75f)
    val topCenter = Color(0xFFFF007A)
    val topCenter2 = Color(0xFFFF3D9A).copy(alpha = 0.65f)
    val topRight = Color(0xFFFF5A00)
    val topRight2 = Color(0xFFFFB300).copy(alpha = 0.7f)

    val baseFade = Brush.verticalGradient(
        colors = listOf(
            Color.Transparent,
            Color.White
        )
    )

    val topLeftGradient = Brush.radialGradient(
        colors = listOf(topLeft, topLeft2, Color.Transparent),
        center = Offset(x = 0f, y = 0f),
        radius = 900f
    )

    val topCenterGradient = Brush.radialGradient(
        colors = listOf(topCenter, topCenter2, Color.Transparent),
        center = Offset(x = 500f, y = 0f),
        radius = 850f
    )

    val topRightGradient = Brush.radialGradient(
        colors = listOf(topRight, topRight2, Color.Transparent),
        center = Offset(x = 1000f, y = 50f),
        radius = 800f
    )

    return this
        .background(color = Color.White)
        .background(brush = topLeftGradient)
        .background(brush = topCenterGradient)
        .background(brush = topRightGradient)
        .background(brush = baseFade)
}

@Composable
fun AuthGradientBox(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    androidx.compose.foundation.layout.Box(
        modifier = modifier
            .fillMaxSize()
            .authGradientBackground()
    ) {
        content()
    }
}