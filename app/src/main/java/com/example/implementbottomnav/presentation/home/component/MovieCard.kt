package com.example.implementbottomnav.presentation.home.component

import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.implementbottomnav.data.dto.response.Result

@Composable
fun MovieCard(
    detail: Result
) {
    ElevatedCard(
        modifier = Modifier,
        onClick = {}
    ) {
        Text(detail.title ?: "No Data")
        Text(detail.releaseDate ?: "No Data")
        Text(detail.overview ?: "No Data")
    }
}