package com.example.visionhcompose.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "device")
data class Device(
    val name: String,
    val serialNumber: String = "",
    val username: String = "",
    val password: String = "",
    val model: String = "",
    val typeDevice: String = "",
    val dateAdded: String = "",
    val imageUrl: String = "",
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)