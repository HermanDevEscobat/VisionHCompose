package com.example.visionhcompose.ui.screen.add_device

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.visionhcompose.R
import com.example.visionhcompose.ui.AppViewModelProvider
import com.example.visionhcompose.ui.screen.devices.DevicesUiState
import androidx.lifecycle.viewmodel.compose.viewModel

var isFormFilled by mutableStateOf(false)

@Composable
@ExperimentalMaterial3Api
@ExperimentalFoundationApi
fun AddDeviceScreen(
    navController: NavHostController,
    innerPaddingValues: PaddingValues,
    viewModel: AddDeviceViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPaddingValues),
        topBar = {
            TopAppBarAddDevice(navController)
        },
        content = { innerPadding -> ContentAddDevice(innerPadding, navController, viewModel) }
    )
}

@Composable
@ExperimentalMaterial3Api
fun TopAppBarAddDevice(navController: NavHostController) {
    TopAppBar(
        title = { Text("Add device", fontWeight = FontWeight.Bold) },
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.rounded_arrow_back_24),
                    contentDescription = "Content description",
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
fun ContentAddDevice(
    innerPaddingValues: PaddingValues,
    deviceUiState: DevicesUiState,
    onDeviceValueChange: (DevicesDetails) -> Unit,
    navController: NavHostController,
    onAddClick: () -> Unit
) {
    var deviceName by rememberSaveable { mutableStateOf("") }
    var serialNumber by rememberSaveable { mutableStateOf("") }
    var userName by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordHidden by rememberSaveable { mutableStateOf(true) }

    fun checkForm() {
        isFormFilled =
            deviceName.isNotBlank() && serialNumber.isNotBlank() && userName.isNotBlank() && password.isNotBlank()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPaddingValues)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 8.dp),
        ) {
            OutlinedTextField(
                value = deviceName,
                onValueChange = {
                    deviceName = it
                    checkForm()
                },
                label = { Text("Device name") },
                shape = MaterialTheme.shapes.small,
                maxLines = 1,
                singleLine = true,
                isError = deviceName.length > 30,
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                )

            )
            OutlinedTextField(
                value = serialNumber,
                onValueChange = {
                    serialNumber = it
                    checkForm()
                },
                label = { Text("Serial number") },
                shape = MaterialTheme.shapes.small,
                maxLines = 1,
                singleLine = true,
                isError = deviceName.length > 30,
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                )

            )
            OutlinedTextField(
                value = userName,
                onValueChange = {
                    userName = it
                    checkForm()
                },
                label = { Text("User name") },
                shape = MaterialTheme.shapes.small,
                maxLines = 1,
                singleLine = true,
                isError = deviceName.length > 30,
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                )
            )
            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                    checkForm()
                },
                label = { Text("Password") },
                shape = MaterialTheme.shapes.small,
                maxLines = 1,
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                visualTransformation =
                if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),

                trailingIcon = {
                    IconButton(onClick = { passwordHidden = !passwordHidden }) {
                        val visibilityIcon =
                            if (passwordHidden) ImageVector.vectorResource(id = R.drawable.round_visibility_24) else ImageVector.vectorResource(
                                id = R.drawable.round_visibility_off_24
                            )
                        // Please provide localized description for accessibility services
                        val description = if (passwordHidden) "Show password" else "Hide password"
                        Icon(imageVector = visibilityIcon, contentDescription = description)
                    }
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(OutlinedTextFieldDefaults.MinHeight)
                    .align(Alignment.CenterHorizontally),
                shape = MaterialTheme.shapes.small,
                enabled = deviceUiState.isEntryValid,
                onClick = onAddClick
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.rounded_add_24),
                    contentDescription = "Content description",
                    tint = Color.Black
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(stringResource(id = R.string.button_add_device), color = Color.Black)
            }
        }
    }
}