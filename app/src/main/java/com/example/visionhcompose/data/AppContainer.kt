package com.example.visionhcompose.data

import android.content.Context

interface AppContainer {
    val devicesRepository: DevicesRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val devicesRepository: DevicesRepository by lazy {
        OfflineDevicesRepository(DevicesDatabase.getDatabase(context).deviceDao())
    }
}