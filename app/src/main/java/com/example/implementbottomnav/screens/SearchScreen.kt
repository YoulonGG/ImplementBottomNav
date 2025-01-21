package com.example.implementbottomnav.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun SearchScreen() {
    Box(
        contentAlignment = Alignment.Center,
        content = {
            Text("Search Screen")
        },
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray)
    )
}