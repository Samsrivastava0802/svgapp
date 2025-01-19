package com.samridhi.svgapp.navigation

sealed class AppScreen(val name: String, val route: String){
    data object HomeScreen : AppScreen("homeScreen", "homeScreen")
    data object GenerateScreen : AppScreen("generateScreen", "generateScreen")
    data object RecentlyGenerateScreen : AppScreen("recentlyGenerateScreen", "recentlyGenerateScreen")
}
