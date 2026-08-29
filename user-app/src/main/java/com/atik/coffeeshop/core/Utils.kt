package com.atik.coffeeshop.core

import androidx.compose.animation.BoundsTransform
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween

val sharedBoundsTransform = BoundsTransform { _, _ ->
    tween(
        durationMillis = 600,
        easing = FastOutSlowInEasing
    )
}