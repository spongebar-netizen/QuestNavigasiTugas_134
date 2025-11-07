package com.example.praktikum6p.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.praktikum6.R
import com.example.praktikum6p.DataViewModel
import com.example.praktikum6p.Navigasi


val HeaderPurple = Color(0xFF9C27B0)
val ButtonPurple = Color(0xFF7B1FA2)
val LightBackground = Color(0xFFF3E5F5)

@Composable
fun FormulirScreen(
    navController: NavController,
    viewModel: DataViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()
    var showDialog by remember { mutableStateOf(false) }

    val jenisKelaminOptions = listOf(
        stringResource(R.string.option_pria),
        stringResource(R.string.option_wanita)
    )
    val statusOptions = listOf(
        stringResource(R.string.option_janda),
        stringResource(R.string.option_lajang),
        stringResource(R.string.option_duda)
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(LightBackground)
            .systemBarsPadding()
            .verticalScroll(rememberScrollState())
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(HeaderPurple)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.form_title),
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                FormLabel(text = stringResource(R.string.nama_lengkap))
                OutlinedTextField(
                    value = uiState.nama,
                    onValueChange = { viewModel.setNama(it) },
                    placeholder = { Text(stringResource(R.string.placeholder_nama)) },
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                FormLabel(text = stringResource(R.string.jenis_kelamin))
                jenisKelaminOptions.forEach { option ->
                    RadioOption(
                        text = option,
                        selected = (uiState.jenisKelamin == option),
                        onClick = { viewModel.setJenisKelamin(option) }
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                FormLabel(text = stringResource(R.string.status_perkawinan))
                statusOptions.forEach { option ->
                    RadioOption(
                        text = option,
                        selected = (uiState.status == option),
                        onClick = { viewModel.setStatus(option) }
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                FormLabel(text = stringResource(R.string.alamat))
                OutlinedTextField(
                    value = uiState.alamat,
                    onValueChange = { viewModel.setAlamat(it) },
                    placeholder = { Text(stringResource(R.string.placeholder_alamat)) },
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black
                    )
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = { showDialog = true },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = ButtonPurple),
                    shape = RoundedCornerShape(50)
                ) {
                    Text(
                        text = stringResource(R.string.welcome_submit),
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(stringResource(R.string.dialog_title)) },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("${stringResource(R.string.dialog_nama)} ${uiState.nama}")
                    Text("${stringResource(R.string.dialog_kelamin)} ${uiState.jenisKelamin}")
                    Text("${stringResource(R.string.dialog_status)} ${uiState.status}")
                    Text("${stringResource(R.string.dialog_alamat)} ${uiState.alamat}")
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        showDialog = false
                        navController.navigate(Navigasi.Detail.name)
                    }
                ) {
                    Text(stringResource(R.string.dialog_ok))
                }
            }
        )
    }
}

@Composable
fun FormLabel(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.labelMedium,
        color = Color.Gray,
        modifier = Modifier.padding(bottom = 4.dp)
    )
}

@Composable
fun RadioOption(text: String, selected: Boolean, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .selectable(
                selected = selected,
                onClick = onClick
            )
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected,
            onClick = onClick
        )
        Text(text = text, modifier = Modifier.padding(start = 8.dp))
    }
}