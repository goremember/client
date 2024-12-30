package com.goremember.client.core.styles.colors.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.goremember.client.core.styles.colors.config.shapes
import com.goremember.client.core.styles.colors.config.typography
import com.goremember.client.core.styles.colors.material.DarkColors
import com.goremember.client.core.styles.colors.material.LightColors

/**
 * A composable function to apply the application's theme based on the current theme mode.
 *
 * @param useDarkTheme A Boolean flag to determine whether the dark theme should be used.
 * Defaults to the system theme ([isSystemInDarkTheme]).
 * @param content The composable content that will be styled with the selected theme.
 */
@Composable
fun GorememberTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (useDarkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colorScheme,
        shapes = shapes,
        typography = typography,
        content = content
    )
}
