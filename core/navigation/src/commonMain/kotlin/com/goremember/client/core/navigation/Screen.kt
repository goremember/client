package com.goremember.client.core.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {

    @Serializable
    data object SplashScreen : Screen()

    @Serializable
    data object AuthTypeScreen : Screen()
}