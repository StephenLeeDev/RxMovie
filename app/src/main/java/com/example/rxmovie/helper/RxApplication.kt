package com.example.rxmovie.helper

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class RxApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}