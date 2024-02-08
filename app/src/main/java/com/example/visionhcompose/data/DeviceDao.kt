package com.example.visionhcompose.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface DeviceDao {
    @Query("SELECT * from device_table ORDER BY name ASC")
    fun getAllDevices(): Flow<List<Device>>

    @Query("SELECT * from device_table WHERE id = :id")
    fun getDevice(id: Int): Flow<Device>

    @Update
    suspend fun update(device: Device)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(device: Device)

    @Delete
    suspend fun delete(device: Device)

}