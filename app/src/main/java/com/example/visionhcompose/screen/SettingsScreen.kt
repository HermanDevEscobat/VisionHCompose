package com.example.visionhcompose.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

@Composable
@ExperimentalMaterial3Api
fun SettingsScreen(navController: NavHostController) {
    Scaffold(topBar = {
        TopAppBarSettings()
    },
        content = { innerPadding ->
            ContentSettings(innerPadding)
        })
}

@Composable
@ExperimentalMaterial3Api
fun TopAppBarSettings() {
    TopAppBar(
        title = { Text(text = "Settings") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black,
            titleContentColor = Color.White
        )
    )
}

@Composable
@ExperimentalMaterial3Api
fun ContentSettings(innerPaddingValues: PaddingValues) {
    Box(
        modifier = Modifier
            .padding(innerPaddingValues)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Hello Settings!")
    }
}