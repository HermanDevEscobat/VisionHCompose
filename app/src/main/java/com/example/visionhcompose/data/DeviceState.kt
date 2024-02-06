package com.example.visionhcompose.data

data class DeviceState(
    val devices: List<Device> = emptyList(),
    val serialNumber: String = "",
    val username: String = "",
    val password: String = "",
    val model: String = "",
    val typeDevice: String = "",
    val dateAdded: String = "",
    val imageUrl: String = "",
    val isAddingDevice: Boolean = false
) {
}