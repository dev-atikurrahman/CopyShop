package com.atik.coffeeshop.ui.components

import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.atik.coffeeshop.ui.R

@Composable
fun AuthSectionDivider(
    modifier: Modifier = Modifier,
    color: Color = colorResource(R.color.gray),
    thickness: Dp = 1.dp
) {
    HorizontalDivider(
        color = color,
        thickness = thickness,
        modifier = modifier
    )
}