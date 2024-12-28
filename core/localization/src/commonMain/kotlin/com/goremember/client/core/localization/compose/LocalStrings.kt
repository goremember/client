package com.goremember.client.core.localization.compose

import androidx.compose.runtime.staticCompositionLocalOf
import com.goremember.client.core.localization.strings.Strings
import com.goremember.client.core.localization.strings.UkrainianStrings

val LocalStrings = staticCompositionLocalOf<Strings> { UkrainianStrings }