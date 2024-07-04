package com.example.composeuiexample.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.composeuiexample.ui.screens.DetailScreen
import com.example.composeuiexample.ui.screens.FavoritesScreen
import com.example.composeuiexample.ui.screens.HomeScreen
import com.example.composeuiexample.ui.screens.SettingsScreen

fun NavGraphBuilder.BottomNavGraph(navController: NavController,innerPaddingValues: PaddingValues){

    navigation(startDestination = NavigationScreens.HomeScreenRoute.route, route = NavigationScreens.BottomNavRoute.route){
        composable(route = NavigationScreens.HomeScreenRoute.route){
            HomeScreen(navController = navController,innerPaddingValues = innerPaddingValues)
        }
        composable(route = NavigationScreens.SettingsScreenRoute.route){
            SettingsScreen(navController = navController, innerPaddingValues = innerPaddingValues)
        }
        composable(route = NavigationScreens.FavoritesScreenRoute.route){
            FavoritesScreen(navController = navController, innerPaddingValues = innerPaddingValues)
        }
        
        composable(route = NavigationScreens.DetailScreenRoute.route){
            DetailScreen(navController = navController)
        }
    }
}