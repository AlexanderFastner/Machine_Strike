package com.example.machinestrike

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.machinestrike.ui.homescreen.HomeScreen
import androidx.navigation.compose.NavHost
import com.example.machinestrike.ui.MachineStrikeViewModel
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
    viewModel: MachineStrikeViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = Destinations.HOME,
            modifier = Modifier.padding(innerPadding)
        ) {

            //TODO
            //pass is the on button clicked behavior to change uiState

            composable(route = Destinations.HOME) {
                HomeScreen(
                    navController,
                    modifier = Modifier
                        .fillMaxSize()
                )
            }

            composable(Destinations.MULTIPLAYER) { MultiplayerScreen(navController) }

            composable(Destinations.SETTINGS) { SettingsScreen(navController) }

            composable(Destinations.COLLECTION) { CollectionScreen(navController) }

            composable(Destinations.DIFFICULTY) { DifficultyScreen(navController) }

            composable(Destinations.BOARDSELECT) { SelectBoardScreen(navController) }

            composable(Destinations.BOARDSELECT) { SelectPiecesScreen(navController) }
        }
    }
}