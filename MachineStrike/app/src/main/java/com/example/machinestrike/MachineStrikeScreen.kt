package com.example.machinestrike

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.machinestrike.ui.homescreen.HomeScreen
import androidx.navigation.compose.NavHost
import com.example.machinestrike.ui.multiplayer.MultiplayerScreen
import com.example.machinestrike.ui.settings.SettingsScreen


object Destinations {
    const val HOME = "home"
    const val QUICKPLAY = "quickplay"
    const val MULTIPLAYER = "multiplayer"
    const val SETTINGS = "settings"
}

@Composable
fun MachineStrikeScreen(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController, startDestination = Destinations.HOME) {
        composable(Destinations.HOME) { HomeScreen(navController) }
//        composable(Destinations.QUICKPLAY) { QuickplayScreen(navController) }
        composable(Destinations.MULTIPLAYER) { MultiplayerScreen(navController) }
        composable(Destinations.SETTINGS) { SettingsScreen(navController) }
    }
}