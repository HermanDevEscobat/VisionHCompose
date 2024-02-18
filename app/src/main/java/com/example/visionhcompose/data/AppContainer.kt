package com.example.visionhcompose.data

import android.content.Context

interface AppContainer {
    val deviceRepository: DevicesRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val deviceRepository: DevicesRepository by lazy {
        DevicesRepositoryImpl(DevicesDatabase.getDatabase(context).deviceDao())
    }
}