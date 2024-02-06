package com.example.visionhcompose.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface DeviceDao {
    @Query("SELECT * FROM device")
    suspend fun getAll(): List<Device>

    @Upsert
    suspend fun insertAll(vararg device: Device)

    @Delete
    suspend fun delete(device: Device)

    @Query("SELECT * FROM device ORDER BY name ASC")
    fun getDeviceByName(): Flow<List<Device>>
}