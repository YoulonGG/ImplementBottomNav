package com.example.implementbottomnav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.implementbottomnav.ui.theme.ImplementBottomNavTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ImplementBottomNavTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
//    val nav = listOf(BottomItem.HOME, BottomItem.SEARCH, BottomItem.SAVED, BottomItem.ACCOUNT)
    Scaffold(
        bottomBar = {
//            if (currentRoute in nav
//            ) {
                BottomNav(navController)
//            }
        }, modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray)
    ) { innerPadding ->
        Box(
            Modifier.padding(innerPadding),
            content = {
                AppGraph(navController)
            }
        )
    }
}







