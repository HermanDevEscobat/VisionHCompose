package com.example.visionhcompose.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.visionhcompose.R

@Composable
fun AddDeviceScreen() {
    Column {
        AddDeviceTopAppBar()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddDeviceTopAppBar() {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text("Editing device")
        },
        navigationIcon = {
            IconButton(onClick = { } ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.rounded_arrow_back_24),
                    contentDescription = "Localized description"
                )
            }
        }
    )
}

@Preview
@Composable
fun ViewAddDeviceScreen() {
//    AddDeviceScreen()
}
