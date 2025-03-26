package com.example.machinestrike

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.machinestrike.ui.homescreen.HomeScreen
import androidx.navigation.compose.NavHost
import com.example.machinestrike.data.DataSource
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
        val viewModel: MachineStrikeViewModel = viewModel()
        //TODO pass in uiState


        NavHost(
            navController = navController,
            startDestination = Destinations.HOME,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable(route = Destinations.HOME) { backStackEntry ->
                HomeScreen(
                    navController,
//                    backStackEntry = backStackEntry,
                    options = DataSource.homeScreenOptions,
                    modifier = Modifier,
                    viewModel = viewModel,
                )
            }

            composable(Destinations.MULTIPLAYER) { MultiplayerScreen(navController) }

            composable(Destinations.SETTINGS) { SettingsScreen(navController) }

            composable(Destinations.COLLECTION) { CollectionScreen(navController) }

            composable(route = Destinations.DIFFICULTY) {backStackEntry ->

                DifficultyScreen(
                    navController,
                    options = DataSource.difficultyScreenOptions,
//                    backStackEntry = backStackEntry,
                    modifier = Modifier,
                    viewModel = viewModel,
                )
            }

            composable(Destinations.BOARDSELECT) {
                SelectBoardScreen(
                    navController,
                    options = DataSource.selectBoardScreenOptions,
                    navigationOptions = DataSource.BoardSelectSceenNext,
                    modifier = Modifier,
                    viewModel = viewModel,
                )
            }

            composable(Destinations.PIECESELECT) {
                SelectPiecesScreen(
                    navController,
                    navigationOptions = DataSource.PieceSelectScreenNext,
                    modifier = Modifier,
//                    viewModel = viewModel,
                )
            }
        }
    }
}