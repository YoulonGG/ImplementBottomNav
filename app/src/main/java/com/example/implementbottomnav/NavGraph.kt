package com.example.implementbottomnav

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.implementbottomnav.screens.AccountScreen
import com.example.implementbottomnav.screens.DetailScreen
import com.example.implementbottomnav.screens.HomeScreen
import com.example.implementbottomnav.screens.SavedScreen
import com.example.implementbottomnav.screens.SearchScreen


@Composable
fun AppGraph(navController: NavHostController) {

    NavHost(
        modifier = Modifier.fillMaxSize(),
        navController = navController,
        startDestination = BottomItem.HOME.route
    ) {
        composable(BottomItem.HOME.route) {
            HomeScreen(navController)
        }

        composable(BottomItem.SEARCH.route) {
            SearchScreen()
        }

        composable(BottomItem.SAVED.route) {
            SavedScreen()
        }

        composable(BottomItem.ACCOUNT.route) {
            AccountScreen()
        }
        composable("detail") {
            DetailScreen()
        }
    }
}

