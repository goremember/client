package com.goremember.client.platform.android.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.defaultComponentContext
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.router.stack.StackNavigation
import com.goremember.client.core.navigation.ChildStack
import com.goremember.client.core.navigation.Screen
import com.goremember.client.core.styles.colors.theme.GorememberTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GorememberTheme {
                val navigation: StackNavigation<Screen> = remember { StackNavigation() }

                ChildStack(
                    modifier = Modifier.fillMaxSize(),
                    source = navigation,
                    initialStack = { listOf(Screen.Startup) },
                    animation = stackAnimation(fade() + scale()),
                ) { screen ->
                    when(screen) {
                        is Screen.Startup -> TODO()
                        is Screen.AuthTypeScreen -> TODO()
                    }
                }
            }
        }
    }
}