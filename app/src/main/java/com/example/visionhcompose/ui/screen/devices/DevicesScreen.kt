package com.example.visionhcompose.ui.screen.devices

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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.visionhcompose.R
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.visionhcompose.data.Device

@Composable
@ExperimentalMaterial3Api
@ExperimentalFoundationApi
fun DevicesScreen(navController: NavHostController, innerPaddingValues: PaddingValues) {
    Scaffold(
        modifier = Modifier
            .padding(innerPaddingValues)
            .fillMaxSize(),
        topBar = {
            TopAppBarDevice(navController)
        },
        content = { innerPadding ->
            DeviceBody(
                itemList = listOf(),
                onItemClick = {},
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            )
        }
    )
}

@Composable
@ExperimentalMaterial3Api
fun TopAppBarDevice(navController: NavHostController) {
    TopAppBar(
        title = {
            Text(
                "Devices",
                fontWeight = FontWeight.Bold
            )
        },
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
private fun DeviceBody(
    itemList: List<Device>, onItemClick: (Int) -> Unit, modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        if (itemList.isEmpty()) {
            Box(
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_small))
                    .size(200.dp, 100.dp)
                    .background(
                        Color.Black,
                        shape = MaterialTheme.shapes.small
                    )
                    .padding(dimensionResource(id = R.dimen.padding_small)),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = stringResource(R.string.no_item_description),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = dimensionResource(id = R.dimen.text_size_medium).value.sp,
                    color = Color.White,
                )
            }
        } else {
            DeviceList(
                itemList = itemList,
                onItemClick = { onItemClick(it.id) },
                modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.padding_small))
            )
        }
    }
}

@Composable
@ExperimentalFoundationApi
@ExperimentalMaterial3Api
private fun DeviceList(
    itemList: List<Device>, onItemClick: (Device) -> Unit, modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(items = itemList, key = { it.id }) { item ->
            DeviceItem(item = item,
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_small))
                    .clickable { onItemClick(item) })
        }
    }
}

@Composable
@ExperimentalMaterial3Api
@ExperimentalFoundationApi
private fun DeviceItem(
    item: Device, modifier: Modifier = Modifier
) {
    Column {
        val pagerState = rememberPagerState(pageCount = {
            4
        })
        ListItem(
            modifier = Modifier.clickable(onClick = {}),
            headlineContent = {

                HorizontalPager(
                    modifier = Modifier.padding(vertical = 4.dp),
                    state = pagerState,
                    pageSpacing = 8.dp
                ) { page ->
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .fillMaxWidth()
                            .background(Color.Black)
                            .height(150.dp),
                        content = {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize(),
                                content = {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .weight(1f)
                                    ) {}
                                    Row(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .weight(1f),
                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            text = "NO SIGNAL",
                                            fontWeight = FontWeight.Bold,
                                            color = Color.White,
                                            fontSize = 16.sp,
                                            modifier = Modifier.padding(horizontal = 8.dp)
                                        )
                                    }
                                    Row(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .weight(1f),
                                        horizontalArrangement = Arrangement.End,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            text = "Cam ${page + 1}",
                                            fontWeight = FontWeight.Bold,
                                            color = Color.White,
                                            fontSize = 10.sp,
                                            modifier = Modifier.padding(4.dp)
                                        )
                                    }
                                }
                            )
                        }
                    )
                }

            },
            overlineContent = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        item.name,
                        modifier = Modifier.weight(1f),
                        fontWeight = FontWeight.Bold
                    )
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .background(
                                color = Color.Red,
                                shape = CircleShape
                            )
                            .padding(8.dp)
                    )
                }
            }, supportingContent = {
                Row(
                    Modifier
                        .wrapContentHeight()
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally),
                    horizontalArrangement = Arrangement.Center
                ) {
                    repeat(pagerState.pageCount) { iteration ->
                        val color =
                            if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                        Box(
                            modifier = Modifier
                                .padding(2.dp)
                                .clip(CircleShape)
                                .background(color)
                                .size(10.dp)
                        )
                    }
                }
            }
        )
        HorizontalDivider()
    }

}
