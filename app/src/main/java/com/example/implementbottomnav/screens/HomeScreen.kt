package com.example.implementbottomnav.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(
    navController: NavHostController
) {
    Box(
        contentAlignment = Alignment.Center,
        content = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Home Screen", color = Color.Black)
                Spacer(modifier = Modifier.height(30.dp))
                ElevatedButton(
                    onClick = { navController.navigate("detail") }
                ) {
                    Text("Detail Screen")
                }
            }

        },
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray)
    )
}