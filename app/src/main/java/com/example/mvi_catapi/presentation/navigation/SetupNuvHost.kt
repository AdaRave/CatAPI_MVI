package com.example.mvi_catapi.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mvi_catapi.presentation.screen.main.MainScreen

sealed class Screens(val rout: String) {
    object MainScreenType : Screens(rout = "main_screen")
}

@Composable
fun SetupNuvHost(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Screens.MainScreenType.rout) {
        composable(Screens.MainScreenType.rout) {
            MainScreen (navHostController = navHostController)
        }
    }

}