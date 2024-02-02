package com.example.visionhcompose.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.navigation.NavController

@Composable
fun AddDeviceScreen() {
    Column {
        AddDeviceView()
    }
}

@Composable
fun AddDeviceView() {
    Column{
        Text(text = "Hi! This is ViewAddDevice")
    }
}
