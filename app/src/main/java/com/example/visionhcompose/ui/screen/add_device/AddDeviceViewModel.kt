package com.example.visionhcompose.ui.screen.add_device

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.visionhcompose.data.Device
import com.example.visionhcompose.data.DevicesRepository
import java.text.NumberFormat

class AddDeviceViewModel(private val devicesRepository: DevicesRepository) : ViewModel() {
    var deviceUiState by mutableStateOf(DeviceUiState())
        private set

    fun updateUiState(deviceDetails: DeviceDetails) {
        deviceUiState =
            DeviceUiState(
                deviceDetails = deviceDetails,
                isEntryValid = validateInput(deviceDetails)
            )
    }

    suspend fun saveDevice() {
        if (validateInput()) {
            devicesRepository.insertDevice(deviceUiState.deviceDetails.toDevice())
        }
    }

    private fun validateInput(uiState: DeviceDetails = deviceUiState.deviceDetails): Boolean {
        return with(uiState) {
            name.isNotBlank() && serialNumber.isNotBlank() && userName.isNotBlank() && password.isNotBlank()
        }
    }
}

data class DeviceUiState(
    val deviceDetails: DeviceDetails = DeviceDetails(),
    val isEntryValid: Boolean = false
)

data class DeviceDetails(
    val id: Int = 0,
    val name: String = "",
    val serialNumber: String = "",
    val userName: String = "",
    val password: String = ""
)

fun DeviceDetails.toDevice(): Device = Device(
    id = id,
    name = name,
    serialNumber = serialNumber,
    userName = userName,
    password = password
)

fun Device.toDeviceUiState(isEntryValid: Boolean = false): DeviceUiState = DeviceUiState(
    deviceDetails = this.toDeviceDetails(),
    isEntryValid = isEntryValid
)

fun Device.toDeviceDetails(): DeviceDetails = DeviceDetails(
    id = id,
    name = name,
    serialNumber = serialNumber,
    userName = userName,
    password = password
)