package com.example.implementbottomnav

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.implementbottomnav.core.navigation.AppGraph
import com.example.implementbottomnav.core.utils.InternetUtil
import com.example.implementbottomnav.ui.theme.ImplementBottomNavTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            ImplementBottomNavTheme {
                AppGraph(navController)
            }
        }
    }
}



@HiltAndroidApp
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        InternetUtil.init(this)
    }
}








