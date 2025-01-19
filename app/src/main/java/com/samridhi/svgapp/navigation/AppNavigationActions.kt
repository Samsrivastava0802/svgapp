package com.samridhi.svgapp.navigation

import androidx.navigation.NavController

class AppNavigationActions(
    private val navController: NavController,
    private val onFinish: () -> Unit
) {
    fun back() {
        navController.popBackStack()
    }

    private fun finishActivity() {
        onFinish()
    }

    fun navigateFromHomeScreen(action: HomeScreenActions) {
       when(action){
           HomeScreenActions.OpenGenerateScreen -> {
               navController.navigate(AppScreen.GenerateScreen.route)
           }

           HomeScreenActions.OpenRecentlyGeneratedScreen -> {
               navController.navigate(AppScreen.RecentlyGenerateScreen.route)
           }
       }
    }
    fun navigateFromGenerateScreen(actions: GenerateScreenActions){

    }
    fun navigateFromRecentlyGenerateScreen(actions: RecentlyGeneratedScreenActions){

    }

}