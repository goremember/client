package com.goremember.client.core.styles.colors

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

/**
 * A data class to define the color palette used throughout the application.
 *
 * This class centralizes the theme colors for consistent usage in the app's UI,
 * ensuring adherence to the design system and improving maintainability.
 *
 * @property primary The primary color used for key UI elements.
 * @property onPrimary The color used for text or icons displayed on top of the primary color.
 * @property secondary The secondary color, typically used for less prominent components.
 * @property onSecondary The color used for text or icons displayed on top of the secondary color.
 * @property secondaryVariant A variant of the secondary color, useful for subtle UI variations.
 * @property background The background color for the app's screens or containers.
 * @property onBackground The color used for text or icons displayed on top of the background color.
 * @property surface The color for surfaces like cards, modals, or dialogs.
 * @property surfaceVariant A variant of the surface color for visual differentiation.
 * @property positive A color used to indicate positive actions or states.
 * @property negative A color used to indicate negative actions or states).
 */
data class AppColors(
    val primary: Color,
    val onPrimary: Color,
    val secondary: Color,
    val onSecondary: Color,
    val secondaryVariant: Color,
    val background: Color,
    val onBackground: Color,
    val surface: Color,
    val surfaceVariant: Color,
    val positive: Color,
    val negative: Color,
)

fun lightAppColors(): AppColors {
    return AppColors(
        primary = Color(0xFFBFC8CA),
        onPrimary = Color(0xFFBFC8CA),
        secondary = Color(0xFFBFC8CA),
        onSecondary = Color(0xFFBFC8CA),
        secondaryVariant = Color(0xFFBFC8CA),
        background = Color(0xFFBFC8CA),
        onBackground = Color(0xFFBFC8CA),
        surface = Color(0xFFBFC8CA),
        surfaceVariant = Color(0xFFBFC8CA),
        positive = Color(0xFFBFC8CA),
        negative = Color(0xFFBFC8CA),
    )
}

val LocalAppColors: ProvidableCompositionLocal<AppColors> =
    staticCompositionLocalOf { lightAppColors() }