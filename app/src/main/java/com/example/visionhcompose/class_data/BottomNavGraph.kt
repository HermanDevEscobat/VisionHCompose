package com.example.visionhcompose.class_data

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.visionhcompose.screen.AddDeviceScreen
import com.example.visionhcompose.screen.ArchiveScreen
import com.example.visionhcompose.screen.DeviceScreen
import com.example.visionhcompose.screen.SettingsScreen

@Composable
@ExperimentalFoundationApi
@ExperimentalMaterial3Api
fun BottomNavGraph(navController: NavHostController, innerPaddingValues: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Device.route
    ) {
        composable(
            route = BottomBarScreen.Device.route,
            enterTransition = {
                fadeIn(
                    animationSpec = tween(
                        300,
                        easing = LinearEasing
                    )
                ) + slideIntoContainer(
                    animationSpec = tween(300, easing = EaseIn),
                    towards = AnimatedContentTransitionScope.SlideDirection.Start
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        300, easing = LinearEasing
                    )
                ) + slideOutOfContainer(
                    animationSpec = tween(300, easing = EaseOut),
                    towards = AnimatedContentTransitionScope.SlideDirection.End
                )
            }
        ) {
            DeviceScreen(navController = navController, innerPaddingValues)

        }

        composable(route = BottomBarScreen.Archive.route,
            enterTransition = {
                fadeIn(
                    animationSpec = tween(
                        300,
                        easing = LinearEasing
                    )
                ) + slideIntoContainer(
                    animationSpec = tween(300, easing = EaseIn),
                    towards = AnimatedContentTransitionScope.SlideDirection.Start
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        300, easing = LinearEasing
                    )
                ) + slideOutOfContainer(
                    animationSpec = tween(300, easing = EaseOut),
                    towards = AnimatedContentTransitionScope.SlideDirection.End
                )
            }) {
            ArchiveScreen(navController = navController, innerPaddingValues)
        }

        composable(route = BottomBarScreen.Settings.route,
            enterTransition = {
                fadeIn(
                    animationSpec = tween(
                        300,
                        easing = LinearEasing
                    )
                ) + slideIntoContainer(
                    animationSpec = tween(300, easing = EaseIn),
                    towards = AnimatedContentTransitionScope.SlideDirection.Start
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        300, easing = LinearEasing
                    )
                ) + slideOutOfContainer(
                    animationSpec = tween(300, easing = EaseOut),
                    towards = AnimatedContentTransitionScope.SlideDirection.End
                )
            }) {
            SettingsScreen(navController = navController, innerPaddingValues)
        }

        composable(route = "add_device",
            enterTransition = {
                fadeIn(
                    animationSpec = tween(
                        300,
                        easing = LinearEasing
                    )
                ) + slideIntoContainer(
                    animationSpec = tween(300, easing = EaseIn),
                    towards = AnimatedContentTransitionScope.SlideDirection.Start
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        300, easing = LinearEasing
                    )
                ) + slideOutOfContainer(
                    animationSpec = tween(300, easing = EaseOut),
                    towards = AnimatedContentTransitionScope.SlideDirection.End
                )
            }) {
            AddDeviceScreen(navController = navController, innerPaddingValues)
        }
    }
}