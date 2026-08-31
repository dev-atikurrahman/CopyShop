package com.atik.coffeeshop.features.auth.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.rounded.AlternateEmail
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.atik.coffeeshop.R
import com.atik.coffeeshop.core.HorizontalSpacer
import com.atik.coffeeshop.core.VerticalSpacer
import com.atik.coffeeshop.ui.components.AuthButton
import com.atik.coffeeshop.ui.components.AuthField
import com.atik.coffeeshop.ui.components.AuthHeadingText
import com.atik.coffeeshop.ui.components.AuthSectionDivider
import com.atik.coffeeshop.ui.components.AuthText
import com.atik.coffeeshop.ui.components.ButtonText
import com.atik.coffeeshop.ui.components.EndIconMode
import com.atik.coffeeshop.ui.components.RememberCheckbox
import com.atik.coffeeshop.ui.components.SocialIconButton


@Composable
fun AppLogoSection() {
    val shape = RoundedCornerShape(24.dp)
    Box(
        modifier = Modifier
            .clip(shape)
            .background(colorResource(R.color.white)),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier.size(90.dp)
        )
    }
}

@Composable
fun TextSection() {
    AuthHeadingText(
        text = "Welcome Back",
    )
    Spacer(modifier = Modifier.height(8.dp))

    AuthText(
        text = stringResource(R.string.sign_in_to),
    )
}

val UserIcon = Icons.Rounded.AlternateEmail
val EmailIcon = Icons.Outlined.Email
val PasswordIcon = Icons.Outlined.Lock

@Composable
fun NameTextField() {
    var name by remember { mutableStateOf("") }
    AuthField(
        value = name,
        onValueChange = { name = it },
        label = stringResource(R.string.email_hint),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        )
    )
}

@Composable
fun EmailTextField() {
    var email by remember { mutableStateOf("") }

    AuthField(
        value = email,
        onValueChange = { email = it },
        label = stringResource(R.string.email_hint),
        leadingIcon = EmailIcon,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        ),
        endIconMode = EndIconMode.CLEAR_TEXT
    )
}

@Composable
fun PasswordTextField() {
    var password by remember { mutableStateOf("") }
    AuthField(
        value = password,
        onValueChange = { password = it },
        label = stringResource(R.string.password_hint),
        leadingIcon = PasswordIcon,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Done
        ),
        endIconMode = EndIconMode.PASSWORD_TOGGLE

    )
}

@Composable
fun RememberAndForgotSection(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onForgotPasswordClick: () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RememberCheckbox(
            checked = true,
            onCheckedChange = { },
            label = stringResource(R.string.remember_me)
        )

        ButtonText(
            text = stringResource(R.string.forgot_password),
            color = colorResource(R.color.black),
            maxLines = 1
        )

    }
}

@Composable
fun InputLoginSection(
) {
    Column(
        modifier = Modifier.wrapContentHeight()
    ) {
        EmailTextField()
        VerticalSpacer(size = 8.dp)
        PasswordTextField()
    }

}

@Composable
fun SocialSignInSection(
    onFacebookClick: () -> Unit,
    onGoogleClick: () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        SocialIconButton(
            iconResId = R.drawable.google,
            contentDescriptor = "Sign in with Facebook",
            onClick = {}
        )

        HorizontalSpacer(size = 24.dp)
        SocialIconButton(
            iconResId = R.drawable.facebook,
            contentDescriptor = "Sign in with Facebook",
            onClick = {}
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewScreenComponentsLogin() {

    val whiteColor = colorResource(R.color.white)
    val gradient1 = colorResource(R.color.gradient1)
    val gradient2 = colorResource(R.color.gradient2)

    val authBackgroundGradient = Brush.verticalGradient(
        colors = listOf(
            gradient1,
            gradient2,
            whiteColor,
            gradient2
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = authBackgroundGradient)
            .padding(18.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppLogoSection()
        Spacer(modifier = Modifier.height(24.dp))

        TextSection()
        Spacer(modifier = Modifier.height(24.dp))

        InputLoginSection()

        VerticalSpacer(size = 24.dp)
        AuthSectionDivider(modifier = Modifier.padding(horizontal = 34.dp))

        VerticalSpacer(size = 24.dp)
        SocialSignInSection(onFacebookClick = {}, onGoogleClick = {})
    }
}