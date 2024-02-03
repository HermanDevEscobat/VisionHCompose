package com.example.visionhcompose.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavHostController

@Composable
@ExperimentalMaterial3Api
@ExperimentalFoundationApi
fun SettingsScreen(navController: NavHostController, paddingValues: PaddingValues) {
    Scaffold(
        modifier = Modifier.padding(paddingValues),
        topBar = {
            TopAppBarSettings(navController)
        },
        content = { innerPadding ->
            ContentSettings(innerPadding)
        })

}

@Composable
@ExperimentalMaterial3Api
fun TopAppBarSettings(navController: NavHostController) {
    TopAppBar(
        title = {
            Text(
                "Settings",
                fontWeight = FontWeight.Bold
            )
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
fun ContentSettings(innerPaddingValues: PaddingValues) {
    var showDialog by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .padding(innerPaddingValues)
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
    ) {
        ListItem(
            headlineContent = { Text("Profile") },
            modifier = Modifier.clickable(onClick = {})
        )
        HorizontalDivider()
        ListItem(
            headlineContent = { Text("Language") },
            modifier = Modifier.clickable(onClick = { showDialog = true })
        )
        HorizontalDivider()
        ListItem(
            headlineContent = { Text("About") },
            modifier = Modifier.clickable(onClick = {})
        )
        HorizontalDivider()
        LanguageSelectionDialog(showDialog) {
            showDialog = false
        }
    }
}

@Composable
@ExperimentalMaterial3Api
@ExperimentalFoundationApi
fun LanguageSelectionDialog(
    showDialog: Boolean,
    onDismiss: () -> Unit
) {
    var selectedLanguage by remember { mutableStateOf("") }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { onDismiss() },
            text = {
                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = selectedLanguage == "English",
                            onClick = { selectedLanguage = "English" },
                        )
                        Text("English")
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = selectedLanguage == "Español",
                            onClick = { selectedLanguage = "Español" }
                        )
                        Text("Español")
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = selectedLanguage == "中文",
                            onClick = { selectedLanguage = "中文" }
                        )
                        Text("中文")
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = selectedLanguage == "Français",
                            onClick = { selectedLanguage = "Français" }
                        )
                        Text("Français")
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = selectedLanguage == "Русский",
                            onClick = { selectedLanguage = "Русский" }
                        )
                        Text("Русский")
                    }
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        // Здесь можно добавить логику для смены языка в соответствии с selectedLanguage
                        onDismiss()
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                Button(
                    onClick = { onDismiss() }
                ) {
                    Text("Cancel")
                }
            },
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true
            )
        )
    }
}
