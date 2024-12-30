package com.goremember.client.feature.splash.dependencies

import com.goremember.client.feature.splash.presentation.mvi.SplashComponent
import org.koin.dsl.module

val splashModule = module {
    factory { SplashComponent(get()) }
}