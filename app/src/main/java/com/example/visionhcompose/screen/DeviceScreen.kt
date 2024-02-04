package com.example.visionhcompose.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.visionhcompose.R
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import androidx.navigation.NavHostController
import com.example.visionhcompose.class_data.DahuaDevice
import kotlin.math.absoluteValue

@Composable
@ExperimentalMaterial3Api
@ExperimentalFoundationApi
fun DeviceScreen(navController: NavHostController, innerPaddingValues: PaddingValues) {
    Scaffold(
        modifier = Modifier
            .padding(innerPaddingValues)
            .fillMaxSize(),
        topBar = {
            TopAppBarDevice(navController)
        },
        content = { innerPadding ->
            ContentDevice(innerPadding)
        }
    )
}


@Composable
@ExperimentalMaterial3Api
fun TopAppBarDevice(navController: NavHostController) {
    TopAppBar(
        title = { Text("Device",
            fontWeight = FontWeight.Bold ) },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.rounded_search_24),
                    contentDescription = "Localized description",
                    tint = Color.White
                )
            }
            IconButton(onClick = {
                navController.navigate("add_device")
            }) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.rounded_add_circle_24),
                    contentDescription = "Localized description",
                    tint = Color.White
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black,
            titleContentColor = Color.White
        )
    )
}

@Composable
@ExperimentalMaterial3Api
@ExperimentalFoundationApi
fun ContentDevice(innerPaddingValues: PaddingValues) {
    val deviceList by remember { mutableStateOf(createDummyDahuaDeviceList()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPaddingValues)
    ) {
        LazyColumn {
            items(deviceList) { device ->
                Column {
                    ListItem(
                        modifier = Modifier.clickable(onClick = {}),
                        headlineContent = {
                            val pagerState = rememberPagerState(pageCount = {
                                4
                            })
                            HorizontalPager(
                                state = pagerState,
                                contentPadding = PaddingValues(horizontal = 32.dp),
                                pageSpacing = 10.dp
                            ) { page ->
                                Card(
                                    modifier = Modifier
                                        .size(width = 240.dp, height = 100.dp)
                                        .graphicsLayer {
                                            val pageOffset = (
                                                    (pagerState.currentPage - page) + pagerState
                                                        .currentPageOffsetFraction
                                                    ).absoluteValue

                                            alpha = lerp(
                                                start = 0.5f,
                                                stop = 1f,
                                                fraction = 1f - pageOffset.coerceIn(0f, 1f)
                                            )
                                        }
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        verticalArrangement = Arrangement.Bottom,
                                        horizontalAlignment = Alignment.End
                                    ) {
                                        Text(
                                            text = "Cam ${page + 1}",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 10.sp,
                                            modifier = Modifier.padding(horizontal = 8.dp)
                                        )
                                    }

                                }
                            }
                        },
                        overlineContent = {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    device.name,
                                    modifier = Modifier.weight(1f),
                                    fontWeight = FontWeight.Bold
                                )
                                Box(
                                    modifier = Modifier
                                        .size(8.dp)
                                        .background(
                                            color = Color.Green,
                                            shape = CircleShape
                                        )
                                        .padding(8.dp)
                                )
                            }
                        }
                    )
                    HorizontalDivider()
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
