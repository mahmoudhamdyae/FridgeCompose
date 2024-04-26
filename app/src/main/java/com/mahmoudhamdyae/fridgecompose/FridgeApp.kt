package com.mahmoudhamdyae.fridgecompose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mahmoudhamdyae.fridgecompose.auth.presentation.screens.LoginDestination
import com.mahmoudhamdyae.fridgecompose.auth.presentation.screens.LoginScreen
import com.mahmoudhamdyae.fridgecompose.auth.presentation.screens.RegisterDestination
import com.mahmoudhamdyae.fridgecompose.auth.presentation.screens.RegisterScreen
import com.mahmoudhamdyae.fridgecompose.auth.presentation.screens.StartDestination
import com.mahmoudhamdyae.fridgecompose.auth.presentation.screens.StartScreen

@Composable
fun FridgeApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val openScreen: (String) -> Unit = {
        route -> navController.navigate(route) { launchSingleTop = true }
    }

    val openAndClear: (String) -> Unit = { route ->
        navController.navigate(route) {
            launchSingleTop = true
            popUpTo(0) { inclusive = true }
        }
    }

    val openAndPopUp: (String, String) -> Unit = { route, popUp ->
        navController.navigate(route) {
            launchSingleTop = true
            popUpTo(popUp) { inclusive = true }
        }
    }

    val navigateUp = { navController.popBackStack() }

    NavHost(
        navController = navController,
        startDestination = StartDestination.route,
        modifier = modifier
    ) {
        // Auth
        composable(route = StartDestination.route) {
            StartScreen(openScreen = openScreen)
        }
        composable(route = LoginDestination.route) {
            LoginScreen(openAndClear = openAndClear)
        }
        composable(route = RegisterDestination.route) {
            RegisterScreen(openAndClear = openAndClear, openScreen = openScreen)
        }
        // Home
    }
}