package com.example.visionhcompose.api_dahua

import com.example.visionhcompose.data.Device
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

suspend fun checkDeviceAddition(device: Device): Boolean {
    // Создание экземпляра Retrofit
    val retrofit = Retrofit.Builder()
        .baseUrl("https://your-dahua-api-url.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // Создание экземпляра сервиса
    val service = retrofit.create(DahuaApiService::class.java)

    // Вызов метода добавления устройства
    return try {
        service.addDevice(device)
    } catch (e: Exception) {
        // Обработка ошибки, если добавление устройства не удалось
        e.printStackTrace()
        false
    }
}