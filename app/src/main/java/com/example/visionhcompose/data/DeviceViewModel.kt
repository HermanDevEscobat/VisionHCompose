package com.example.visionhcompose.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DeviceViewModel(private val deviceDao: DeviceDao) : ViewModel() {
    fun insertDevice(device: Device) {
        viewModelScope.launch {
            deviceDao.insert(device)
        }
    }
}