package com.example.visionhcompose.api_dahua

import com.example.visionhcompose.data.Device
import retrofit2.http.POST

interface DahuaApiService {
    @POST("/api/addDevice")
    suspend fun addDevice(device: Device): Boolean
}