package com.goremember.client.platform.android.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.defaultComponentContext
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.replaceCurrent
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.arkivanov.essenty.statekeeper.StateKeeperDispatcher
import com.goremember.client.core.navigation.ChildStack
import com.goremember.client.core.navigation.LocalComponentContext
import com.goremember.client.core.navigation.Screen
import com.goremember.client.core.styles.colors.theme.GorememberTheme
import com.goremember.client.feature.splash.presentation.SplashScreen
import com.goremember.client.feature.splash.presentation.mvi.SplashComponent
import org.koin.compose.LocalKoinScope
import org.koin.core.parameter.ParametersDefinition

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val lifecycle = LifecycleRegistry()
            val stateKeeper = StateKeeperDispatcher()
            val rootComponentContext = DefaultComponentContext(
                lifecycle = lifecycle,
                stateKeeper = stateKeeper,
            )

            CompositionLocalProvider(LocalComponentContext provides rootComponentContext) {
                GorememberTheme {
                    val navigation: StackNavigation<Screen> = remember { StackNavigation() }
                    val componentContext = LocalComponentContext.current

                    ChildStack(
                        modifier = Modifier.fillMaxSize(),
                        source = navigation,
                        initialStack = { listOf(Screen.SplashScreen) },
                        animation = stackAnimation(fade() + scale()),
                    ) { screen ->
                        when(screen) {
                            is Screen.SplashScreen -> SplashScreen(
                                mvi = SplashComponent(componentContext),
                                navigateToAuth = { navigation.replaceCurrent(Screen.SplashScreen) },
                                navigateToHome = { error("Not implemented") },
                            )
                            is Screen.AuthTypeScreen -> TODO()
                        }
                    }
                }
            }
        }
    }
}