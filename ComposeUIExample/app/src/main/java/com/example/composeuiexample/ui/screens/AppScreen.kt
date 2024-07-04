package com.example.composeuiexample.ui.screens

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composeuiexample.R
import com.example.composeuiexample.ui.data.BottomNavItem
import com.example.composeuiexample.ui.navigation.NavGraphApp
import com.example.composeuiexample.ui.navigation.NavigationScreens
import com.example.composeuiexample.ui.theme.NGray


var bottomList = listOf(
    BottomNavItem(
        title = "Home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        route = NavigationScreens.HomeScreenRoute.route
    ),
    BottomNavItem(
        title = "Settings",
        selectedIcon = Icons.Filled.Settings,
        unselectedIcon = Icons.Outlined.Settings,
        route = NavigationScreens.SettingsScreenRoute.route
    ),
    BottomNavItem(
        title = "Favorites",
        selectedIcon = Icons.Filled.Favorite,
        unselectedIcon = Icons.Outlined.Favorite,
        route = NavigationScreens.FavoritesScreenRoute.route
    )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScreen(navController: NavController){
    val navControllerApp = rememberNavController()

    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

    var scrollBehavior=TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    Scaffold(modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar(containerColor = Color.Black,
                contentColor = Color.Red) {

                bottomList.forEachIndexed { index, bottomNavItem ->

                    NavigationBarItem(selected = selectedItemIndex==index,
                        onClick = {
                            selectedItemIndex=index
                            navControllerApp.navigate(bottomNavItem.route)
                        },
                        icon = {
                        Icon(imageVector =if (selectedItemIndex==index){
                            bottomNavItem.selectedIcon }else{
                                bottomNavItem.unselectedIcon } , contentDescription ="" )
                    })
                }
            }

        },
        topBar = {
            TopAppBar(title = {
                Row (horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()){
                    Image(painter = painterResource(id = R.drawable.netflixlogobrand ), contentDescription ="",
                        modifier = Modifier.padding(top = 16.dp))
                }
            },
                actions = {
                          IconButton(onClick = { /*TODO*/ }) {
                              Icon(imageVector = Icons.Default.MoreVert, contentDescription = "", tint = Color.Gray)
                          }
                },
                scrollBehavior=scrollBehavior
                ,
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Black))

        }) {
        NavGraphApp(navController = navControllerApp, innerPaddingValues = it)
    }
}