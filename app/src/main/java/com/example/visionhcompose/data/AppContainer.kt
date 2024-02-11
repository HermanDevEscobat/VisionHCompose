package com.example.visionhcompose.data

import android.content.Context

interface AppContainer {
    val deviceRepository: DeviceRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val deviceRepository: DeviceRepository by lazy {
        DeviceRepositoryImpl(DeviceDatabase.getDatabase(context).deviceDao())
    }
}