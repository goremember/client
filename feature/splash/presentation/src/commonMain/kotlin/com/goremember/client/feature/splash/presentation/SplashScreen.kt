package com.goremember.client.feature.splash.presentation

import androidx.compose.runtime.Composable
import com.goremember.client.feature.splash.presentation.mvi.SplashComponent
import com.goremember.client.feature.splash.presentation.mvi.SplashComponent.Action
import pro.respawn.flowmvi.essenty.compose.subscribe

@Composable
fun SplashScreen(
    mvi: SplashComponent,
    navigateToAuth: () -> Unit,
    navigateToHome: () -> Unit
) {
    mvi.subscribe { action ->
        when (action) {
            Action.NavigateToAuth -> navigateToAuth()
            Action.NavigateToHome -> navigateToHome()
        }
    }

}