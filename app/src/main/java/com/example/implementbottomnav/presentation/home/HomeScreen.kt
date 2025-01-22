package com.example.implementbottomnav.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.implementbottomnav.data.dto.response.Result
import com.example.implementbottomnav.presentation.home.component.MovieCard

@Composable
fun HomeScreen(
    navController: NavHostController,
    uiState: NowPlayingUiState,
    action: (NowPlayingAction) -> Unit,
    nowPlayingData: List<Result?>
) {
    var tallestCardHeight by remember { mutableStateOf(0.dp) }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        content = {
            if (uiState.isLoading) {
                CircularProgressIndicator()
            } else {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.padding(vertical = 5.dp, horizontal = 20.dp)
                ) {
                    items(nowPlayingData) { movie ->
                        movie?.let {
                            MovieCard(
                                detail = it,
                                tallestCardHeight,
                                onCardHeightMeasured = { height -> tallestCardHeight = height })
                        }
                    }
                }
            }
        }
    )
}