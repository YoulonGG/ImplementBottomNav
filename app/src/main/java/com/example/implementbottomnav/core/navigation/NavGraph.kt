package com.example.implementbottomnav.core.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.implementbottomnav.presentation.home.HomeContract
import com.example.implementbottomnav.presentation.screens.DetailScreen
import com.example.implementbottomnav.presentation.screens.FavoriteScreen


@Composable
fun AppGraph(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomNav(navController)
        }
    ) { innerPadding ->
        NavHost(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            navController = navController,
            startDestination = BottomItem.HOME.route
        ) {
            composable(BottomItem.HOME.route) {
                HomeContract()
            }

            composable(BottomItem.FAVORITE.route) {
                FavoriteScreen()
            }

            navigation(
                startDestination = "detail",
                route = "detail_graph"
            ) {
                composable("detail") {
                    DetailScreen()
                }
            }
        }
    }
}





