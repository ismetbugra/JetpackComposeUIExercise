package com.example.composeuiexample.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun SettingsScreen(navController: NavController,innerPaddingValues: PaddingValues){

    Column(modifier = Modifier.padding(innerPaddingValues).fillMaxSize()) {
        Text(text = "Settings", color = Color.Red)
    }
}