package com.timmitof.photoroulette

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PhotoRouletteApp: Application() {
    companion object {
        lateinit var instance: PhotoRouletteApp
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}