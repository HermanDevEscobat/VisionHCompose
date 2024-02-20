package com.example.visionhcompose

import android.app.Application
import com.example.visionhcompose.data.AppContainer
import com.example.visionhcompose.data.AppDataContainer

class VisionHApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}