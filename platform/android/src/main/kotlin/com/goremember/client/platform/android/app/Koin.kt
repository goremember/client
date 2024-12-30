package com.goremember.client.platform.android.app

import com.goremember.client.feature.splash.dependencies.splashModule
import org.koin.core.context.startKoin

fun startKoin() {
    startKoin {
        modules(splashModule)
    }
}