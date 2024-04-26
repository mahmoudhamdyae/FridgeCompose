package com.mahmoudhamdyae.fridgecompose.home.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mahmoudhamdyae.fridgecompose.R
import com.mahmoudhamdyae.fridgecompose.core.navigation.NavigationDestination

object HomeDestination: NavigationDestination {
    override val route: String = "home"
    override val titleRes: Int = R.string.app_name
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
}