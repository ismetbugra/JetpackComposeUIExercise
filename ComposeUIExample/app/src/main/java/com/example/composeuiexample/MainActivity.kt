package com.example.composeuiexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.composeuiexample.ui.navigation.NavGraphLogin
import com.example.composeuiexample.ui.screens.LoginScreen
import com.example.composeuiexample.ui.theme.ComposeUIExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeUIExampleTheme {
                var navController = rememberNavController()
                NavGraphLogin(navController =navController )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeUIExampleTheme {

    }
}