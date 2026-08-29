package com.atik.coffeeshop.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PreviewHelper(
    modifier: Modifier = Modifier,
    paddingEnabled: Boolean = true,
    content: @Composable ColumnScope.() -> Unit
) {

    Column(
        modifier = modifier
            .background(Color.White)
            .padding(
                if (paddingEnabled) 0.dp else 0.dp
            ),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        content()
    }

}