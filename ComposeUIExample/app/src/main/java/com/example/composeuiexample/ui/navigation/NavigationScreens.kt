package com.example.composeuiexample.ui.navigation

sealed class NavigationScreens(val route:String) {
    object LoginScreenRoute : NavigationScreens("Login")
    object HomeScreenRoute : NavigationScreens("Home")
    object SettingsScreenRoute : NavigationScreens("Settings")
    object FavoritesScreenRoute : NavigationScreens("Favorites")
    object LoginRoute : NavigationScreens("LoginRoute")
    object BottomNavRoute : NavigationScreens("BottomNav")
    object AppScreenRoute : NavigationScreens("AppScreen")
    object DetailScreenRoute : NavigationScreens("Detail")
}