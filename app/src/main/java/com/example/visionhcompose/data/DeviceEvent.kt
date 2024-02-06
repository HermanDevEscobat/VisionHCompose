package com.example.visionhcompose.data

sealed interface DeviceEvent {
    data object SaveDevice : DeviceEvent
    data class SetName(val name: String) : DeviceEvent
    data class SetSerialNumber(val serialNumber: String) : DeviceEvent
    data class SetUsername(val username: String) : DeviceEvent
    data class SetPassword(val password: String) : DeviceEvent
    data class DeleteDevice(val device: Device) : DeviceEvent
}