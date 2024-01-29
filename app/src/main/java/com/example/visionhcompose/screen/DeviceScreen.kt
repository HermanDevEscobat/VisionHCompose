package com.example.visionhcompose.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.visionhcompose.class_data.DahuaDevice
import com.example.visionhcompose.ui.theme.VisionHComposeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeviceScreen() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val deviceList by remember { mutableStateOf(createDummyDahuaDeviceList()) }
    Column {
        CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary,
            ),
            title = {
                Text(
                    "VisionH",
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
    repeat(15) { index ->
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
        val emptyTiles = List(4) { index -> index }
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(3f)
            ) {
                Column(
                    modifier = Modifier
                        .weight(6f)
                        .fillMaxHeight()
                        .padding(8.dp)
                ) {
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    ) {
                        itemsIndexed(emptyTiles) { index, _ ->
                            BlackTile(index = index)
                        }
                    }
                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.Top
                ) {
                    IconButton(onClick = { /*TODO*/ }
                    ) {
                        Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "More")
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = title,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.tertiary
                    ),
                    modifier = Modifier
                        .padding(8.dp),
                    textAlign = TextAlign.Center,
                )
            }

        }
    }
}

@Preview
@Composable
fun PreviewDeviceScreen() {
    VisionHComposeTheme {
        DeviceScreen()
    }
}

@Composable
fun BlackTile(index: Int) {
    val tileSize = 100.dp
    Box(
        modifier = Modifier
            .size(tileSize)
            .padding(horizontal = 4.dp)
            .background(Color.Black)
    )
}