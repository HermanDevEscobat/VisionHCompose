package com.example.visionhcompose.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Device::class], version = 1)
abstract class DeviceDatabase : RoomDatabase() {
    abstract fun deviceDao(): DeviceDao
}