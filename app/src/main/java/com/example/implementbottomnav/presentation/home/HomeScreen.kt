package com.example.implementbottomnav.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.implementbottomnav.data.dto.response.Result
import com.example.implementbottomnav.presentation.home.component.MovieCard

@Composable
fun HomeScreen(
    navController: NavHostController,
    uiState: NowPlayingUiState,
    action: (NowPlayingAction) -> Unit,
    nowPlayingData: List<Result>
) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize(),
        content = {

            if (uiState.isError) {
                Text("Error Data Loading...")
            } else if (uiState.isLoading) {
                CircularProgressIndicator()
            } else {
                LazyVerticalStaggeredGrid(
                    columns = StaggeredGridCells.Fixed(2),
                    verticalItemSpacing = 4.dp,
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    content = {
                        items(nowPlayingData) { data ->
                            MovieCard(detail = data)
                        }
                    },
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    )
}