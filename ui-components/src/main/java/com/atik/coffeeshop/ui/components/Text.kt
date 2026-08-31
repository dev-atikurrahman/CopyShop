package com.atik.coffeeshop.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.atik.coffeeshop.ui.R

val Poppins = FontFamily(
    Font(
        resId = R.font.poppins_regular,
        weight = FontWeight.Normal
    ),
    Font(
        resId = R.font.poppins_medium,
        weight = FontWeight.Medium
    ),
    Font(
        resId = R.font.poppins_semibold,
        weight = FontWeight.SemiBold
    ),
    Font(
        resId = R.font.poppins_bold,
        weight = FontWeight.Bold
    ),
)

/* Auth text style */
private val AuthHeadingTextStyle = TextStyle(
    fontSize = 28.sp,
    fontWeight = FontWeight.Medium,
    fontFamily = Poppins
)

private val AuthTextStyle = TextStyle(
    fontSize = 16.sp,
    fontWeight = FontWeight.Normal,
    fontFamily = Poppins
)

private val AuthTextStyle2 = TextStyle(
    fontSize = 16.sp,
    fontWeight = FontWeight.Medium,
    fontFamily = Poppins
)

// Heading style
private val HeadingTextStyle = TextStyle(
    fontSize = 22.sp,
    fontWeight = FontWeight.SemiBold
)
private val OnboardingTextStyle = TextStyle(
    fontSize = 36.sp,
    fontWeight = FontWeight.SemiBold,
    fontFamily = Poppins
)

// Title style
private val SubtitleTextStyle = TextStyle(
    fontSize = 16.sp,
    fontWeight = FontWeight.SemiBold
)

// Normal style
private val BodyTextStyle = TextStyle(
    fontSize = 16.sp,
    fontWeight = FontWeight.SemiBold,
    fontFamily = Poppins
)

// Button text style
private val ButtonTextStyle = TextStyle(
    fontSize = 16.sp,
    fontWeight = FontWeight.Normal
)

// Items Text style
private val TitleTextStyle = TextStyle(
    fontSize = 18.sp,
    fontWeight = FontWeight.Medium,
    fontFamily = Poppins
)
private val CaptionTextStyle = TextStyle(
    fontSize = 14.sp,
    fontWeight = FontWeight.Normal,
    fontFamily = Poppins
)

/*Auth Text */
@Composable
fun AuthHeadingText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = colorResource(R.color.black),
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text = text,
        modifier = modifier,
        style = AuthHeadingTextStyle,
        color = color,
        maxLines = maxLines,
        overflow = overflow,
    )
}

@Composable
fun AuthText(
    text: String,
    textAlign: TextAlign = TextAlign.Center,
    modifier: Modifier = Modifier,
    color: Color = colorResource(R.color.lightGray),
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text = text,
        textAlign = textAlign,
        modifier = modifier,
        style = AuthTextStyle,
        color = color,
        maxLines = maxLines,
        overflow = overflow,
    )
}

@Composable
fun AuthSectionTitleText(
    text: String,
    textAlign: TextAlign = TextAlign.Center,
    modifier: Modifier = Modifier,
    color: Color = colorResource(R.color.black),
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text = text,
        textAlign = textAlign,
        modifier = modifier,
        style = AuthTextStyle2,
        color = color,
        maxLines = maxLines,
        overflow = overflow,
    )
}


// Reusable Text
@Composable
fun HeadingText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text = text,
        modifier = modifier,
        style = HeadingTextStyle,
        color = color,
        maxLines = maxLines,
        overflow = overflow,
    )
}

@Composable
fun OnboardingHeading(
    text: String,
    modifier: Modifier = Modifier,
    color: Color,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text = text,
        modifier = modifier,
        style = OnboardingTextStyle,
        color = color,
        maxLines = maxLines,
        overflow = overflow
    )
}

@Composable
fun TitleText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text = text,
        modifier = modifier,
        style = TitleTextStyle,
        color = color,
        maxLines = maxLines,
        overflow = overflow
    )
}


// Button text
@Composable
fun ButtonText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text = text,
        modifier = modifier,
        style = ButtonTextStyle,
        color = color,
        maxLines = maxLines,
        overflow = overflow
    )
}


// Item title and description text
@Composable
fun BodyText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text = text,
        modifier = modifier,
        style = BodyTextStyle,
        color = color,
        maxLines = maxLines,
        overflow = overflow
    )
}
@Composable
fun PriceText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text = text,
        modifier = modifier,
        style = TitleTextStyle,
        color = color,
        maxLines = maxLines,
        overflow = overflow
    )
}

@Composable
fun CaptionText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color,
    maxLines: Int,
    overflow: TextOverflow = TextOverflow.Ellipsis
) {
    Text(
        text = text,
        modifier = modifier,
        style = CaptionTextStyle,
        color = color,
        maxLines = maxLines,
        overflow = overflow
    )
}


// hints text
@Composable
fun HintText(
    text: String,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text = text,
        modifier = modifier,
        style = CaptionTextStyle,
        maxLines = maxLines,
        overflow = overflow
    )
}