package com.example.visionhcompose.ui.screen.devices

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.visionhcompose.data.Device
import com.example.visionhcompose.data.DevicesRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class DevicesViewModel(devicesRepository: DevicesRepository) : ViewModel() {
    val devicesUiState: StateFlow<DevicesUiState> =
        devicesRepository.getAllDevicesStream().map { DevicesUiState(it) }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = DevicesUiState()
        )

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

data class DevicesUiState(val devicesList: List<Device> = listOf())

