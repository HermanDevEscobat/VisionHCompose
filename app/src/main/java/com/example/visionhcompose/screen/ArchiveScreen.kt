package com.example.visionhcompose.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch

@Composable
fun ArchiveScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {
        TabScreen()
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabScreen() {
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(pageCount = { ArchiveTabs.entries.size })
    val selectedTabIndex = remember {
        derivedStateOf { pagerState.currentPage }
    }
    val tabs = listOf("Video", "Image")

    Column(modifier = Modifier.fillMaxSize()) {
        TabRow(
            modifier = Modifier.fillMaxWidth(),
            selectedTabIndex = selectedTabIndex.value
        ) {
            ArchiveTabs.entries.forEachIndexed { index, archiveTabs ->
                Tab(selected = selectedTabIndex.value == index,
                    selectedContentColor = MaterialTheme.colorScheme.primary,
                    unselectedContentColor = MaterialTheme.colorScheme.outline,
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