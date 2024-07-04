package com.example.composeuiexample.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun NavGraphApp(navController: NavHostController,innerPaddingValues: PaddingValues){
    NavHost(navController = navController, startDestination = NavigationScreens.BottomNavRoute.route){
        BottomNavGraph(navController,innerPaddingValues)
    }
}