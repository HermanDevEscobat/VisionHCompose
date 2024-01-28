package com.example.visionhcompose.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.visionhcompose.class_data.DahuaDevice

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeviceScreen() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val deviceList = createDummyDahuaDeviceList()
    Column {
        CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary,
            ),
            title = {
                Text(
                    "Centered Top App Bar",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            },
            navigationIcon = {
                IconButton(onClick = { /* do something */ }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Localized description"
                    )
                }
            },
            actions = {
                IconButton(onClick = { /* do something */ }) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "Localized description"
                    )
                }
            },
            scrollBehavior = scrollBehavior,
        )
        LazyColumn {
            items(deviceList) { device ->
                ElevatedCardDeviceItem(title = device.name) {
                }
            }
        }
    }
}

fun createDummyDahuaDeviceList(): List<DahuaDevice> {
    val deviceList = mutableListOf<DahuaDevice>()
    repeat(10) { index ->
        val device = DahuaDevice(
            name = "Dahua Camera ${index + 1}",
            model = "IPC-HDW1234",
            serialNumber = "123456789-${index + 1}",
            imageUrl = "https://example.com/device-${index + 1}.jpg"
        )
        deviceList.add(device)
    }
    return deviceList
}

@Composable
fun ElevatedCardDeviceItem(
    title: String,
    imageUrl: String = "null",
    onEditClick: () -> Unit
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.tertiary
            ),
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
        )
    }
}
