package com.example.composeuiexample.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun NavGraphLogin(navController:NavHostController){

    NavHost(navController = navController, startDestination = NavigationScreens.LoginRoute.route){
        LoginNavGraph(navController)

    }
}