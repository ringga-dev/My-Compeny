package com.ringga.chat.ui.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ringga.chat.ui.home.ui.theme.EtowaTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EtowaTheme {
                // A surface container using the 'background' color from the theme
                // remember navController so it does not
                // get recreated on recomposition
                val navController = rememberNavController()

                Surface(color = White) {
                    // Scaffold Component
                    Scaffold(
                        // Bottom navigation
                        bottomBar = {
                            BottomNavigationBar(navController = navController)
                        }, content = { padding ->
                            // Navhost: where screens are placed
                            NavHostContainer(navController = navController, padding = padding)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun NavHostContainer(
    navController: NavHostController,
    padding: PaddingValues
) {

    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = Modifier.padding(paddingValues = padding),
        builder = {

            // route : Home
            composable("home") {
                HomeScreen()
            }

            // route : search
            composable("search") {
                SearchScreen()
            }

            // route : profile
            composable("profile") {
                ProfileScreen()
            }

            // route :keranjang
            composable("keranjang") {
                KeranjangScreen()
            }

            // route :beranda
            composable("beranda") {
                BerandaScreen()
            }
        })

}

@Composable
fun BottomNavigationBar(navController: NavHostController) {

    BottomNavigation(

        // set background color
        backgroundColor = Color(0xFF0F9D58)
    ) {

        // observe the backstack
        val navBackStackEntry by navController.currentBackStackEntryAsState()

        // observe current route to change the icon
        // color,label color when navigated
        val currentRoute = navBackStackEntry?.destination?.route

        // Bottom nav items we declared
        Constants.BottomNavItems.forEach { navItem ->

            // Place the bottom nav items
            BottomNavigationItem(

                // it currentRoute is equal then its selected route
                selected = currentRoute == navItem.route,

                // navigate on click
                onClick = {
                    navController.navigate(navItem.route)
                },

                // Icon of navItem
                icon = {
                    Icon(imageVector = navItem.icon, contentDescription = navItem.label)
                },

                // label
                label = {
                    Text(text = navItem.label)
                },
                alwaysShowLabel = false
            )
        }
    }
}


