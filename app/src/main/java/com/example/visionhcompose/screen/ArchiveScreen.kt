package com.example.visionhcompose.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.visionhcompose.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
@ExperimentalFoundationApi
@ExperimentalMaterial3Api
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun ArchiveScreen(navController: NavHostController, paddingValues: PaddingValues) {
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(pageCount = { ArchiveTabs.entries.size })
    val selectedTabIndex = remember {
        derivedStateOf { pagerState.currentPage }
    }
    Scaffold(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
        topBar = {
            TopAppBarArchive(navController)
        },
        content = { innerPadding ->
            ContentArchive(pagerState, selectedTabIndex, scope, innerPadding)
        })
}

@Composable
@ExperimentalMaterial3Api
@ExperimentalFoundationApi
fun TopAppBarArchive(navController: NavHostController) {
    TopAppBar(
        title = {
            Text(
                "Archive",
                fontWeight = FontWeight.Bold
            )
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.rounded_filter_alt_24),
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
@ExperimentalFoundationApi
fun ContentArchive(
    pagerState: PagerState,
    selectedTabIndex: State<Int>,
    scope: CoroutineScope,
    innerPaddingValues: PaddingValues
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPaddingValues)
    ) {
        TabRow(
            modifier = Modifier.fillMaxWidth(),
            selectedTabIndex = selectedTabIndex.value,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex.value]).height(2.dp).weight(0.5f),
                    color = Color.Black
                )
            }
        ) {
            ArchiveTabs.entries.forEachIndexed { index, archiveTabs ->
                Tab(modifier = Modifier.background(Color.White),
                    selected = selectedTabIndex.value == index,
                    selectedContentColor = Color.Black,
                    unselectedContentColor = Color.Black,
                    onClick = {
                        scope.launch { pagerState.animateScrollToPage(archiveTabs.ordinal) }
                    },
                    text = { Text(archiveTabs.text) })
            }
        }
        HorizontalPager(
            state = pagerState, modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = ArchiveTabs.entries[selectedTabIndex.value].text)
            }
        }

    }

}

enum class ArchiveTabs(val text: String) {
    Video("Video"),
    Image("Image")
}