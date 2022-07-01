package co.com.bootcamp.usersapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import co.com.bootcamp.usersapp.ui.theme.UsersAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            UsersAppTheme {
                val navController = rememberNavController()
                Scaffold(
                    topBar = { UsersTopBar() },
                    content = {
                        UserNavigation(navHostController = navController)
                    },
                    bottomBar = { BottomUsersBar(
                        { navController.navigate("home/home") },
                        { navController.navigate("home/play") },
                        { navController.navigate("home/search") },
                        { navController.navigate("home/profile") },
                    ) }
                )
            }
        }
    }
}

@Composable
private fun BottomUsersBar(
    onHomeClick: () -> Unit,
    onPlayClick: () -> Unit,
    onSearchClick: () -> Unit,
    onProfileClick: () -> Unit
) {
    BottomAppBar {
        BottomNavigationItem(selected = true, onClick = onHomeClick, icon = {
            Icon(Icons.Default.Home, "Item de inicio")
        })
        BottomNavigationItem(selected = false, onClick = onPlayClick, icon = {
            Icon(Icons.Default.PlayArrow, "Item de play")
        })
        BottomNavigationItem(selected = false, onClick = onSearchClick, icon = {
            Icon(Icons.Default.Search, "Item de busqueda")
        })
        BottomNavigationItem(selected = false, onClick = onProfileClick, icon = {
            Icon(Icons.Default.AccountCircle, "Item de perfil")
        })
    }
}

