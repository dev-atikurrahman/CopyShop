package com.atik.coffeeshop.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

internal object Brand{
    val cream = Color(0xFFEADDCB)
    val lightCream = Color(0xFFFDF6EB)
    val green = Color(0xFF064C3E)
    val lightBrown = Color(0xFFE1C9A2)
    val indicator = Color(0x26E1C9A2)
    val darkBrown = Color(0xFF7E4616)

    val colorGradient = Brush.horizontalGradient(
        0f to Color(0xFF8F00E7),
        0.5f to Color(0xFFE00189),
        1f to Color(0xFFFF9100),
    )

    val greenTextDark = Color(0xFF064C3E)


}

internal object UI {
    val black100 = Color(0xFF19191C)
    val black90 = Color(0xE519191C)
    val black80 = Color(0xCC19191C)
    val black70 = Color(0xB219191C)
    val black60 = Color(0x9919191C)
    val black50 = Color(0x8019191C)
    val black40 = Color(0x6619191C)
    val black30 = Color(0x4D19191C)
    val black20 = Color(0x3319191C)
    val black15 = Color(0x2619191C)
    val black10 = Color(0x1A19191C)
    val black05 = Color(0x0D19191C)

    val white100 = Color(0xFFFFFFFF)
    val white90 = Color(0xE5FFFFFF)
    val white80 = Color(0xCCFFFFFF)
    val white70 = Color(0xB2FFFFFF)
    val white60 = Color(0x99FFFFFF)
    val white50 = Color(0x80FFFFFF)
    val white40 = Color(0x66FFFFFF)
    val white30 = Color(0x4DFFFFFF)
    val white20 = Color(0x33FFFFFF)
    val white15 = Color(0x26FFFFFF)
    val white10 = Color(0x1AFFFFFF)
    val white05 = Color(0x0DFFFFFF)

    val grey100 = Color(0xFFE8E8E8)
    val grey400 = Color(0xFFA3A3A4)
    val grey500 = Color(0xFF757577)
    val grey900 = Color(0xFF303033)
}
