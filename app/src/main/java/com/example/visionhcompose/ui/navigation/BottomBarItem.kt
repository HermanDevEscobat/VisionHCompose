package com.example.visionhcompose.ui.navigation

import com.example.visionhcompose.R

sealed class BottomBarItem(
    val route: String,
    val title: String,
    val icon: Int
) {
    data object Devices : BottomBarItem(
        route = "devices",
        title = "Devices",
        icon = R.drawable.rounded_camera_video_24
    )

    data object Archive : BottomBarItem(
        route = "archive",
        title = "Archive",
        icon = R.drawable.rounded_archive_24
    )

    data object Settings : BottomBarItem(
        route = "settings",
        title = "Settings",
        icon = R.drawable.rounded_settings_24
    )
}