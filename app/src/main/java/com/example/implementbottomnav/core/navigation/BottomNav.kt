package com.example.implementbottomnav.core.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.implementbottomnav.R

@Composable
fun BottomNav(
    navController: NavController
) {
    val nav = listOf(BottomItem.HOME, BottomItem.FAVORITE)
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        containerColor = Color.White, modifier = Modifier.fillMaxWidth()
    ) {
        nav.forEach { nav ->
            val isSelected = currentDestination?.hierarchy?.any { it.route == nav.route } == true
            NavigationBarItem(
                label = {
                    Text(
                        nav.name,
                        fontSize = 12.sp,
                        color = if (isSelected) Color.Black else Color.Gray
                    )
                },
                icon = {
                    Image(
                        painter = painterResource(id = nav.icon),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                        colorFilter = ColorFilter.tint(
                            if (isSelected) Color.Black else Color.Gray
                        )
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent
                ),
                selected = isSelected,
                onClick = {
                    navController.navigate(nav.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
            )
        }
    }
}


sealed class BottomItem(val route: String, val icon: Int, val name: String) {

    data object HOME : BottomItem(
        route = "home", icon = R.drawable.home, name = "Home"
    )

    data object FAVORITE : BottomItem(
        route = "favorite", icon = R.drawable.heart, name = "Favorite"
    )


//    data object SEARCH : BottomItem(
//        route = "search", icon = R.drawable.baseline_search_24, name = "Search"
//    )
//
//    data object SAVED : BottomItem(
//        route = "saved", icon = R.drawable.baseline_bookmark_24, name = "Saved"
//    )
//
//    data object ACCOUNT : BottomItem(
//        route = "account", icon = R.drawable.baseline_person_24, name = "Account"
//    )
}