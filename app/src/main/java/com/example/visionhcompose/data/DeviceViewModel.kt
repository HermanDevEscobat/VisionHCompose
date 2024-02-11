package com.example.visionhcompose.data

import androidx.lifecycle.ViewModel


class DeviceViewModel() : ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

data class DeviceUiState(val deviceList: List<Device> = listOf())