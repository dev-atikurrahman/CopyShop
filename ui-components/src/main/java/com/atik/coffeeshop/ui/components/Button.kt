package com.atik.coffeeshop.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.atik.coffeeshop.ui.R


private val ButtonShape = RoundedCornerShape(percent = 100)
private val AuthBtnShape = RoundedCornerShape(percent = 25)

@Composable
fun OnboardingButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    containerColor: Color,
    contentColor: Color = Color.White,
    shape: Shape = ButtonShape,
    contentPadding: PaddingValues = PaddingValues(horizontal = 28.dp, vertical = 12.dp)
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = containerColor.copy(alpha = 0.5f),
            disabledContentColor = contentColor.copy(alpha = 0.7f),
        ),
        contentPadding = contentPadding,
        modifier = modifier,
    ) {
        BodyText(text = text)
    }
}


@Composable
fun AuthButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    containerColor: Color,
    contentColor: Color = Color.White,
    shape: Shape = AuthBtnShape,
    contentPadding: PaddingValues = PaddingValues(horizontal = 28.dp, vertical = 12.dp)
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = containerColor.copy(alpha = 0.5f),
            disabledContentColor = contentColor.copy(alpha = 0.7f),
        ),
        contentPadding = contentPadding,
        modifier = modifier
    ) {
        ButtonText(text = text)
    }
}

