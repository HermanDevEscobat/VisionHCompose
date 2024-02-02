package com.example.visionhcompose.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun SettingsScreen(navController: NavHostController) {
    Column {
        Text(text = "This is com.example.visionhcompose.screen.SettingsScreen")
    }
}