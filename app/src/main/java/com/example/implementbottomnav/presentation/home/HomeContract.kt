package com.example.implementbottomnav.presentation.home

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeContract() {

    val viewModel: HomeViewModel = hiltViewModel()
    val navController = rememberNavController()

    HomeScreen(
        navController = navController,
        uiState = viewModel.uiState.collectAsStateWithLifecycle().value,
        action = viewModel::onAction,
        nowPlayingData = viewModel.nowPlayingData.collectAsStateWithLifecycle().value
    )

}