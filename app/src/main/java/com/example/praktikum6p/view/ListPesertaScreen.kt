package com.example.praktikum6p.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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

@Composable
fun ListPesertaScreen(
    navController: NavController,
    viewModel: DataViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(LightBackground)
            .systemBarsPadding()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(HeaderPurple)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.list_title),
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DataCard(label = stringResource(R.string.nama_lengkap), data = uiState.nama)
            Spacer(modifier = Modifier.height(16.dp))
            DataCard(label = stringResource(R.string.jenis_kelamin), data = uiState.jenisKelamin)
            Spacer(modifier = Modifier.height(16.dp))
            DataCard(label = stringResource(R.string.status_perkawinan), data = uiState.status)
            Spacer(modifier = Modifier.height(16.dp))
            DataCard(label = stringResource(R.string.alamat), data = uiState.alamat)

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    navController.navigate(Navigasi.Welcome.name)
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = HeaderPurple),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(text = stringResource(R.string.list_beranda))
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    navController.navigate(Navigasi.Formulirku.name)
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(text = stringResource(R.string.list_formulir), color = HeaderPurple)
            }
        }
    }
}

@Composable
fun DataCard(label: String, data: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = label, style = MaterialTheme.typography.labelMedium, color = Color.Gray)
            Text(text = data, fontSize = 20.sp, fontWeight = FontWeight.Medium)
        }
    }
}