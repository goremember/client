package com.goremember.client.platform.android.app

import android.app.Application

class GorememberApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin()
    }
}