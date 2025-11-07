package com.example.praktikum6p.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.praktikum6p.DataViewModel
import com.example.praktikum6p.Navigasi
import com.example.praktikum6p.R

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

    // --- STATE BARU UNTUK KONTROL POP-UP ---
    var showDialog by remember { mutableStateOf(false) }
    // ------------------------------------

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
                // --- FIX TEKS TEBAL (HITAM) ---
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black, // Teks saat diketik
                    unfocusedTextColor = Color.Black // Teks saat tidak difokus
                )
            )