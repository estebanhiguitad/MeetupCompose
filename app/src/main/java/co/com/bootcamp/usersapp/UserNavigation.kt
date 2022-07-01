package co.com.bootcamp.usersapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation

@Composable
fun UserNavigation(navHostController: NavHostController){
    NavHost(navController = navHostController, startDestination = "home/home"){
        navigation(startDestination = "home", route = "home/home"){
            composable(route = "home") {
                HomeScreen()
            }
        }

        navigation(startDestination = "play", route = "home/play"){
            composable(route = "play") {
                PlayScreen()
            }
        }

        navigation(startDestination = "search", route = "home/search"){
            composable(route = "search") {
                SearchScreen()
            }
        }

        navigation(startDestination = "profile", route = "home/profile"){
            composable(route = "profile") {
                ProfileScreen()
            }
        }
    }
}
