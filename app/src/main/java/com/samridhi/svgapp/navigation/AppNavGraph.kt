package com.samridhi.svgapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.samridhi.svgapp.presentation.generate.GenerateScreen
import com.samridhi.svgapp.presentation.home.HomeScreen
import com.samridhi.svgapp.presentation.recentlygenerated.RecentlyGeneratedScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
    startDestination: String = AppScreen.HomeScreen.route,
    navActions: AppNavigationActions
){
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        composable(
            route = AppScreen.HomeScreen.route
        ) {
             HomeScreen(
                 onActions = {
                     navActions.navigateFromHomeScreen(it)
                 }
             )
        }
        composable(
            route = AppScreen.GenerateScreen.route
        ) {
            GenerateScreen(
                onActions = {
                    navActions.navigateFromGenerateScreen(it)
                }
            )

        }
        composable(
            route = AppScreen.RecentlyGenerateScreen.route
        ) {
            RecentlyGeneratedScreen(
                onActions = {
                    navActions.navigateFromRecentlyGenerateScreen(it)
                }
            )
    }
    }
}