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

    suspend fun saveItem() {
        if (validateInput()) {
            devicesRepository.insertDevice(deviceUiState.deviceDetails.toDevice())
        }
    }

    private fun validateInput(uiState: DeviceDetails = deviceUiState.deviceDetails): Boolean {
        return with(uiState) {
            name.isNotBlank() && price.isNotBlank() && quantity.isNotBlank()
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
    val price: String = "",
    val quantity: String = "",
)

fun DeviceDetails.toDevice(): Device = Device(
    id = id,
    name = name,
    price = price.toDoubleOrNull() ?: 0.0,
    quantity = quantity.toIntOrNull() ?: 0
)

fun Device.formatedPrice(): String {
    return NumberFormat.getCurrencyInstance().format(price)
}

fun Device.toItemUiState(isEntryValid: Boolean = false): DeviceUiState = DeviceUiState(
    deviceDetails = this.toDeviceDetails(),
    isEntryValid = isEntryValid
)

fun Device.toDeviceDetails(): DeviceDetails = DeviceDetails(
    id = id,
    name = name,
)