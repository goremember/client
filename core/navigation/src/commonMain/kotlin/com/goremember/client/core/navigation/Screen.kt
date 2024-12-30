package com.goremember.client.core.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {

    @Serializable
    data object Startup : Screen()

    @Serializable
    data object AuthTypeScreen : Screen()
}