package com.example.visionhcompose.ui


import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.visionhcompose.VisionHApplication
import com.example.visionhcompose.ui.screen.add_device.AddDeviceViewModel
import com.example.visionhcompose.ui.screen.devices.DevicesViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
//        initializer {
//            DeviceEditViewModel(
//                this.createSavedStateHandle()
//            )
//        }
//        // Initializer for ItemEntryViewModel
        initializer {
            AddDeviceViewModel(visionhApplication().container.devicesRepository)
        }
//
//        // Initializer for ItemDetailsViewModel
//        initializer {
//            DeviceDetailsViewModel(
//                this.createSavedStateHandle()
//            )
//        }

        initializer {
            DevicesViewModel()
        }
    }
}

fun CreationExtras.visionhApplication(): VisionHApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as VisionHApplication)
