package com.example.machinestrike

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.machinestrike.ui.homescreen.HomeScreen
import androidx.navigation.compose.NavHost
import com.example.machinestrike.ui.collection.CollectionScreen
import com.example.machinestrike.ui.difficulty.DifficultyScreen
import com.example.machinestrike.ui.multiplayer.MultiplayerScreen
import com.example.machinestrike.ui.selectboard.SelectBoardScreen
import com.example.machinestrike.ui.selectpieces.SelectPiecesScreen
import com.example.machinestrike.ui.settings.SettingsScreen


object Destinations {
    const val HOME = "home"
    const val MULTIPLAYER = "multiplayer"
    const val SETTINGS = "settings"
    const val COLLECTION = "collection"
    const val DIFFICULTY = "difficulty"
    const val BOARDSELECT = "board selection"
    const val PIECESELECT = "piece selection"
}

@Composable
fun MachineStrikeScreen(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController, startDestination = Destinations.HOME) {
        composable(Destinations.HOME) { HomeScreen(navController) }
        composable(Destinations.MULTIPLAYER) { MultiplayerScreen(navController) }
        composable(Destinations.SETTINGS) { SettingsScreen(navController) }
        composable(Destinations.COLLECTION) { CollectionScreen(navController) }
        composable(Destinations.DIFFICULTY) { DifficultyScreen(navController) }
        composable(Destinations.BOARDSELECT) { SelectBoardScreen(navController) }
        composable(Destinations.BOARDSELECT) { SelectPiecesScreen(navController) }
    }
}