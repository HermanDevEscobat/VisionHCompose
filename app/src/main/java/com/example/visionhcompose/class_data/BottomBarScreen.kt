package com.example.visionhcompose.class_data

import com.example.visionhcompose.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int
) {
    data object Device : BottomBarScreen(
        route = "device",
        title = "Device",
        icon = R.drawable.rounded_camera_video_24
    )

    data object Archive : BottomBarScreen(
        route = "archive",
        title = "Archive",
        icon = R.drawable.rounded_archive_24
    )

    data object Settings : BottomBarScreen(
        route = "settings",
        title = "Settings",
        icon = R.drawable.rounded_settings_24
    )
}