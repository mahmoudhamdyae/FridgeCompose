package com.mahmoudhamdyae.fridgecompose.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.googlefonts.Font
import com.mahmoudhamdyae.fridgecompose.R

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)
val fontName = GoogleFont("Tajawal")

val Typography = Typography(
    labelLarge = TextStyle(
        fontFamily = FontFamily(Font(googleFont = fontName, fontProvider = provider)),
        fontWeight = FontWeight.SemiBold,
        fontSize = 32.sp,
    ),
    labelMedium = TextStyle(
        fontFamily = FontFamily(Font(googleFont = fontName, fontProvider = provider)),
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily(Font(googleFont = fontName, fontProvider = provider)),
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    )
)