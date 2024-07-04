package com.example.composeuiexample.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.composeuiexample.ui.screens.AppScreen
import com.example.composeuiexample.ui.screens.LoginScreen


fun NavGraphBuilder.LoginNavGraph(navController: NavController){

    navigation(startDestination = NavigationScreens.LoginScreenRoute.route, route = NavigationScreens.LoginRoute.route){
        composable(route = NavigationScreens.LoginScreenRoute.route){
            LoginScreen(navController)
        }
        composable(route = NavigationScreens.AppScreenRoute.route){
            AppScreen(navController)
        }
    }
}