package com.example.visionhcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.visionhcompose.screen.ArchiveScreen
import com.example.visionhcompose.screen.DeviceScreen
import com.example.visionhcompose.ui.theme.VisionHComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VisionHComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppContent()
                }
            }
        }
    }
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun AppContent() {
    var selectedItem by remember { mutableIntStateOf(0) }
    data class NavigationItem(val label: String, val icon: ImageVector)
    val items = listOf(
        NavigationItem("Device",ImageVector.vectorResource(id = R.drawable.rounded_camera_video_24)),
        NavigationItem("Archive", ImageVector.vectorResource(id = R.drawable.rounded_archive_24)),
        NavigationItem("Settings", ImageVector.vectorResource(id = R.drawable.rounded_settings_24))
    )
    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                NavigationBar {
                    items.forEachIndexed { index, item ->
                        NavigationBarItem(
                            icon = { Icon(imageVector = item.icon, contentDescription = item.label) },
                            label = { Text(item.label) },
                            selected = selectedItem == index,
                            onClick = { selectedItem = index }
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            when (selectedItem) {
                0 -> DeviceScreen()
                1 -> ArchiveScreen()
                2 -> Text("Settings was selected")
            }
        }
    }
}



@Preview
@Composable
fun PreviewAppContent() {
    VisionHComposeTheme {
        AppContent()
    }
}