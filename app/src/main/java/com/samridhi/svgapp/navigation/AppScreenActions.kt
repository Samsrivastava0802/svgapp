package com.samridhi.svgapp.navigation

sealed class HomeScreenActions {
    data object OpenGenerateScreen : HomeScreenActions()
    data object OpenRecentlyGeneratedScreen : HomeScreenActions()
}

sealed class GenerateScreenActions {

}
sealed class RecentlyGeneratedScreenActions {

}
