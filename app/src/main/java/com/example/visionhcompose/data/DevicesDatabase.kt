package com.example.visionhcompose.data

import androidx.room.Database
import androidx.room.RoomDatabase
import android.content.Context
import androidx.room.Room

@Database(entities = [Device::class], version = 1, exportSchema = false)
abstract class DevicesDatabase : RoomDatabase() {

    abstract fun deviceDao(): DevicesDao

    companion object {
        @Volatile
        private var Instance: DevicesDatabase? = null

        fun getDatabase(context: Context): DevicesDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, DevicesDatabase::class.java, "device_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}