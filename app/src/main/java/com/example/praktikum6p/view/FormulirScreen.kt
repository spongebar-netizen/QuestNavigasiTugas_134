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