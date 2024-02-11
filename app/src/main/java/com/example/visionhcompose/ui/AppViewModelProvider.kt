package com.example.visionhcompose.ui


import android.app.Application
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.visionhcompose.VisionHApplication
//import com.example.inventory.ui.item.ItemDetailsViewModel
//import com.example.inventory.ui.item.ItemEditViewModel
//import com.example.inventory.ui.item.ItemEntryViewModel
import com.example.visionhcompose.data.DeviceViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
//        initializer {
//            DeviceEditViewModel(
//                this.createSavedStateHandle()
//            )
//        }
//        // Initializer for ItemEntryViewModel
//        initializer {
//            DeviceEntryViewModel(inventoryApplication().container.deviceRepository)
//        }
//
//        // Initializer for ItemDetailsViewModel
//        initializer {
//            DeviceDetailsViewModel(
//                this.createSavedStateHandle()
//            )
//        }

        initializer {
            DeviceViewModel()
        }
    }
}

fun CreationExtras.visionhApplication(): VisionHApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as VisionHApplication)
