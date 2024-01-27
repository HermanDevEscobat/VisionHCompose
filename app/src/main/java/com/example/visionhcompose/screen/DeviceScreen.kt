package com.example.visionhcompose.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.visionhcompose.class_data.DahuaDevice

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeviceScreen() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val deviceList = createDummyDahuaDeviceList()
    Column {
        CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary,
            ),
            title = {
                Text(
                    "Centered Top App Bar",
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
        deviceList.forEach { device ->
            CustomListItem(title = device.name) {
                
            }
        }
    }
}

fun createDummyDahuaDeviceList(): List<DahuaDevice> {
    val deviceList = mutableListOf<DahuaDevice>()
    repeat(10) { index ->
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
fun CustomListItem(
    title: String,
    imageUrl: String = "null",
    onEditClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .clickable { /* действие при клике на элемент списка */ }
    ) {
        // Отображение изображения
//        Image(
//            painter = rememberImagePainter(imageUrl),
//            contentDescription = "Image",
//            modifier = Modifier
//                .size(64.dp)
//                .clip(shape = RoundedCornerShape(8.dp))
//                .border(1.dp, MaterialTheme.colors.onSurface, shape = RoundedCornerShape(8.dp)),
//            contentScale = ContentScale.Crop
//        )

        // Отображение заголовка
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge
        )

        // Кнопка для редактирования
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = onEditClick) {
            Icon(Icons.Default.Edit, contentDescription = "Edit")
        }
    }
}
