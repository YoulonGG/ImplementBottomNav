package com.example.implementbottomnav.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun DetailScreen() {
    Box(
        contentAlignment = Alignment.Center,
        content = {
            Text("Detail Screen")
        },
        modifier = Modifier.fillMaxSize()
    )
}