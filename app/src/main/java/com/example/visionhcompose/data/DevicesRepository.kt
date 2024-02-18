package com.example.visionhcompose.data

import kotlinx.coroutines.flow.Flow

interface DevicesRepository {
    fun getAllDevicesStream(): Flow<List<Device>>
    fun getDeviceStream(id: Int): Flow<Device?>
    suspend fun insertDevice(device: Device)
    suspend fun deleteDevice(device: Device)
    suspend fun updateDevice(device: Device)
}