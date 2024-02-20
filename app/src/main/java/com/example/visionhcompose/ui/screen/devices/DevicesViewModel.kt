package com.example.visionhcompose.ui.screen.devices

import androidx.lifecycle.ViewModel
import com.example.visionhcompose.data.Device

class DevicesViewModel() : ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

data class DevicesUiState(val itemList: List<Device> = listOf())