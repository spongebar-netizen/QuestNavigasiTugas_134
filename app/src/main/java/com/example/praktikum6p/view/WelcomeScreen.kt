package com.example.praktikum6p.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.praktikum6.R
import com.example.praktikum6p.Navigasi


val DarkPurple = Color(0xFFE600EE)
val CustomColor1 = Color(0xFFD32F2F)
val CustomColor2 = Color(0xFF1976D2)

@Composable
fun WelcomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .systemBarsPadding()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Text(
            text = stringResource(R.string.welcome_title),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = DarkPurple
        )


        Box(
            modifier = Modifier.size(200.dp),
            contentAlignment = Alignment.Center
        ) {

            Text("Tempat Logo di sini", textAlign = TextAlign.Center)
            Image(
                painter = painterResource(id = R.drawable.cyrene),
                contentDescription = "Logo",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = stringResource(R.string.welcome_name),
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium,
                color = CustomColor1
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(R.string.welcome_nim),
                fontSize = 18.sp,
                color = CustomColor2
            )
        }

        Button(
            onClick = {
                navController.navigate(Navigasi.Formulirku.name)
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = DarkPurple),
            shape = RoundedCornerShape(50)
        ) {
            Text(
                text = stringResource(R.string.welcome_submit),
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}
